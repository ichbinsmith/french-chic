package business.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Entity
@Table(name = "orderTable")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    Client client;


    //@OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    List<OrderItem> items;

    @Column(name = "OrderPrice")
    float price;

    public Order() {
    }

    public Order(ArrayList<OrderItem> items, Client client) {
        this.items = items;
        this.client = client;
        updatePrice();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private void updatePrice(){
        Iterator it = this.items.iterator();
        float price = 0;
        while (it.hasNext()){
            OrderItem item = (OrderItem) it.next();
            price+=item.getPrice();
        }
        this.price = price;
    }

    public boolean addItem(OrderItem item){
        this.items.add(item);
        return true;
    }
    public boolean addItem(Product product,int quantity){
        if(product.getStock()<quantity)
            return false;
        this.items.add(new OrderItem(product,quantity));
        updatePrice();
        return true;
    }

    public void removeItem(OrderItem item){
        Iterator it = this.items.iterator();
        while (it.hasNext()){
            OrderItem el = (OrderItem) it.next();
            if (el.equals(item)){
                it.remove();
                updatePrice();
                break;
            }
        }
    }
}
