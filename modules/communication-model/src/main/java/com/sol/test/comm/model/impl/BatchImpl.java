package com.sol.test.comm.model.impl;

import com.sol.test.comm.model.Batch;
import com.sol.test.comm.model.LongBiTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class BatchImpl extends Batch<LongBiTuple> {
    private int s;

    public BatchImpl() {
        setValues(new ArrayList<>());
    }

    public void addValue(long first, long second) {
        s++;

        getValues().add(new LongBiTupleImpl(first, second));
    }

}
