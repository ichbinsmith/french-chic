package controller;
import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;
import business.manager.ClientManager;
import business.manager.OrderManager;
import business.manager.ProductManager;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import javax.swing.*;

public class Session {
    static ClientManager clientManager = new ClientManager();
    static ProductManager productManager = new ProductManager();
    static OrderManager orderManager = new OrderManager();
    static Client client;
    static Order order;

    public String processStartUp(){
        return "loginFrame";
    }
    //add client as static attribute
    public ImmutableTriple<Client, Product, String> processLogin(String pseudo, String password) {
        Client c = clientManager.getClient(pseudo,password);
        client = c;
        Product p = productManager.getTodaySpecial();
        if(c!=null)
            return new ImmutableTriple<>(c,p,"homeFrame");
        return null;
    }

    public ImmutablePair<Order,String> processProductAddition(Product product, int quantity){
        boolean performed;
        if (order == null) order = orderManager.createNewOrder(client);
        performed = order.addItem(product,quantity);

        if(performed) return new ImmutablePair<>(order,"orderFrame");
        else return new ImmutablePair<>(null,"notOrderFrame");
    }
}
