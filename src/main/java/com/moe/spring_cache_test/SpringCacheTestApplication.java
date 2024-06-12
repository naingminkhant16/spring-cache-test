package com.moe.spring_cache_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheTestApplication.class, args);
    }

}
