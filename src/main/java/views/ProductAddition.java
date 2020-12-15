package views;

import business.entities.Client;
import business.entities.Product;
import controller.Session;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ProductAddition extends JFrame {
    public ProductAddition() throws HeadlessException {
        this.setTitle("French Chic - Page d'ajout produit");
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

        JButton ajoutProduit = new JButton("Ajouter produit");
        ajoutProduit.setLocation(200, 370);
        ajoutProduit.setSize(longueur, largeur);

        ajoutProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Session session = new Session();
                if(session.processProductAddition("add",10,100)){
                    errorMessage.setText("Produit ajouté avec succes.");
                }
                else {
                    errorMessage.setText("Ajout Impossible.");
                }
                ajoutProduit.setEnabled(false);

            }
        });

        this.add(errorMessage);
        this.add(ajoutProduit);
    }
}
