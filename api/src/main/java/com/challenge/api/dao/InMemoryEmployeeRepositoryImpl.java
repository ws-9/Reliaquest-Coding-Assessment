package com.challenge.api.dao;

import com.challenge.api.model.BasicEmployee;
import com.challenge.api.model.Employee;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class InMemoryEmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employees;

    public InMemoryEmployeeRepositoryImpl() {
        employees = new ArrayList<>();
        initEmployees();
    }

    @Override
    public Employee findByUuid(UUID uuid) {
        return employees.stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        employee.setUuid(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    private void initEmployees() {
        if (employees.isEmpty()) {
            employees.addAll(List.of(
                    new BasicEmployee(
                            UUID.randomUUID(),
                            "John",
                            "Smith",
                            50000,
                            41,
                            "Accountant",
                            "johnsmith@email.com",
                            LocalDate.parse("2014-06-20")
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant(),
                            null),
                    new BasicEmployee(
                            UUID.randomUUID(),
                            "Mary",
                            "Sue",
                            55000,
                            60,
                            "Engineer",
                            "marysue@email.com",
                            LocalDate.parse("2000-01-13")
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant(),
                            LocalDate.parse("2022-09-01")
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant()),
                    new BasicEmployee(
                            UUID.randomUUID(),
                            "Alice",
                            "Clark",
                            60000,
                            26,
                            "Manager",
                            "aliceclark@email.com",
                            LocalDate.parse("2020-11-07")
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant(),
                            null)));
        }
    }
}
