package com.sol.test.model.task;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

/**
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public interface DataSourceDescriptor {
    DataSourceType getType();

    Map<String, Object> getParameters();
}
