package com.cafeteria.iterator;

import java.util.List;
import com.cafeteria.model.Product;

public class ProductIterator {

    private List<Product> products;
    private int position = 0;

    public ProductIterator(List<Product> products) {
        this.products = products;
    }

    public boolean hasNext() {
        return position < products.size();
    }

    public Product next() {
        return products.get(position++);
    }
}
