package views;

import business.entities.Client;
import business.entities.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame {
    public Home(Client c, Product p) throws HeadlessException {
        this.setTitle("French Chic - Produit du jour");
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
        bonjourTexte.setLocation(150, 200);

        String produitTxt = "Le produit du jour est le \"" + p.getName() + "\" au prix de " + p.getPrice() + " Euros";
        produitDuJourTexte = new JLabel(produitTxt);
        produitDuJourTexte.setSize(500, 20);
        produitDuJourTexte.setLocation(150, 250);

        String stock = "Quantité en stock : " + p.getStock();
        stockLabel = new JLabel(stock);
        stockLabel.setSize(500, 20);
        stockLabel.setLocation(150, 270);

        quantiteLabel = new JLabel("Quantité");
        quantiteLabel.setSize(120, 20);
        quantiteLabel.setLocation(250, 325);

        int longueur = 200;
        int largeur = 30;

        final JTextField quantiteField;

        quantiteField = new JTextField();
        quantiteField.setSize(longueur, largeur);
        quantiteField.setLocation(320, 320);
        quantiteField.setSize(50, largeur);

        JButton ajouterProduit = new JButton("Ajouter le produit du jour au panier");
        ajouterProduit.setLocation(250, 370);
        ajouterProduit.setSize(longueur+40, largeur);

        ajouterProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Integer quantity = new Integer(quantiteField.getText());
                ImmutablePair response = Main.session.processProductAddition(p, quantity);
                if (response.getRight().equals("orderFrame") && response.getLeft()!=null ) {
                    Main.loadOrderPage((business.entities.Order) response.getLeft());
                }
            }
        });
        this.add(title);
        this.add(bonjourTexte);
        this.add(produitDuJourTexte);
        this.add(quantiteField);
        this.add(quantiteLabel);
        this.add(ajouterProduit);
        this.add(stockLabel);
    }
}
