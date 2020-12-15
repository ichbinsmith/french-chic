package views;

import business.entities.*;
import business.manager.ProductManager;
import controller.Session;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
        },
                new Object[] {"Libellé", "Prix HT", "Quantite", "Montant"}
        );
        JTable table = new JTable(tableModel);
        tableModel.addRow(new Object[]{item.getProduct().getName(), prixHTLg, new Integer(item.getQuantity()).toString(), montantLg});

        table.setSize(400, 100);
        table.setLocation(125, 150);
        JPanel paneTab = new JPanel();
        paneTab.setLocation(125, 200);
        paneTab.setSize(400, 200);
        paneTab.setBackground(Color.WHITE);
        paneTab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneTab.add(table, BorderLayout.CENTER);

        Session session = new Session();
        Product p = session.processPromotionalSearching();
        String produitTxt = "Le produit promotionnel est le \"" + p.getName() + "\" au prix de " + p.getPrice() + " Euros ("+p.getReduction()*100+" %)";
        JLabel promotionnalProduct = null;
        promotionnalProduct = new JLabel(produitTxt);
        promotionnalProduct.setSize(500, 20);
        promotionnalProduct.setLocation(120, 275);


        JButton addPromotional = new JButton("Ajouter produit promotionnel");
        addPromotional.setLocation(120, 300);
        addPromotional.setSize(200, 30);


        JLabel montantLabel = null;
        montantLabel = new JLabel("Montant panier");
        montantLabel.setSize(120, 20);
        montantLabel.setLocation(350, 300);
        int longueur = 200;
        int largeur = 30;
        final JTextField montantField;
        montantField = new JTextField();
        montantField.setSize(longueur, largeur);
        montantField.setLocation(450, 300);
        montantField.setSize(100, largeur);
        String total = nf.format(clientOrder.getPrice());
        String montantTxt = String.valueOf(total) + " Euros";
        montantField.setText(montantTxt);
        montantField.setEditable(false);


        JLabel errorMessage = new JLabel("");
        errorMessage.setLocation(260,375);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("",Font.PLAIN,10));
        errorMessage.setSize(200, 20);

        JButton validateOrder = new JButton("Valider");
        validateOrder.setLocation(250,400);
        validateOrder.setSize(longueur, largeur);

        validateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = new Session();
                if (session.processOrderValidation(clientOrder)){
                    errorMessage.setText("Commande validée.");
                }
                else{
                    errorMessage.setText("Impossible de valider cette commande.");
                }
                validateOrder.setEnabled(false);
            }
        });

        addPromotional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = new Session();
                ImmutablePair response = Main.session.processProductAddition(session.processPromotionalSearching(), 1);
                business.entities.Order order = (business.entities.Order) response.getLeft();
                OrderItem item = order.getItems().get(1);
                if (response.getRight().equals("orderFrame") && response.getLeft()!=null ){
                    tableModel.addRow(new Object[]{item.getProduct().getName(), item.getPrice(), new Integer(item.getQuantity()).toString(), item.getPrice()});
                    montantField.setText(String.valueOf(new DecimalFormat("##.##").format(order.getPrice())));
                    addPromotional.setEnabled(false);
                }
            }
        });

        this.add(promotionnalProduct);
        this.add(addPromotional);
        this.add(errorMessage);
        this.add(validateOrder);
        this.add(title);
        this.add(montantField);
        this.add(montantLabel);
        this.add(paneTab);
    }
}
