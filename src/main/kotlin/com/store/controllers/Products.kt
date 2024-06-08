package com.store.controllers

import com.store.objects.*
import com.store.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class Products {
    private val productRepository = ProductRepository()

    @GetMapping("/products")
    fun getProducts(@RequestParam(required = false) type: ProductType?) : ResponseEntity<Array<Product>> {
        val products = productRepository.getProducts(type)
        return ResponseEntity(products,HttpStatus.OK)
    }

    @PostMapping("/products")
    fun addProduct(@RequestBody @Valid product: Product) : ResponseEntity<Any> {
        val id = productRepository.addProduct(product)
        return ResponseEntity(ProductId(id),HttpStatus.CREATED)
    }
}