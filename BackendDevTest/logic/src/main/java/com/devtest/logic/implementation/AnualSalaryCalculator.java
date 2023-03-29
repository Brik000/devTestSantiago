package com.devtest.logic.implementation;



import org.springframework.stereotype.Service;

import com.devtest.logic.interfaces.IAnualSalaryCalculator;
import com.devtest.model.Employee;

@Service
public class AnualSalaryCalculator implements IAnualSalaryCalculator{

    public Employee computeAnnualSalary(Employee employee) {
        employee.setEmployee_anual_salary(employee.getEmployee_salary() * 12);
        return employee;
     }
     
     public Iterable<Employee> computeAnnualSalaries(Iterable<Employee> employees) {
        employees.forEach(employee -> employee.setEmployee_anual_salary(employee.getEmployee_salary() * 12));
        return employees;
    }
}
