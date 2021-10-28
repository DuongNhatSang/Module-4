package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Vo", 5000.0, "khong", "abc"));
        products.put(2, new Product(2, "Sach", 12000.0, "khong","xyz"));
        products.put(3, new Product(3, "Thuoc", 3000.0, "khong","xyz"));
        products.put(4, new Product(4, "But chi", 4000.0, "khong","xyz"));
        products.put(5, new Product(5, "But bi", 3000.0, "khong","xyz"));
        products.put(6, new Product(6, "Tay", 2000.0, "khong","xyz"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
products.remove(id);
    }
}
