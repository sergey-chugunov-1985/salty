package com.sol.test.server.master.datasource;

import com.sol.test.model.task.DataSourceDescriptor;

/**
 *
 */
public interface DataSourceFactory {
    DataSource getDataSource(DataSourceDescriptor descriptor);
}
