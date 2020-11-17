package business.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.util.Objects;

//@Embeddable
public class Client implements Serializable {
    private String firstName;
    private String lastName;
    private String pseudo;
    private String password;

    public Client() {
    }

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(String firstName, String lastName, String pseudo, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.password = password;
    }

    //@Column(name = "ClientFirstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@Column(name = "ClientLastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Column(name = "ClientPseudo")
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    //@Column(name = "ClientPassword")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client " + getFirstName() + " " + getLastName();
    }
}