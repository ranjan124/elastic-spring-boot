package com.shieldteq.elastic.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "products")
data class Product(
    @Id
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int
)
