package com.cafeteria.model;

public enum EstadoPedido {
    CREADO("Creado"),
    CONFIRMADO("Confirmado"),
    EN_PREPARACION("En Preparación"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
