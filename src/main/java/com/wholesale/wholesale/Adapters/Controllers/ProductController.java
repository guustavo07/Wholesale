package com.wholesale.wholesale.Adapters.Controllers;

import com.wholesale.wholesale.Domain.Entities.Product;
import com.wholesale.wholesale.Domain.UseCases.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product); // Delegando para o serviço
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id); // Delegando para o serviço
    }

    @GetMapping("/get")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
