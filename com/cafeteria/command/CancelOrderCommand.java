package cafeteria.command;

import cafeteria.order.Order;

public class CancelOrderCommand implements Command {

    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
        System.out.println("✔ Pedido cancelado.");
    }

    @Override
    public void undo() {
        System.out.println("↩ Cancelación revertida. Pedido restaurado.");
    }
}