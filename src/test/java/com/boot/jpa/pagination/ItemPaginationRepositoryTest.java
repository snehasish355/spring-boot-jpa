package com.boot.jpa.pagination;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class ItemPaginationRepositoryTest {

    @Autowired
    private ItemPaginationRepository repo;

    @Test
    public void testPagination() {
        // 0 : page number, 1 : number item per page. : If in a table there are 4 records and if used pageSize : 1 there will be one record per page and total of 4 page (0,1,2,3) . If page size 2 then page number (0,1)
        Pageable page = PageRequest.of(0, 1);
        Page<ItemPagination> list = repo.findAll(page);

        list.forEach(item -> System.out.println(item.getName()));
    }

    @Test
    public void testSorting() {
        repo.findAll(Sort.by("name")).forEach(product -> System.out.println(product.getName()));

    }

    @Test
    public void testSortingAndOrder() {
        repo.findAll(Sort.by(Sort.Direction.DESC, "name")).forEach(product -> System.out.println(product.getName()));

    }

    @Test
    public void testSortingByMultiplePropAndOrder() {
        repo.findAll(Sort.by(Sort.Direction.ASC, "name", "price")).forEach(product -> System.out.println(product.getName()));

    }

    @Test
    public void testSortingByMultiplePropAndMultipleOrder() {
        repo.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "name"), new Sort.Order(Sort.Direction.DESC, "price"))).forEach(product -> System.out.println(product.getName()));

    }

    @Test
    public void testPaginationAndSorting() {
        repo.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "name"))).forEach(pro -> System.out.println(pro.getName()));
    }
}
