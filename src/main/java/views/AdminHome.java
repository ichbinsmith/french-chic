package views;

import business.entities.Client;
import business.entities.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminHome extends JFrame {
    public AdminHome(Client c) throws HeadlessException {
        this.setTitle("French Chic - Page d'acueil Admin");
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

        JLabel bonjourTexte = null;
        JLabel produitDuJourTexte = null;
        JLabel quantiteLabel = null;
        JLabel stockLabel = null;

        String bonjourTxt = "Bonjour " + c.getFirstName() + " " + c.getLastName();
        bonjourTexte = new JLabel(bonjourTxt);
        bonjourTexte.setSize(250, 20);
        bonjourTexte.setLocation(150, 100);

        int longueur = 200;
        int largeur = 30;

        JButton ajouterProduit = new JButton("Ajouter produit");
        ajouterProduit.setLocation(100, 200);
        ajouterProduit.setSize(longueur, largeur);

        ajouterProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    Main.loadProductAdditionPage();
            }
        });

        JButton ajouterClient = new JButton("Ajouter client");
        ajouterClient.setLocation(300, 200);
        ajouterClient.setSize(longueur, largeur);

        ajouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Main.loadClientAdditionPage();
            }
        });
        this.add(ajouterProduit);
        this.add(ajouterClient);
        this.add(bonjourTexte);
    }
}
