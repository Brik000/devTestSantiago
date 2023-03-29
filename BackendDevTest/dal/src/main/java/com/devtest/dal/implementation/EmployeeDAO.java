package com.devtest.dal.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.devtest.dal.connectionObjects.EmployeeDTO;
import com.devtest.dal.connectionObjects.FindAllResponse;
import com.devtest.dal.connectionObjects.FindByIdResponse;
import com.devtest.dal.customError.ServiceError;
import com.devtest.dal.customExpetions.ServiceErrorException;
import com.devtest.dal.interfaces.IEmployeeDAO;
import com.devtest.model.Employee;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

    private final static String BASEURL = "https://www.dummy.restapiexample.com/api/v1/";
    private final static String SUCCESS = "success";

    private final RestTemplate restTemplate;

    public EmployeeDAO(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Iterable<Employee> getAllEmployees() throws ServiceErrorException {
        ResponseEntity<FindAllResponse> responseEntity =null;
        try {
         responseEntity = restTemplate.getForEntity(BASEURL + "employees", FindAllResponse.class);
        } catch (HttpClientErrorException e) {
            throw new ServiceErrorException(new ServiceError(e.getStatusCode().value()+"", e.getStatusCode()));
        }
        FindAllResponse response = responseEntity.getBody();
        if (response == null) {
            throw new ServiceErrorException(new ServiceError("Failed to retrieve employees", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    
        return this.map(response.getData());
    }
    

    @Override
    public Employee getEmployeeById(int id) throws ServiceErrorException {
        ResponseEntity<FindByIdResponse> responseEntity =null;
        try {
         responseEntity = restTemplate.getForEntity(BASEURL + "employee/" + id, FindByIdResponse.class);
        } catch (HttpClientErrorException e) {
            throw new ServiceErrorException(new ServiceError(e.getStatusCode().value()+"", e.getStatusCode()));
        }
        
        FindByIdResponse response = responseEntity.getBody();

        if (response == null ) {
            throw new ServiceErrorException(new ServiceError("No employee has that id", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    
        return this.map(response.getData());
    }
    

    public Employee map(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setEmployee_age(employeeDTO.getAge());
        employee.setEmployee_anual_salary(0);
        employee.setEmployee_name(employeeDTO.getName());
        employee.setEmployee_salary(employeeDTO.getSalary());
        employee.setId(employeeDTO.getId());
        employee.setProfileImage(employeeDTO.getProfileImage());
        return employee;
    }

    public Iterable<Employee> map(Iterable<EmployeeDTO> employeeDTOs) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOs) {
            employees.add(map(employeeDTO));
        }
        return employees;
    }

}
