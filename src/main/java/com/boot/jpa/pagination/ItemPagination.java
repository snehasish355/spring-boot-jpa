package com.boot.jpa.pagination;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class ItemPagination {

    @Id
    private int id;
    private String name;
    @Column(name = "description")
    private String desc;
    private double price;
}
