package cafeteria.command;

import cafeteria.iterator.ProductIterator;
import cafeteria.order.Order;

public class ShowOrderCommand implements Command {

    private Order order;

    public ShowOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("\n📋 Productos del pedido:");
        ProductIterator iterator = order.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println("  " + count++ + ". " + iterator.next());
        }
        if (count == 1) {
            System.out.println("  (Sin productos aún)");
        }
    }

    @Override
    public void undo() {
        System.out.println("↩ No hay acción que deshacer para mostrar pedido.");
    }
}