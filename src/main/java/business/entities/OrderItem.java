package business.entities;

public class OrderItem {
    private Product product;
    private float price;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.price = product.getPrice()*quantity;
        this.quantity = quantity;
    }

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
}
