package com.shieldteq.elastic.service

import com.shieldteq.elastic.entity.Product
import com.shieldteq.elastic.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProducts(): List<Product> {
        return this.productRepository.findAll().toList()
    }

    fun getProduct(productId: String): Product {
        return productRepository.findById(productId).orElseThrow {
            throw RuntimeException("Product with id $productId not found")
        }
    }

    fun insertProduct(product: Product): Product {
        productRepository.findById(product.id).ifPresent {
            throw RuntimeException("Product with id ${product.id} already exists")
        }
        return productRepository.save(product)
    }

    fun updateProduct(product: Product): Product {
        return productRepository.findById(product.id).orElseThrow {
            throw RuntimeException("Product with id ${product.id} not found")
        }.let { productRepository.save(it.copy(name = product.name, description = product.description, price = product.price, quantity = product.quantity)) }
    }

    fun deleteProduct(productId: String): String {
        return productRepository.findById(productId).orElseThrow {
            throw RuntimeException("Product with id $productId not found")
        }.let {
            productRepository.delete(it)
            it.id
        }
    }
}