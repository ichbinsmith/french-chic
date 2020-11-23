package business.manager;
import business.entities.Client;

import java.util.ArrayList;
import java.util.Iterator;

public class ClientManager {
    ArrayList<Client> clients;

    public ClientManager() {
        this.init();
    }

    private void init() {
        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Smith","Djamoura","smith","smith"));
        clientList.add(new Client("Barbara","VZ","barb","barb"));
        clientList.add(new Client("Omar","Zribi","omar","omar"));
        this.clients = clientList;
    }

    public Client getClient(String pseudo, String password){
        Iterator it = this.clients.iterator();
        while (it.hasNext()){
            Client c = (Client) it.next();
            if(c.getPseudo().equals(pseudo) && c.getPassword().equals(password))
                return c;
        }
        return null;
    }
    public ArrayList<Client> getClientList(){
        return this.clients;
    }
}
