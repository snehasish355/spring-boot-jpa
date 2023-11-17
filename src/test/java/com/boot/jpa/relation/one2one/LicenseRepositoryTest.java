package com.boot.jpa.relation.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LicenseRepositoryTest {

    @Autowired
    private LicenseRepository repo;

    @Test
    public void save() {
        Person p = Person.builder().name("Snehasish").age(31).build();
        License l = License.builder().type("Scooty").validFrom(LocalDate.now()).validUpto(LocalDate.now()).person(p).build();

        repo.save(l);

    }
}
