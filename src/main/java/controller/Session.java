package controller;
import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;
import business.manager.ClientManager;
import business.manager.OrderManager;
import business.manager.ProductManager;
import com.sun.org.apache.xpath.internal.operations.Or;
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

    public boolean processOrderValidation(Order o){
        OrderManager orderManager = new OrderManager();
        if (orderManager.validateOrder(o)){
            return true;
        }
        return false;
    }

    public boolean processClientAddition(String lastName, String firstName, String pseudo, String pwd){
        ClientManager clientManager = new ClientManager();
        if (clientManager.addClient(new Client(firstName,lastName,pseudo,pwd))){
            return true;
        }
        return false;
    }

    public boolean processProductAddition(String name, float price, int stock){
        ProductManager productManager = new ProductManager();
        if (productManager.addProduct(new Product(name,price,stock))){
            return true;
        }
        return false;
    }

    public Product processPromotionalSearching(){
        ProductManager productManager = new ProductManager();
        return productManager.getPromotional();
    }
}
