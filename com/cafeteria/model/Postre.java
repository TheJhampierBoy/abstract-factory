package com.cafeteria.model;

public class Postre implements Producto {
    private String nombre;
    private double precio;
    private String descripcion;

    public Postre(String nombre, double precio, String descripcion) {
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
        return "Postre";
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
