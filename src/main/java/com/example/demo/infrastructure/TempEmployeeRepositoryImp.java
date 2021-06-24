package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeRepository;

@Repository
public class TempEmployeeRepositoryImp implements EmployeeRepository {
    private final List<Employee> db;
    public TempEmployeeRepositoryImp() {
        this.db = new ArrayList<>();
        //初期データとして
        this.db.add(new Employee("123", "Taro"));
    }
    @Override
    public Optional<Employee> findOneById(final String employeeId) {
        return this.db.stream().filter(e -> e.getEmployeeId().equals(employeeId)).findFirst();
    }
}
