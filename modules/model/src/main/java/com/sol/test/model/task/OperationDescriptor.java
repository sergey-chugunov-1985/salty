package com.sol.test.model.task;

/**
 *
 */
public class OperationDescriptor {
    private String mapFunc;

    private String mapFuncName;

    private String reduceFunc;

    private String reduceFuncName;

    public String getMapFunction() {
        return mapFunc;
    }

    public void setMapFunction(String mapFunc) {
        this.mapFunc = mapFunc;
    }

    public String getMapFunctionName() {
        return mapFuncName;
    }

    public void setMapFunctionName(String mapFuncName) {
        this.mapFuncName = mapFuncName;
    }

    public String getReduceFunction() {
        return reduceFunc;
    }

    public void setReduceFunction(String reduceFunc) {
        this.reduceFunc = reduceFunc;
    }

    public String getReduceFunctionName() {
        return reduceFuncName;
    }

    public void setReduceFunctionName(String reduceFuncName) {
        this.reduceFuncName = reduceFuncName;
    }
}
