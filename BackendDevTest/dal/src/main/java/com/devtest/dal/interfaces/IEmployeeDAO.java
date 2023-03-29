package com.devtest.dal.interfaces;


import com.devtest.dal.customExpetions.ServiceErrorException;
import com.devtest.model.Employee;

public interface IEmployeeDAO {
    Iterable<Employee> getAllEmployees() throws ServiceErrorException;
    Employee getEmployeeById(int id) throws ServiceErrorException;
}
