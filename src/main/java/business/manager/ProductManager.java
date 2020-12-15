package business.manager;

import business.entities.Client;
import business.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManager {
    List<Product> products;

    public ProductManager() {
        this.init();
    }

    public void initBD(){
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Sac LV", (float) 499.99,800));
        productList.add(new Product("Jeans Levis", (float) 29.99,1800,true));
        productList.add(new Product("T-shirt Biden", (float) 29.99,200,false,true,(float) 0.2));
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        Iterator it = productList.iterator();
        while(it.hasNext()) {
            Product c = (Product) it.next();
            em.persist(c);
        }
        em.getTransaction() .begin() ;
        em.getTransaction() .commit() ;

    }
    private void init() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        this.products = new ArrayList<>();
        this.products = (List<Product>) em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public Product getProduct(String name){
        init();
        Iterator it = this.products.iterator();
        while (it.hasNext()){
            Product p = (Product) it.next();
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public Product getTodaySpecial(){
        init();
        Iterator it = this.products.iterator();
        while (it.hasNext()){
            Product p = (Product) it.next();
            if(p.isTodaySpecial())
                return p;
        }
        return null;
    }

    public Product getPromotional(){
        init();
        Iterator it = this.products.iterator();
        while (it.hasNext()){
            Product p = (Product) it.next();
            if(p.isPromotional())
                return p;
        }
        return null;
    }

    public boolean addProduct(Product c){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("fc_persistence_unit");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction() .commit() ;
            em.persist(c);
            em.getTransaction() .begin() ;
            em.getTransaction() .commit() ;
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    public List<Product> getProducts() {
        init();
        return this.products;
    }
}
