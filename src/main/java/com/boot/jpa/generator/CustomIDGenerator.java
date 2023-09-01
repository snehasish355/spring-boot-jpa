package com.boot.jpa.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) {
        Random random = null;
        int id = 0;
        random = new Random();
        id = random.nextInt(10000);
        return id;
    }
}
