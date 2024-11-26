package com.wholesale.wholesale.Configuration;

import com.wholesale.wholesale.Application.UseCases.Product.ProductService;
import com.wholesale.wholesale.Infrastructure.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);  // Injetando o repositório
    }
}
