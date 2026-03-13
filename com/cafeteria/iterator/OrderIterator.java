package com.cafeteria.iterator;
import java.util.List;
public class OrderIterator {

    private List<String> orders;
    private int index = 0;

    public OrderIterator(List<String> orders) {
        this.orders = orders;
    }

    public boolean hasNext() {
        return index < orders.size();
    }

    public String next() {
        return orders.get(index++);
    }
}