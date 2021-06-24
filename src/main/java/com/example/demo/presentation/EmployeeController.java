package com.example.demo.presentation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Employee;
import com.example.demo.usecase.GetEmployeeUsecase;
@RestController
public class EmployeeController {
    @Autowired
    GetEmployeeUsecase getUsecase;
    @GetMapping("/employees/{employeeId}")
    Optional<Employee> getOne(@PathVariable final String employeeId) {
        return this.getUsecase.getEmployee(employeeId);
    }
}
