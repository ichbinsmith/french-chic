package business.entities;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Iterator;

public class Order {
    ArrayList<OrderItem> items;
    Client client;
    float price;

    public Order(ArrayList<OrderItem> items, Client client) {
        this.items = items;
        this.client = client;
        updatePrice();
    }

    public ArrayList<OrderItem> getItems() {
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
