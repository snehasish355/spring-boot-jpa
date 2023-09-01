package com.boot.jpa.pagination;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ItemPaginationRepository extends CrudRepository<ItemPagination, Integer>, PagingAndSortingRepository<ItemPagination, Integer> {

    List<ItemPagination> findByName(String name);

    List<ItemPagination> findByNameAndDesc(String name, String desc);

    List<ItemPagination> findByPriceGreaterThan(double price);

    List<ItemPagination> findByDescContains(String desc);

    List<ItemPagination> findByPriceBetween(double price1, double price2);

    List<ItemPagination> findByDescLike(String desc);

    List<ItemPagination> findByIdIn(List<Integer> ids);

    List<ItemPagination> findByIdIn(List<Integer> ids, Pageable pageable);
}
