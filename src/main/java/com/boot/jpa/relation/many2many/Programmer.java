package com.boot.jpa.relation.many2many;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PROGRAMMERS_PROJECTS",
            joinColumns = @JoinColumn(name = "PROGRAMMER_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id"))
    protected Set<Project> projects;

}
