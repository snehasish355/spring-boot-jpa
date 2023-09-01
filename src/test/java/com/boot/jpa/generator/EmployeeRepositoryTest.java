package com.boot.jpa.generator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repo;

    @Test
    public void addEmployee() {
        Employee ee = Employee.builder().name("Subhash").build();
        repo.save(ee);
    }
}
