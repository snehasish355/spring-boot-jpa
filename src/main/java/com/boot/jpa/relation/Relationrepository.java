package com.boot.jpa.relation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Relationrepository extends CrudRepository<Customer, Integer> {
}
