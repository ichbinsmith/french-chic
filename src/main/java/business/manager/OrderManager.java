package business.manager;

import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderManager {
    List<Order> orders;

    public OrderManager() {
        this.init();
    }
    public void initBD(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        Client client =new Client("Paul","Koffi","pk","pk");

        ArrayList<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(new Product("Nike Air 270", (float) 230, 10), 5));
        Order order = new Order(items,client);
        em.persist(order);
        em.getTransaction() .begin() ;
        em.getTransaction() .commit() ;
        init();

    }
    private void init() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        this.orders = new ArrayList<>();
        this.orders = (List<Order>) em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void addOrder(Order o){
        this.orders.add(o);
    }

    public Order createNewOrder(Client client, Product product, int quantity){
        OrderItem orderItem = new OrderItem(product,quantity);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        Order order = new Order(orderItems,client);
        return order;
    }
    public Order createNewOrder(Client client){
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order(orderItems,client);
        return order;
    }

    public boolean validateOrder(Order order){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        //TODO : add try catch, process the DB constraint errors
        System.out.println(order);
        try {
            //Update stocks
            Iterator it = order.getItems().iterator();
            em.getTransaction() .begin() ;
            while (it.hasNext()){
                OrderItem ot = (OrderItem) it.next();
                ot.getProduct().setStock(ot.getProduct().getStock()-ot.getQuantity());
            }
            em.getTransaction() .commit() ;
            em.persist(order);
            em.getTransaction() .begin() ;
            em.getTransaction() .commit() ;
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public List<Order> getOrders() {
        init();
        return orders;
    }
}
