package views;

import business.entities.Client;
import controller.Session;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static Session session;
    static JFrame currentFrame;

    public static void main(String[] args) {
        session = new Session();
        loadLoginPage();
    }

    private static void loadLoginPage() {
        currentFrame = new Login();
        currentFrame.setVisible(true);
    }

    static void loadHomePage(Client client) {
        currentFrame.setVisible(false);
        currentFrame = new Home(client);
        currentFrame.setVisible(true);
    }
}
