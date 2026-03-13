package cafeteria.command;

import cafeteria.order.OrderManager;

public class CreateOrderCommand implements Command {

    private OrderManager manager;

    public CreateOrderCommand(OrderManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.createOrder();
        System.out.println("✔ Pedido creado.");
    }

    @Override
    public void undo() {
        System.out.println("↩ Creación de pedido deshecha.");
    }
}