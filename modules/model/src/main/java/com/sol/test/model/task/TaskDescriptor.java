package com.sol.test.model.task;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public interface TaskDescriptor {
    OperationDescriptor getOperationDescriptor();

    DataSourceDescriptor getDataSourceDescriptor();
}
