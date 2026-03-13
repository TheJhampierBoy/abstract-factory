package com.cafeteria.iterator;

import java.util.List;
import com.cafeteria.model.Order;

public class OrderIterator {

    private List<Order> orders;
    private int position = 0;

    public OrderIterator(List<Order> orders) {
        this.orders = orders;
    }

    public boolean hasNext() {
        return position < orders.size();
    }

    public Order next() {
        return orders.get(position++);
    }
}
