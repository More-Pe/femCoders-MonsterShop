package com.example.monsterShop.services;

import com.example.monsterShop.dtos.product.ProductMapper;
import com.example.monsterShop.dtos.product.ProductResponse;
import com.example.monsterShop.models.Product;
import com.example.monsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //getAllProducts
    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    //getProductById
    public Optional<ProductResponse> getProductById(Long id){
        return productRepository.findById(id).map(product -> ProductMapper.entityToDto(product));
    }

    //addProduct
    //updateProduct
    //deleteProduct
}
