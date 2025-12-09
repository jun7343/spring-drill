package com.springcache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class CacheApp

fun main(args: Array<String>) {
    runApplication<CacheApp>(*args)
}