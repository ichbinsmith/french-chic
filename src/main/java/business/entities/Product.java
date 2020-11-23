package business.entities;

public class Product {
    private String name;
    private Float price;
    private int stock;
    private boolean isTodaySpecial;

    public Product() {
    }

    public Product(String name, Float price, int stock, boolean isTodaySpecial) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.isTodaySpecial = isTodaySpecial;
    }

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
}
