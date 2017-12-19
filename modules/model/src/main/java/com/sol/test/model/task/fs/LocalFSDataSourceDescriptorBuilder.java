package com.sol.test.model.task.fs;

import com.sol.test.model.task.DataSourceDescriptor;

import java.util.HashMap;
import java.util.Map;

import static com.sol.test.model.task.fs.LocalFSDataSourceDescriptor.PATH_PARAM;

/**
 *
 */
public class LocalFSDataSourceDescriptorBuilder {
    private final LocalFSDataSourceDescriptor ds;

    private final Map<String, Object> params = new HashMap<>();

    public LocalFSDataSourceDescriptorBuilder() {
        ds = new LocalFSDataSourceDescriptor();
    }

    public LocalFSDataSourceDescriptorBuilder dataFilePath(String path) {
        params.put(PATH_PARAM, path);

        return this;
    }

    public DataSourceDescriptor build() {
        ds.setParameters(params);

        return ds;
    }
}
