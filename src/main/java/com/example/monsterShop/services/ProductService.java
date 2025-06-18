package com.example.monsterShop.services;

import com.example.monsterShop.dtos.product.ProductMapper;
import com.example.monsterShop.dtos.product.ProductRequest;
import com.example.monsterShop.dtos.product.ProductResponse;
import com.example.monsterShop.models.Product;
import com.example.monsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public Optional<ProductResponse> getProductById(Long id){
        return productRepository.findById(id).map(product -> ProductMapper.entityToDto(product));
    }

    //addProduct
    public ProductResponse addProduct (ProductRequest productRequest){
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productRequest.name());
                    existingProduct.setDescription(productRequest.description());
                    existingProduct.setPrice(productRequest.price());
                    existingProduct.setImageUrl(productRequest.imageUrl());
                    existingProduct.setFeatured(productRequest.featured());
                    Product updatedProduct = productRepository.save(existingProduct);
                    return ProductMapper.entityToDto(updatedProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
