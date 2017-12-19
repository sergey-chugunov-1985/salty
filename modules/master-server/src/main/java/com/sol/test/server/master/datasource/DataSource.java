package com.sol.test.server.master.datasource;

import com.sol.test.comm.model.Batch;

/**
 *
 */
public interface DataSource {
    void open() throws Exception;

    Batch nextBatch();

    void close() throws Exception;
}
