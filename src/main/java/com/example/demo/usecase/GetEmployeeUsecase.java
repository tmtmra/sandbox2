package com.example.demo.usecase;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeRepository;

@Service
public class GetEmployeeUsecase {
    @Autowired
    EmployeeRepository repository;
    public Optional<Employee> getEmployee(final String employeeId) {
        return this.repository.findOneById(employeeId);
    }
}
