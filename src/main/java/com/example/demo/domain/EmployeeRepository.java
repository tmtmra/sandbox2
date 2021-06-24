package com.example.demo.domain;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findOneById(String employeeId);
}
