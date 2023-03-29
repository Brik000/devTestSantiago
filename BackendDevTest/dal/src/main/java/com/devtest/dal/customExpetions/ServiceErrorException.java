package com.devtest.dal.customExpetions;

import com.devtest.dal.customError.ServiceError;

import lombok.Data;
@Data
public class ServiceErrorException extends RuntimeException {

    private final ServiceError error;

    public ServiceErrorException(ServiceError error) {
        super(error.getMessage());
        this.error = error;
    }
}

