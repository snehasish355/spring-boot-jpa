package com.boot.jpa.relation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RelationrepositoryTest {

    @Autowired
    private Relationrepository repo;

    @Test
    void save() {
        Customer c = Customer.builder().name("Remo").build();

        PhoneNumber p1 = PhoneNumber.builder().number("1234567890").type("Work").build();
        PhoneNumber p2 = PhoneNumber.builder().number("0987654321").type("Home").build();

        c.addPhoneNumber(p1);
        c.addPhoneNumber(p2);

        repo.save(c);
    }

    @Test
    public void fetch() {
        Customer cc = repo.findById(1).get();
        System.out.println(cc.getName());
        System.out.println(cc.getNumbers().toString());

    }

    @Test
    void delete() {
        repo.deleteAll();
    }
}
