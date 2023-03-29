package com.devtest.dal.customError;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceError {
    private String message;
    private HttpStatusCode detail;
}
