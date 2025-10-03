package com.challenge.api.service;

import com.challenge.api.dao.EmployeeRepository;
import com.challenge.api.model.BasicEmployee;
import com.challenge.api.model.Employee;
import com.challenge.api.request.CreateEmployeeRequest;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(UUID uuid) {
        return employeeRepository.findByUuid(uuid);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(CreateEmployeeRequest request) {
        return employeeRepository.save(createEmployeeRequestToEmployee(request));
    }

    private Employee createEmployeeRequestToEmployee(CreateEmployeeRequest request) {
        return new BasicEmployee(
                null,
                request.getFirstName(),
                request.getLastName(),
                request.getSalary(),
                request.getAge(),
                request.getJobTitle(),
                request.getEmail(),
                request.getContractHireDate()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant(),
                request.getContractTerminationDate()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant());
    }
}
