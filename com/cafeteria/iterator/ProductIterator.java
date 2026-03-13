package com.cafeteria.iterator;

import java.util.List;

public class ProductIterator {

    private List<String> products;
    private int index = 0;

    public ProductIterator(List<String> products) {
        this.products = products;
    }

    public boolean hasNext() {
        return index < products.size();
    }

    public String next() {
        return products.get(index++);
    }
}