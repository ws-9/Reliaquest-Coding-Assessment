package com.challenge.api.request;

import java.time.LocalDate;

public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private int salary;
    private int age;
    private String jobTitle;
    private String email;
    private LocalDate contractHireDate;
    private LocalDate contractTerminationDate;

    public CreateEmployeeRequest() {}

    public CreateEmployeeRequest(
            String firstName,
            String lastName,
            int salary,
            int age,
            String jobTitle,
            String email,
            LocalDate contractHireDate,
            LocalDate contractTerminationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
        this.jobTitle = jobTitle;
        this.email = email;
        this.contractHireDate = contractHireDate;
        this.contractTerminationDate = contractTerminationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getContractHireDate() {
        return contractHireDate;
    }

    public void setContractHireDate(LocalDate contractHireDate) {
        this.contractHireDate = contractHireDate;
    }

    public LocalDate getContractTerminationDate() {
        return contractTerminationDate;
    }

    public void setContractTerminationDate(LocalDate contractTerminationDate) {
        this.contractTerminationDate = contractTerminationDate;
    }
}
