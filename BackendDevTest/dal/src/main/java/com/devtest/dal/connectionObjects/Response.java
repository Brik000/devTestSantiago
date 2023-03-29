package com.devtest.dal.connectionObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public abstract class Response<T> {
    @JsonProperty()
    private String status;
    @JsonProperty()
    private T data;
    @JsonProperty()
    private String message;
}
