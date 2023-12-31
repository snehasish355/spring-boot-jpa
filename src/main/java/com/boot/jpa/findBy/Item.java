package com.boot.jpa.findBy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product")
public class Item {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name = "description")
    private String desc;
    private double price;
}
