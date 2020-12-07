package business.entities;

import javax.persistence.*;


@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Product_id")
    private Product product;

    @Column(name = "OrderItemPrice")
    private float price;

    @Column(name = "OrderItemQuantity")
    private int quantity;

    /*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Order_Id")
    private Order order;
    */

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.price = product.getPrice()*quantity;
        this.quantity = quantity;
    }

    public int getId() {return id;}

    public void setId(int id) { this.id = id;}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}
    */

}
