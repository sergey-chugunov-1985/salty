package com.sol.test.server.master.datasource.impl;

import com.sol.test.model.task.DataSourceDescriptor;
import com.sol.test.model.task.DataSourceType;
import com.sol.test.server.master.datasource.DataSource;
import com.sol.test.server.master.datasource.DataSourceFactory;

import static com.sol.test.model.task.fs.LocalFSDataSourceDescriptor.PATH_PARAM;

/**
 *
 */
public final class DataSourceFactoryImpl implements DataSourceFactory {
    @Override
    public DataSource getDataSource(DataSourceDescriptor descriptor) {
        if (descriptor.getType() == DataSourceType.LOCAL_FS) {
            Object pathStr = descriptor.getParameters().get(PATH_PARAM);

            return new LocalFSDataSource((String) pathStr);
        }

        return null;
    }
}
