package controller;
import business.entities.Client;
import business.entities.Product;
import business.manager.ClientManager;
import business.manager.ProductManager;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import javax.swing.*;

public class Session {
    static ClientManager clientManager = new ClientManager();
    static ProductManager productManager = new ProductManager();

    public String processStartUp(){
        return "loginFrame";
    }
    //add client as static attribute
    public ImmutableTriple<Client, Product, String> processLogin(String pseudo, String password) {
        Client c = clientManager.getClient(pseudo,password);
        Product p = productManager.getTodaySpecial();
        if(c!=null)
            return new ImmutableTriple<>(c,p,"homeFrame");
        return null;
    }
}
