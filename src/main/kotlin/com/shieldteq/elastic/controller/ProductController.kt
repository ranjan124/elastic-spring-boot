package com.shieldteq.elastic.controller

import com.shieldteq.elastic.entity.Product
import com.shieldteq.elastic.service.ProductService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/product")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun findAll(): Flux<Product> {
        return service.getProducts()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Mono<Product> {
        return service.getProduct(id)
    }

    @PostMapping
    fun create(@RequestBody product: Product): Mono<Product> {
        return service.insertProduct(product)
    }

    @PutMapping
    fun update(@RequestBody product: Product): Mono<Product> {
        return service.updateProduct(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Mono<String> {
        return service.deleteProduct(id)
    }

}