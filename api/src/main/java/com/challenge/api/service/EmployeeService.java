package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee getEmployee(UUID uuid);

    List<Employee> getAllEmployees();
}
