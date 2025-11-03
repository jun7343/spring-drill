package io.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class SpringAsyncApp

fun main(args: Array<String>) {
    runApplication<SpringAsyncApp>(*args)
}