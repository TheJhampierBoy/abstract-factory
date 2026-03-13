package com.cafeteria.model;

import com.cafeteria.strategy.PaymentStrategy;
import com.cafeteria.observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 1;
    
    private int id;
    private String cliente;
    private List<Producto> productos;
    private EstadoPedido estado;
    private PaymentStrategy estrategiaPago;
    private List<OrderObserver> observadores;
    private double descuento;

    public Pedido(String cliente) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = EstadoPedido.CREADO;
        this.observadores = new ArrayList<>();
        this.descuento = 0;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public PaymentStrategy getEstrategiaPago() {
        return estrategiaPago;
    }

    public void setEstrategiaPago(PaymentStrategy estrategiaPago) {
        this.estrategiaPago = estrategiaPago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void removerProducto(Producto producto) {
        productos.remove(producto);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() - descuento;
    }

    public void agregarObservador(OrderObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(OrderObserver observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (OrderObserver observador : observadores) {
            observador.actualizar(this);
        }
    }

    public String getDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Pedido #").append(id).append(" ===\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Estado: ").append(estado.getDescripcion()).append("\n");
        sb.append("Productos:\n");
        for (Producto producto : productos) {
            sb.append("  - ").append(producto.getNombre())
              .append(" ($").append(producto.getPrecio()).append(")\n");
        }
        sb.append("Subtotal: $").append(getSubtotal()).append("\n");
        if (descuento > 0) {
            sb.append("Descuento: -$").append(descuento).append("\n");
        }
        sb.append("Total: $").append(getTotal()).append("\n");
        if (estrategiaPago != null) {
            sb.append("Método de pago: ").append(estrategiaPago.getNombre()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Cliente: " + cliente + " - Estado: " + estado.getDescripcion();
    }
}
