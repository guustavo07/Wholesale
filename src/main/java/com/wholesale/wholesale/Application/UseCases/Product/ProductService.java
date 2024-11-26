package com.wholesale.wholesale.Application.UseCases.Product;

import com.wholesale.wholesale.Domain.Entities.Product;
import com.wholesale.wholesale.Infrastructure.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

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
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        BeanUtils.copyProperties(updatedProduct, existingProduct, "id", "createdAt");
        return productRepository.save(existingProduct);
    }

    @Transactional
    public void deleteProductById(Long id){
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
            productRepository.delete(existingProduct);
    }
}
