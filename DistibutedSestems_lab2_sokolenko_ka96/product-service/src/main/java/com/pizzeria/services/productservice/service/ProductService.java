package com.pizzeria.services.productservice.service;

import com.pizzeria.services.productservice.repository.ProductRepository;
import com.pizzeria.services.productservice.repository.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) throws IllegalArgumentException {
        final Optional<Product> maybeProduct = productRepository.findById(id);
        if (maybeProduct.isEmpty()) throw new IllegalArgumentException("Product not found");
        else return maybeProduct.get();
    }

    public long createProduct(String productName, Double price, String category, String size, Long amount) {
        if (!category.equals("Dessert")
                && !category.equals("Pizza")
                && !category.equals("Salat")
                && !category.equals("Drink")
                && !category.equals("Alcohol")) throw  new IllegalArgumentException("Illegal category argumnet");
        final Product product = new Product(productName, price, category, size, amount);
        final Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public void updateProduct(long id, String productName, Double price, String category, String size, Long amount) throws IllegalArgumentException {
        final Optional<Product> maybeProduct = productRepository.findById(id);
        if (maybeProduct.isEmpty()) throw new IllegalArgumentException("Product not found");
        Product product = maybeProduct.get();
        if (productName != null && !productName.isBlank()) product.setProductName(productName);
        if (price != null && !price.isNaN() && !price.isInfinite()) product.setPrice(price);
        if (category != null && !category.isBlank() &&(category.equals("Dessert")
                || category.equals("Pizza")
                || category.equals("Salat")
                || category.equals("Drink")
                || category.equals("Alcohol"))) product.setCategory(category);
        if (size != null && !size.isBlank()) product.setSize(size);
        if (amount != null && amount>0) product.setAmount(amount);
    }

    public void deleteProduct(long id)     {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
}
