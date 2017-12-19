package com.sol.test.server.master;

import com.sol.test.comm.model.Batch;
import com.sol.test.comm.model.LongBiTuple;
import com.sol.test.model.task.OperationDescriptor;
import com.sol.test.model.task.TaskDescriptor;
import com.sol.test.server.master.datasource.DataSource;
import com.sol.test.server.master.datasource.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.function.BiFunction;

/**
 *
 */
@RestController
public class ComputationServer {
    private static Logger LOG = LoggerFactory.getLogger(ComputationServer.class);

    @Autowired
    private DataSourceFactory dsFactory;

    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public Long compute(@RequestBody TaskDescriptor taskDescriptor) throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        final ScriptEngine groovyEng = mgr.getEngineByName("groovy");

        evalOperations(groovyEng, taskDescriptor.getOperationDescriptor());

        final BiFunction<Long, Long, Long> mapF = getFunction((Invocable) groovyEng, taskDescriptor.getOperationDescriptor().getMapFunctionName());
        final BiFunction<Long, Long, Long> reduceF = getFunction((Invocable) groovyEng, taskDescriptor.getOperationDescriptor().getReduceFunctionName());

        DataSource ds = dsFactory.getDataSource(taskDescriptor.getDataSourceDescriptor());

        long fullRes = 0;

        try {
            ds.open();

            while(true) {
                Batch<LongBiTuple> b = ds.nextBatch();

                if (b.getValues().size() == 0)
                    break;

                long nextRes = b.stream().parallel()
                        .map(longBiTuple -> mapF.apply(longBiTuple.first(), longBiTuple.second()))
                        .reduce(0L, (aLong0, aLong1) -> reduceF.apply(aLong0, aLong1));

                fullRes = reduceF.apply (fullRes, nextRes);
            }
        } finally {
            ds.close();
        }

        return fullRes;
    }

    private BiFunction<Long, Long, Long> getFunction(final Invocable inv, final String funcName) {
        return (aLong0, aLong1) -> {
            try {
                return (Long) inv.invokeFunction(funcName, aLong0, aLong1);
            } catch (ScriptException e) {
                return 0L;
            } catch (NoSuchMethodException e) {
                return 0L;
            }
        };
    }

    private void evalOperations(ScriptEngine groovyEng, OperationDescriptor operationDescriptor) throws ScriptException {
        groovyEng.eval(operationDescriptor.getMapFunction());

        groovyEng.eval(operationDescriptor.getReduceFunction());
    }
}
