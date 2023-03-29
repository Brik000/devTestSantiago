package com.devtest.dal.connectionObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDTO {
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("employee_name")
    private String name;
    
    @JsonProperty("employee_salary")
    private int salary;
    
    @JsonProperty("employee_age")
    private int age;
 
    @JsonProperty("profileImage")
    private String profileImage;


    
}
