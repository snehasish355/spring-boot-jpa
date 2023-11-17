package com.boot.jpa.relation.many2many;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
public class ProgrammerRepositoryTest {

    @Autowired
    private ProgrammerRepository repo;

    @Test
    public void save() {
        HashSet<Project> map = new HashSet<>();
        Project pro = Project.builder().name("JSW").build();
        map.add(pro);
        Programmer p = Programmer.builder().name("Snehasish").salary(100000L).projects(map).build();

        repo.save(p);


    }

    @Test
    //@Transactional
    public void findOne(){
        Programmer pp = repo.findById(1).get();
        System.out.println(pp.getName());
        pp.getProjects().forEach(pr -> System.out.println(pr.getName()));
    }
}
