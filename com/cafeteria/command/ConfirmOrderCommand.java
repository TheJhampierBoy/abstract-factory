package cafeteria.command;

import cafeteria.order.Order;

public class ConfirmOrderCommand implements Command {

    private Order order;

    public ConfirmOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.confirm();
        System.out.println("✔ Pedido confirmado y pago procesado.");
    }

    @Override
    public void undo() {
        System.out.println("↩ Confirmación de pedido cancelada.");
    }
}