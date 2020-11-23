package business.manager;

import business.entities.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductManager {
    ArrayList<Product> products;

    public ProductManager() {
        this.init();
    }
    private void init() {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Jeans Levis", (float) 29.99,1800,true));
        productList.add(new Product("T-shirt Biden", (float) 29.99,1800,false));
        this.products = productList;
    }

    public Product getProduct(String name){
        Iterator it = this.products.iterator();
        while (it.hasNext()){
            Product p = (Product) it.next();
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public Product getTodaySpecial(){
        Iterator it = this.products.iterator();
        while (it.hasNext()){
            Product p = (Product) it.next();
            if(p.isTodaySpecial())
                return p;
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }
}
