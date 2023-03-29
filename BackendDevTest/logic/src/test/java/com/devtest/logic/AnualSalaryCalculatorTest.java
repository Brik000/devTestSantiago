package com.devtest.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devtest.logic.implementation.AnualSalaryCalculator;
import com.devtest.model.Employee;

public class AnualSalaryCalculatorTest {

    private AnualSalaryCalculator anualSalaryCalculator;

    @BeforeEach
    public void setUp() {
        anualSalaryCalculator = new AnualSalaryCalculator();
    }

    @Test
    public void testComputeAnnualSalary() {
        Employee employee = new Employee();
        employee.setEmployee_salary(10000);
        Employee result = anualSalaryCalculator.computeAnnualSalary(employee);
        assertEquals(120000, result.getEmployee_anual_salary());
    }

    @Test
    public void testComputeAnnualSalaries() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee1 = new Employee();
        employee1.setEmployee_salary(10000);
        employees.add(employee1);
        Employee employee2 = new Employee();
        employee2.setEmployee_salary(20000);
        employees.add(employee2);
        Iterable<Employee> iterable = employees;
        Iterable<Employee> result = anualSalaryCalculator.computeAnnualSalaries(iterable);
        List<Employee> resultList = new ArrayList<Employee>();
        result.forEach(resultList::add);
        assertEquals(120000, resultList.get(0).getEmployee_anual_salary());
        assertEquals(240000, resultList.get(1).getEmployee_anual_salary());
    }
}

