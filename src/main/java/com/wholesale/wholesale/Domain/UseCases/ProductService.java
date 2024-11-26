package com.wholesale.wholesale.Domain.UseCases;

import com.wholesale.wholesale.Domain.Entities.Product;
import com.wholesale.wholesale.Infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Exemplo de método de caso de uso
    public Product createProduct(Product product) {
        // A lógica de negócios seria implementada aqui, se necessário
        return productRepository.save(product); // A camada de repositório é chamada aqui
    }

    // Exemplo de outro caso de uso
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        //continuar logica


        return null;
    }
}
