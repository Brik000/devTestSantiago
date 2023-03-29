package com.devtest.controller.implementation;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtest.controller.interfaces.IEmployeeController;
import com.devtest.dal.customError.ServiceError;
import com.devtest.dal.customExpetions.ServiceErrorException;
import com.devtest.logic.interfaces.IEmployeeService;
import com.devtest.model.Employee;

@RequestMapping("employee")
@RestController
@CrossOrigin("*")
public class EmployeeController implements IEmployeeController{

    @Autowired
    private IEmployeeService service;

    @Override
    @GetMapping("")
    public Iterable<Employee> findAll() throws ServiceErrorException {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Employee findById(int id) throws ServiceErrorException {
        return service.findById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceError> handleException(ServiceErrorException ex) {
        return ResponseEntity.status(ex.getError().getDetail()).body(ex.getError());
    }
    
}
