package com.cafeteria.model;

public class Bebida implements Producto {
    private String nombre;
    private double precio;
    private String descripcion;

    public Bebida(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "  - " + nombre + " (" + getTipo() + "): $" + precio + " - " + descripcion;
    }
}
