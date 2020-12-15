package business.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c"),
        @NamedQuery(name = "Product.findById", query = "SELECT c FROM Product c WHERE c.id = :id"),
        @NamedQuery(name = "Product.findByName", query = "SELECT c FROM Product c WHERE c.name = :name")})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ProductName")
    private String name;

    @Column(name = "ProductPrice")
    private Float price;

    @Column(name = "ProductStock")
    private int stock;

    @Column(name = "ProductIsTodaySpecial")
    private boolean isTodaySpecial;

    @Column(name = "ProductIsPromotional")
    private boolean isPromotional;

    @Column(name = "ProductReduction")
    private Float reduction;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="product")
    private OrderItem orderItem;

    public Product() {
    }

    public Product(String name, Float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.isTodaySpecial = false;
        this.isPromotional = false;
        this.reduction = Float.valueOf(10/100);
    }

    public Product(String name, Float price, int stock, boolean isTodaySpecial) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.isTodaySpecial = isTodaySpecial;
        this.isPromotional = false;
        this.reduction = Float.valueOf(10/100);
    }

    public Product(String name, Float price, int stock, boolean isTodaySpecial, boolean isPromotional, Float reduction) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.isTodaySpecial = isTodaySpecial;
        this.isPromotional = isPromotional;
        this.reduction = reduction;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isTodaySpecial() {
        return isTodaySpecial;
    }

    public void setTodaySpecial(boolean todaySpecial) {
        isTodaySpecial = todaySpecial;
    }

    public boolean isPromotional() {return isPromotional; }

    public void setPromotional(boolean promotional) {isPromotional = promotional;}

    public Float getReduction() { return reduction; }

    public void setReduction(Float reduction) {this.reduction = reduction; }

    public OrderItem getOrderItem() {return orderItem;}

    public void setOrderItem(OrderItem orderItem) {this.orderItem = orderItem; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
