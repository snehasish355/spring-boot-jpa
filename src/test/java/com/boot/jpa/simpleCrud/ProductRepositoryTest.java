package com.boot.jpa.simpleCrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void addProduct() {
        Product p = Product.builder().id(1).name("Radio").desc("XHDATA-D808").price(8900d).build();
        repo.save(p);
    }

    @Test
    public void addProducts() {
        List<Product> products = Arrays.asList(Product.builder().id(2).name("Phone").desc("Iphone").price(89000d).build(),
                Product.builder().id(3).name("TV").desc("Sony Amoled").price(890000d).build());
        repo.saveAll(products);
    }

    @Test
    public void findProduct() {
        // findAll(); findById(<id>); findAllById(<entityList>)
        Optional<Product> pp = repo.findById(1);
        if (pp.isPresent()) {
            System.out.println("*************************   :  " + pp.get());

            assertNotNull(pp.get());
            assertEquals("Radio", pp.get().getName());
        } else {
            System.out.println("No valid product");
        }
    }

    @Test
    public void testUpdateProduct() {
        Product product = repo.findById(1).get();
        product.setPrice(8990d);
        repo.save(product);

    }

    @Test
    public void testDeleteProduct() {
        Product product = repo.findById(3).get();
        repo.delete(product);

    }

    @Test
    public void testCountProduct() {
        System.out.println("---------------------------->>>>>>>>>>>>" + repo.existsById(1));
        System.out.println("-----------------------> Count : " + repo.count());

    }
}
