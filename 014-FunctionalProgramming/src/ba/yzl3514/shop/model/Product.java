package ba.yzl3514.shop.model;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-20s  : %.2f", id, name, price);
    }
}
