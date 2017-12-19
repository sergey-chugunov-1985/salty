package com.sol.test.comm.model;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class Batch<T> {
    private List<T> values;

    public Batch() {
    }

    public Batch(List<T> values) {
        this.values = values;
    }

    public List<T> getValues() { return values; }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public Stream<T> stream() {
        return values.stream();
    }
}
