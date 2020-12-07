package business.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ClientFirstName")
    private String firstName;

    @Column(name = "ClientLastName")
    private String lastName;

    @Column(name = "ClientPseudo")
    private String pseudo;

    @Column(name = "ClientPassword")
    private String password;

    /*normalUser vs adminUser*/
    @Column(name = "ClientType")
    private String clientType;

    /*
    @OneToMany(mappedBy = "client")
    @JoinColumn(name = "ClientOrders")
    List<Order> orders;
    */


    public Client() {
    }

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientType = "normalUser";
    }

    public Client(String firstName, String lastName, String pseudo, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.password = password;
        this.clientType = "normalUser";
    }

    public Client(String firstName, String lastName, String pseudo, String password, String clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.password = password;
        this.clientType = clientType;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

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

    public String getClientType() {return clientType;}

    public void setClientType(String clientType) {this.clientType = clientType;}

    /*
    public List<Order> getOrders() {return orders;}

    public void setOrders(List<Order> orders) {this.orders = orders;}
     */
}