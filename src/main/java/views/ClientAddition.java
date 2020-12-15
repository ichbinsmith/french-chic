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




        JLabel aLabel = null;
        aLabel = new JLabel("Nom");
        aLabel.setSize(120, 20);
        aLabel.setLocation(150, 100);
        final JTextField aField;
        aField = new JTextField();
        aField.setSize(longueur, largeur);
        aField.setLocation(250, 95);
        aField.setSize(100, largeur);

        JLabel bLabel = null;
        bLabel = new JLabel("Prénom");
        bLabel.setSize(120, 20);
        bLabel.setLocation(150, 150);
        final JTextField bField;
        bField = new JTextField();
        bField.setSize(longueur, largeur);
        bField.setLocation(250, 145);
        bField.setSize(100, largeur);


        JLabel cLabel = null;
        cLabel = new JLabel("Pseudo");
        cLabel.setSize(120, 20);
        cLabel.setLocation(150, 200);
        final JTextField cField;
        cField = new JTextField();
        cField.setSize(longueur, largeur);
        cField.setLocation(250, 195);
        cField.setSize(100, largeur);


        JLabel dLabel = null;
        dLabel = new JLabel("Mot de passe");
        dLabel.setSize(120, 20);
        dLabel.setLocation(150, 250);
        final JPasswordField dField;
        dField = new JPasswordField();
        dField.setSize(longueur, largeur);
        dField.setLocation(250, 245);
        dField.setSize(100, largeur);


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
                if(session.processClientAddition(aField.getText(),bField.getText(),cField.getText(),String.valueOf(dField.getPassword()))){
                    errorMessage.setText("Client ajouté avec succes.");
                    aField.setText("");
                    bField.setText("");
                    cField.setText("");
                    dField.setText("");
                }
                else {
                    errorMessage.setText("Ajout Impossible.");
                    ajouterClient.setEnabled(false);
                }
            }
        });

        this.add(errorMessage);
        this.add(ajouterClient);

        this.add(aLabel);
        this.add(aField);
        this.add(bLabel);
        this.add(bField);
        this.add(cLabel);
        this.add(cField);
        this.add(dLabel);
        this.add(dField);
    }
}
