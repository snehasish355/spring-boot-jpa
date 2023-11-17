package com.boot.jpa.findBy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ItemRepository repo;

    @GetMapping(value = "/saveAll")
    @Transactional
    public String saved(){

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

        return "Success";
    }
}
