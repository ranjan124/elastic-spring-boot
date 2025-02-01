package com.shieldteq.elastic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ElasticApplication

fun main(args: Array<String>) {
    runApplication<ElasticApplication>(*args)
}
