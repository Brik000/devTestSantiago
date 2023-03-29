package com.devtest.logic.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtest.dal.customExpetions.ServiceErrorException;
import com.devtest.dal.interfaces.IEmployeeDAO;
import com.devtest.logic.interfaces.IAnualSalaryCalculator;
import com.devtest.logic.interfaces.IEmployeeService;
import com.devtest.model.Employee;
@Service
public class EmployeeService implements IEmployeeService{
    
    @Autowired
    IAnualSalaryCalculator calculator;

    @Autowired
    IEmployeeDAO employeeDAO;
    
    @Override
    public Iterable<Employee> findAll() throws ServiceErrorException {
       return calculator.computeAnnualSalaries(employeeDAO.getAllEmployees());
        
    }

    @Override
    public Employee findById(int id) throws ServiceErrorException {
        return calculator.computeAnnualSalary(employeeDAO.getEmployeeById(id));
    }


}
