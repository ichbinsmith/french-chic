package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controleur.Session;

public class VueJetable {

    static Session session;
    static JFrame frame;

    public static void main(String[] args) {
        session = new Session();
        String reponse = session.traiterConnexion();
        if (reponse == "ECRAN_ACCUEIL") {
            afficherEcranAccueil();
        }

    }

    private static void afficherEcranAccueil() {
        frame = new JFrame();
        frame.setTitle("French Chic - Accueil");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);
        //initialiserPanel();

        JLabel title = new JLabel("French Chic");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);

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
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        frame.add(title);
        frame.add(pseudoLabel);
        frame.add(mdpLabel);
        frame.add(pseudoField);
        frame.add(mdpField);
        frame.add(login);
        frame.setVisible(true);

    }

}
