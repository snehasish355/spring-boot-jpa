package com.boot.jpa.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository repo;

    @Autowired
    private RedisConfig redisCacheManager;

     @Cacheable(value = "CacheProduct", key = "#id", cacheManager = "redisCacheManager")
    public CacheProduct fetchProductById(int id) {
        CacheProduct pro = null;
        if (redisCacheManager.redisTemplate().hasKey(String.valueOf(1)).booleanValue()) {
            return  (CacheProduct) redisCacheManager.redisTemplate().opsForValue().get(String.valueOf(id));
        } else {
            pro = repo.findById(id).get();
            redisCacheManager.redisTemplate().opsForValue().set(String.valueOf(id), pro);
        }
        return pro;
    }

    // @Cacheable(value = "Product", key = "#id")
    public CacheProduct getCacheProduct(int id) {
        return (CacheProduct) redisCacheManager.redisTemplate().opsForValue().get(String.valueOf(id));
    }

    @CacheEvict(value = "CacheProduct", allEntries = true)
    public void evictAll() {
        // TODO document why this method is empty
    }
}
