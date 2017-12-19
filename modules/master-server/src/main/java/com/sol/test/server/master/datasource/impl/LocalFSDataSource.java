package com.sol.test.server.master.datasource.impl;

import com.sol.test.comm.model.Batch;
import com.sol.test.server.master.datasource.DataSource;
import com.sol.test.comm.model.impl.BatchImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class LocalFSDataSource implements DataSource {
    private static final int DEFAULT_BATCH_SIZE = 10_000;

    private int batchSize = DEFAULT_BATCH_SIZE;

    /** */
    private Path sourcePath;

    /** */
    private BufferedReader r;

    public LocalFSDataSource(String pathString) {
        sourcePath = Paths.get(pathString);
    }

    @Override
    public void open() throws Exception {
        r = Files.newBufferedReader(sourcePath);
    }

    public void close() throws Exception {
        r.close();
    }

    @Override
    public Batch nextBatch() {
        BatchImpl b = new BatchImpl();

        try {
            String line;
            for (int i = 0; i < batchSize; i++) {
                if ((line = r.readLine()) != null) {
                    String[] parts = line.split(" ");

                    b.addValue(Long.valueOf(parts[0]), Long.valueOf(parts[1]));
                } else
                    return b;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }
}
