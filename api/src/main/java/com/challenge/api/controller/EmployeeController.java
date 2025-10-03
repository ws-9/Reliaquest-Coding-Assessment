package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.request.CreateEmployeeRequest;
import com.challenge.api.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@Tag(name = "Employee Controller", description = "Retrieve and write information about employees")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    @Operation(summary = "Get an employee", description = "Retrieve a an employee by UUID")
    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        return employeeService.getEmployee(uuid);
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */
    @Operation(summary = "Create an employee", description = "Create a new employee with new information")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody CreateEmployeeRequest requestBody) {
        return employeeService.createEmployee(requestBody);
    }
}
