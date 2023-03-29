package com.devtest.logic.interfaces;


import com.devtest.model.Employee;

public interface IAnualSalaryCalculator {
    public Employee computeAnnualSalary(Employee employee);
    public Iterable<Employee> computeAnnualSalaries(Iterable<Employee> employees);
    
}
