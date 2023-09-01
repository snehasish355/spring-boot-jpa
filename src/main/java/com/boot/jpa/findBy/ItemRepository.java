package com.boot.jpa.findBy;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByName(String name);

    List<Item> findByNameAndDesc(String name, String desc);

    List<Item> findByPriceGreaterThan(double price);

    List<Item> findByDescContains(String desc);

    List<Item> findByPriceBetween(double price1, double price2);

    List<Item> findByDescLike(String desc);

    List<Item> findByIdIn(List<Integer> ids);
}
