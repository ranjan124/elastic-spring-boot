package com.shieldteq.elastic.repository

import com.shieldteq.elastic.entity.Product
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : ElasticsearchRepository<Product, String> {
}