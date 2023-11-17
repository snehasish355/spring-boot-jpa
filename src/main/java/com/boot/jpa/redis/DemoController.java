package com.boot.jpa.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping(value = "/getProduct/{id}")
    public CacheProduct getProduct(@PathVariable int id) {
        return service.fetchProductById(id);
    }

    @GetMapping(value = "/getCacheProduct/{id}")
    public CacheProduct getCacheProduct(@PathVariable int id) {
        return service.getCacheProduct(id);
    }

    @DeleteMapping(value = "/deleteCache")
    public String evictAll(){
        service.evictAll();
        return "Success";
    }
}
