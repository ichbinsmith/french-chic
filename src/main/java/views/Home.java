package views;

import business.entities.Client;
import controller.Session;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends JFrame {
    public Home(Client c) throws HeadlessException {
        this.setTitle("French Chic - Login");
        this.setSize(650, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        this.setContentPane(accueilPanel);
        this.setLayout(null);

        JLabel title = new JLabel("Home Page");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

        JLabel clientNameLabel = null;

        clientNameLabel = new JLabel(c.toString());
        clientNameLabel.setSize(120, 20);
        clientNameLabel.setLocation(150, 200);

        this.add(title);
        this.add(clientNameLabel);
    }
}
