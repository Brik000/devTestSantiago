package com.devtest.controller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

import com.devtest.model.Employee;

public interface IEmployeeController {
    public Iterable<Employee> findAll() throws Exception;
	public Employee findById (@PathVariable("id") int id) throws Exception;

}
