package com.sol.test.model.task.fs;

import com.sol.test.model.task.Batch;
import com.sol.test.model.task.DataSourceDescriptor;
import com.sol.test.model.task.DataSourceType;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class LocalFSDataSourceDescriptor implements DataSourceDescriptor {
    public static final String PATH_PARAM = "PATH";

    private Map<String, Object> params;

    public LocalFSDataSourceDescriptor() {

    }

    @Override
    public DataSourceType getType() {
        return DataSourceType.LOCAL_FS;
    }

    public void setType() {

    }

    public Map<String, Object> getParameters() {
        return params;
    }

    public void setParameters(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "LocalFSDataSource{" +
                "params=" + params +
                '}';
    }
}
