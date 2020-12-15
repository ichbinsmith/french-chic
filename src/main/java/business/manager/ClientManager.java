package business.manager;
import business.entities.Client;
import business.entities.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientManager {
    List<Client> clients;

    public ClientManager() {
        this.init();
    }

    public void initDB(){
        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Smith","Djamoura","smith","smith","adminUser"));
        clientList.add(new Client("Barbara","VZ","barb","barb"));
        clientList.add(new Client("Omar","Zribi","omar","omar"));
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        Iterator it = clientList.iterator();
        while(it.hasNext()) {
            Client c = (Client) it.next();
            em.persist(c);
        }
        em.getTransaction() .begin() ;
        em.getTransaction() .commit() ;
    }
    private void init() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        //this.clients = new ArrayList<>();
        this.clients = (List<Client>) em.createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    public Client getClient(String pseudo, String password){
        init();
        Iterator it = this.clients.iterator();
        while (it.hasNext()){
            Client c = (Client) it.next();
            if(c.getPseudo().equals(pseudo) && c.getPassword().equals(password))
                return c;
        }
        return null;
    }

    public boolean addClient(Client c){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(c);
            em.getTransaction() .begin() ;
            em.getTransaction() .commit() ;
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public List<Client> getClientList(){
        return this.clients;
    }
}
