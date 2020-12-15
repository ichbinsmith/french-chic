package views;

import business.entities.Client;
import business.entities.Product;
import controller.Session;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClientAddition extends JFrame {
    public ClientAddition() throws HeadlessException {
        this.setTitle("French Chic - Page d'ajout client");
        this.setSize(650, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        this.setContentPane(accueilPanel);
        this.setLayout(null);

        JLabel title = new JLabel("French Chic");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);
        int longueur = 200;
        int largeur = 30;


        JLabel errorMessage = new JLabel("");
        errorMessage.setLocation(250,355);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("",Font.PLAIN,10));
        errorMessage.setSize(185, 20);

        JButton ajouterClient = new JButton("Ajouter client");
        ajouterClient.setLocation(200, 370);
        ajouterClient.setSize(longueur, largeur);

        ajouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Session session = new Session();
                if(session.processClientAddition("add","add","add","add")){
                    errorMessage.setText("Client ajouté avec succes.");
                    ajouterClient.setEnabled(false);
                }
                else {
                    errorMessage.setText("Ajout Impossible.");
                    ajouterClient.setEnabled(false);
                }
            }
        });

        this.add(errorMessage);
        this.add(ajouterClient);
    }
}
