package com.devtest.logic.interfaces;

import com.devtest.dal.customExpetions.ServiceErrorException;
import com.devtest.model.Employee;

public interface IEmployeeService {
    public Iterable<Employee> findAll() throws ServiceErrorException ;
    public Employee findById (int id) throws ServiceErrorException ;
}
