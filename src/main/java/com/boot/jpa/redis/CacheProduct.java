package com.boot.jpa.redis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PRODUCT")
public class CacheProduct implements Serializable {

    @Id
    private int id;
    private String name;
    @Column(name = "description")
    private String desc;
    private double price;
}
