package com.cafeteria.model;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos;

    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public int getCantidadPedidos() {
        return pedidos.size();
    }

    public void limpiar() {
        pedidos.clear();
    }
}
