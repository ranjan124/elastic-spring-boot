package com.shieldteq.elastic.controller

import com.shieldteq.elastic.entity.Product
import com.shieldteq.elastic.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun findAll(): List<Product> {
        return service.getProducts()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Product {
        return service.getProduct(id)
    }

    @PostMapping
    fun create(@RequestBody product: Product): Product {
        return service.insertProduct(product)
    }

    @PutMapping
    fun update(@RequestBody product: Product): Product {
        return service.updateProduct(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): String {
        return service.deleteProduct(id)
    }

}