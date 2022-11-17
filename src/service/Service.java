package service;

import entity.Product;
import enums.Category;

import java.util.List;

public interface Service {
    Object getProductById(String productId);

    <T extends Product> void createProduct(T product);

    void deleteProductById(String productId);

    <T extends Product> void updateProduct(T product, String productId);

    List<Object> listAllProducts(Category category);

    List<Object> filterByBrand(String brandName);

    void printProducts(List<Object> products);

    void printProduct(Object product);

    List<Object> filterByCategory(Category category);

    void printFilteredProducts(String brandFilter, Category categoryFilter);

    void printFilteredProducts(Category categoryFilter);

}
