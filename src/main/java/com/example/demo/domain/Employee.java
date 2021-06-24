package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {
    private String employeeId;
    private String name;
    @SuppressWarnings("unused")
    private Employee() {
    }
}
