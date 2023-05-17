package ru.netology.product.product.manager.service;

import ru.netology.product.product.manager.product.item.Product;
import ru.netology.product.product.manager.product.product.repo.ProductRepository;

public class ProductManager {

    private ProductRepository repo = new ProductRepository();
    private Product[] items = new Product[0];
    private Product product = new Product();

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.add(item);
    }

    public Product[] searchByText(String text) {
        Product[] result = new Product[0];
        for (Product item : repo.getItems()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = item;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}