package views;

import business.entities.*;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Order extends JFrame {
    public Order(business.entities.Order clientOrder) throws HeadlessException {
        this.setTitle("French Chic - Panier");
        this.setSize(650, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        this.setContentPane(accueilPanel);
        this.setLayout(null);

        JLabel title = new JLabel("Votre Panier");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

        OrderItem item = clientOrder.getItems().get(0);
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        nf.setMinimumFractionDigits(2);

        String prixHTLg = nf.format(item.getProduct().getPrice());
        String montantLg = nf.format(item.getPrice());

        String[] entetes = {"Libelle", "Prix HT", "Quantite", "Montant"};

        Object[][] donnees = {
                {item.getProduct().getName(), prixHTLg, new Integer(item.getQuantity()).toString(), montantLg},};

        JTable table = new JTable(donnees, entetes);
        table.setSize(400, 100);
        table.setLocation(125, 200);
        JPanel paneTab = new JPanel();
        paneTab.setLocation(125, 200);
        paneTab.setSize(400, 200);
        paneTab.setBackground(Color.WHITE);
        paneTab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneTab.add(table, BorderLayout.CENTER);

        JLabel montantLabel = null;

        montantLabel = new JLabel("Montant panier");
        montantLabel.setSize(120, 20);
        montantLabel.setLocation(250, 423);

        int longueur = 200;
        int largeur = 30;

        final JTextField montantField;

        montantField = new JTextField();
        montantField.setSize(longueur, largeur);
        montantField.setLocation(350, 420);
        montantField.setSize(100, largeur);

        String total = nf.format(clientOrder.getPrice());

        String montantTxt = String.valueOf(total) + " Euros";
        montantField.setText(montantTxt);
        montantField.setEditable(false);

        this.add(title);
        this.add(montantField);
        this.add(montantLabel);
        this.add(paneTab);

    }
}
