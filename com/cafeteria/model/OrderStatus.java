package com.cafeteria.model;

public enum OrderStatus {
    CREATED("Created"),
    CONFIRMED("Confirmed"),
    IN_PREPARATION("In Preparation"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
