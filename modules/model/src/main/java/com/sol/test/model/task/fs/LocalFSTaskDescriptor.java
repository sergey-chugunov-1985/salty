package com.sol.test.model.task.fs;

import com.sol.test.model.task.DataSourceDescriptor;
import com.sol.test.model.task.OperationDescriptor;
import com.sol.test.model.task.TaskDescriptor;

/**
 *
 */

public class LocalFSTaskDescriptor implements TaskDescriptor {
    private DataSourceDescriptor ds;

    private OperationDescriptor opDescr;

    public LocalFSTaskDescriptor() {

    }

    @Override
    public OperationDescriptor getOperationDescriptor() {
        return opDescr;
    }

    public void setOperationDescriptor(OperationDescriptor opDescr) {
        this.opDescr = opDescr;
    }

    @Override
    public DataSourceDescriptor getDataSourceDescriptor() {
        return ds;
    }

    public void setDataSourceDescriptor(DataSourceDescriptor dataSource) {
        ds = dataSource;
    }

    @Override
    public String toString() {
        return "LocalFSTaskDescriptor{" +
                "ds=" + ds +
                '}';
    }
}
