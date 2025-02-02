package com.shieldteq.elastic.repository

import com.shieldteq.elastic.entity.Product
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : ReactiveElasticsearchRepository<Product, String> {
}