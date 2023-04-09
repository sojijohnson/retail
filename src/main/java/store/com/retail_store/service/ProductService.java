package store.com.retail_store.service;

import store.com.retail_store.customer.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);
}
