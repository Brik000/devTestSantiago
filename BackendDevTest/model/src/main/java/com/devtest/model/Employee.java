package com.devtest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Employee extends User{
    private String employee_name;
    private double employee_salary;
    private int employee_age;
    private double employee_anual_salary;
}
