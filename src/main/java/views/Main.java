package views;

import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;
import business.manager.ClientManager;
import business.manager.OrderManager;
import business.manager.ProductManager;
import controller.Session;

import javax.swing.*;

public class Main {
    static Session session;
    static JFrame currentFrame;

    public static void main(String[] args) {
        System.setProperty("file.encoding","UTF-8");
        session = new Session();

        //init DB
        ClientManager clientManager = new ClientManager();
        clientManager.initDB();
        ProductManager productManager = new ProductManager();
        productManager.initBD();
        OrderManager orderManager = new OrderManager();
        orderManager.initBD();
        //End DB init

        if(session.processStartUp().equals("loginFrame"))
            loadLoginPage();
    }

    private static void loadLoginPage() {
        currentFrame = new Login();
        currentFrame.setVisible(true);
    }

    static void loadHomePage(Client client, Product product) {
        currentFrame.setVisible(false);
        currentFrame = new Home(client, product);
        currentFrame.setVisible(true);
    }

    static void loadOrderPage(business.entities.Order order) {
        currentFrame.setVisible(false);
        currentFrame = new views.Order(order);
        currentFrame.setVisible(true);
    }

    static void loadAdminHomePage(Client c){
        currentFrame.setVisible(false);
        currentFrame = new views.AdminHome(c);
        currentFrame.setVisible(true);
    }
    static void loadProductAdditionPage(){
        currentFrame.setVisible(false);
        currentFrame = new views.ProductAddition();
        currentFrame.setVisible(true);

    }
    static void loadClientAdditionPage(){
        currentFrame.setVisible(false);
        currentFrame = new views.ClientAddition();
        currentFrame.setVisible(true);
    }
}
