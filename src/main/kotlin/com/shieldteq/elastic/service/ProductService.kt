package com.shieldteq.elastic.service

import com.shieldteq.elastic.entity.Product
import com.shieldteq.elastic.exceptions.ProductNotFoundException
import com.shieldteq.elastic.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun getProducts(): Flux<Product> {
        return this.productRepository.findAll()
    }

    fun getProduct(productId: String): Mono<Product> {
        return productRepository.findById(productId)
            .switchIfEmpty(Mono.error(ProductNotFoundException("Product not found")))
    }

    fun insertProduct(product: Product): Mono<Product> {
        return productRepository.findById(product.id)
            .flatMap { Mono.error<Product>(RuntimeException("User '$product' already exists.")) }
            .switchIfEmpty(productRepository.save(product))
    }


    fun updateProduct(product: Product): Mono<Product> {
        return productRepository.findById(product.id)
            .switchIfEmpty(Mono.error(RuntimeException("Product with id ${product.id} not found")))
            .flatMap { productRepository.save(it.copy(name = product.name, description = product.description, price = product.price, quantity = product.quantity)) }
    }

    fun deleteProduct(productId: String): Mono<String> {
        return productRepository.findById(productId)
            .switchIfEmpty(Mono.error(RuntimeException("Product with id $productId not found")))
            .flatMap { productRepository.delete(it).then(Mono.just(productId)) }
    }
}