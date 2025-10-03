package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.request.CreateEmployeeRequest;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee getEmployee(UUID uuid);

    List<Employee> getAllEmployees();

    Employee createEmployee(CreateEmployeeRequest request);
}
