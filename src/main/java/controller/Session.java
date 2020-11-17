package controller;
import business.entities.Client;
import business.manager.Manager;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class Session {
    static Manager manager = new Manager();
    public ImmutablePair<Client, String> processLogin(String pseudo, String mdp) {
        Client c = manager.getClient(pseudo,mdp);
        if(c!=null)
            return new ImmutablePair<Client, String>(c,"homeFrame");
        return null;
    }
}
