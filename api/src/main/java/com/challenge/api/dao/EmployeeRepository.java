package com.challenge.api.dao;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

public interface EmployeeRepository {
    Employee findByUuid(UUID uuid);

    List<Employee> findAll();

    Employee save(Employee employee);
}
