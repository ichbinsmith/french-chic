package views;

import business.entities.Client;
import business.entities.Order;
import business.entities.Product;
import controller.Session;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static Session session;
    static JFrame currentFrame;

    public static void main(String[] args) {
        System.setProperty("file.encoding","UTF-8");
        session = new Session();
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
}
