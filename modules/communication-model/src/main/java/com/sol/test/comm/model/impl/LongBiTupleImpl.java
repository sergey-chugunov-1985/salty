package com.sol.test.comm.model.impl;

import com.sol.test.comm.model.LongBiTuple;

/**
 * Created by Sergey Chugunov on 10.12.2017.
 */
public class LongBiTupleImpl implements LongBiTuple {
    private final long first;
    private final long second;

    public LongBiTupleImpl(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public long first() {
        return first;
    }

    @Override
    public long second() {
        return second;
    }
}
