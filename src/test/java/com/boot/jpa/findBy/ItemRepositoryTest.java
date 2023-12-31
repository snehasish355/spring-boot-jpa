package com.boot.jpa.findBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repo;


    @Test
    public void testSaveAll() {
        List<Item> list = Arrays.asList(
                Item.builder().name("Xiaomi").desc("Good phone").price(100).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(200).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(300).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(400).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(500).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(600).build(),
                Item.builder().name("Xiaomi").desc("Good phone").price(700).build()
        );

        repo.saveAll(list);
    }


}
