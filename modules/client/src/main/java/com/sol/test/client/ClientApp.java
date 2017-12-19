package com.sol.test.client;

import com.sol.test.model.task.OperationDescriptor;
import com.sol.test.model.task.TaskDescriptor;
import com.sol.test.model.task.fs.LocalFSDataSourceDescriptorBuilder;
import com.sol.test.model.task.fs.LocalFSTaskDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 */
public class ClientApp {
    private static final Logger LOG = LoggerFactory.getLogger(ClientApp.class);

    public static void main(String[] args) throws Exception {
        if (args.length < 2)
            throw new IllegalArgumentException("Parameters are expected in the following order: data file path, f1 name, f1 body, f2 name, f2 body");

        RestTemplate template = new RestTemplate();

        LocalFSTaskDescriptor taskDescriptor = new LocalFSTaskDescriptor();

        taskDescriptor.setDataSourceDescriptor(new LocalFSDataSourceDescriptorBuilder().dataFilePath(args[0]).build());

        OperationDescriptor opDescr = new OperationDescriptor();

        opDescr.setMapFunctionName(args[1]);
        opDescr.setMapFunction(args[2]);
        opDescr.setReduceFunctionName(args[3]);
        opDescr.setReduceFunction(args[4]);

        taskDescriptor.setOperationDescriptor(opDescr);

        HttpEntity<TaskDescriptor> requestEntity = new HttpEntity<>(taskDescriptor);

        Long result = template.postForObject("http://localhost:8080/compute", requestEntity, Long.class);

        LOG.info(String.format("Calculation result: %s", result.toString()));
    }
}
