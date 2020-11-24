package views;

import business.entities.Client;
import business.entities.Product;
import controller.Session;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
    public Login() throws HeadlessException {
        this.setTitle("French Chic - Connexion");
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

        JLabel errorMessage = new JLabel("");
        errorMessage.setLocation(270,182);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("",Font.PLAIN,10));
        errorMessage.setSize(200, 20);

        JLabel pseudoLabel = null;
        JLabel mdpLabel = null;

        pseudoLabel = new JLabel("Pseudo");
        pseudoLabel.setSize(120, 20);
        pseudoLabel.setLocation(150, 200);
        mdpLabel = new JLabel("Mot de passe");
        mdpLabel.setSize(120, 20);
        mdpLabel.setLocation(150, 250);

        int longueur = 200;
        int largeur = 30;

        final JTextField pseudoField;
        final JPasswordField mdpField;

        pseudoField = new JTextField();
        pseudoField.setSize(longueur, largeur);
        pseudoField.setLocation(250, 200);
        mdpField = new JPasswordField();
        mdpField.setSize(longueur, largeur);
        mdpField.setLocation(250, 250);
        JButton login = new JButton("S'identifier");
        login.setLocation(250, 300);
        login.setSize(longueur, largeur);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = new Session();
                ImmutableTriple<Client, Product, String> pair =  session.processLogin(pseudoField.getText(),String.valueOf(mdpField.getPassword()));
                if (pair!=null && pair.getRight().equals("homeFrame")){
                    Main.loadHomePage(pair.getLeft(),pair.getMiddle());
                }
                else{
                    //clear pseudo and password field
                    pseudoField.setText("");
                    mdpField.setText("");
                    errorMessage.setText("Pseudo ou mot passe invalide");
                }
            }
        });
        this.add(title);
        this.add(pseudoLabel);
        this.add(mdpLabel);
        this.add(pseudoField);
        this.add(mdpField);
        this.add(login);
        this.add(errorMessage);
    }
}
