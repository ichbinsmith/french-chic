package business.manager;
import business.entities.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager {
    ArrayList<Client> clients;

    public Manager() {
        this.init();
    }

    private void init() {
        ArrayList<Client> clientList = new ArrayList<Client>();
        clientList.add(new Client("Smith","Djamoura","smith","smith"));
        clientList.add(new Client("Barbara","VZ","barb","barb"));
        clientList.add(new Client("Omar","Zribi","omar","omar"));
        this.clients = clientList;
    }

    public Client getClient(String pseudo, String mdp){
        Iterator it = this.clients.iterator();
        while (it.hasNext()){
            Client c = (Client) it.next();
            if(c.getPseudo().equals(pseudo) && c.getPassword().equals(mdp))
                return c;
        }
        return null;
    }
    public ArrayList<Client> getClientList(){
        return this.clients;
    }
}
