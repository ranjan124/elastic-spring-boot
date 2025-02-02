package com.shieldteq.elastic.exceptions

class ProductNotFoundException(override val message: String) : RuntimeException(message)