package com.boot.jpa.caching;

import com.boot.jpa.simpleCrud.Product;
import com.boot.jpa.simpleCrud.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CachingTest {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private EntityManager entityManager;


    @Test
    @Transactional
    public void testfetch() {
        repo.findById(1);
        repo.findById(1);
    }

    @Test
    @Transactional
    public void testfetch2() {
        Session session = entityManager.unwrap(Session.class);
        Product p = repo.findById(1).get();
        repo.findById(1);
        session.evict(p);
        repo.findById(1);
    }

}
