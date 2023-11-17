package com.boot.jpa.relation.many2many;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
