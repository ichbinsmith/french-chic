package business.manager;

import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders;

    public OrderManager() {
        this.init();
    }
    private void init() {
        ArrayList<Order> orderList = new ArrayList<>();
        this.orders = orderList;
    }

    public void addOrder(Order o){
        this.orders.add(o);
    }

    public Order createNewOrder(Client client, Product product, int quantity){
        OrderItem orderItem = new OrderItem(product,quantity);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        Order order = new Order(orderItems,client);
        return order;
    }
    public Order createNewOrder(Client client){
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order(orderItems,client);
        return order;
    }

    public boolean validateOrder(Order order){
        /*Add order to DB & decrease its products stocks*/
        return true;
    }
}
