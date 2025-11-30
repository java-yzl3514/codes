package ba.yzl3514.shop.cart;

import ba.yzl3514.shop.model.Product;

import java.util.Objects;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product) {
        Objects.requireNonNull(product, "Product  MUST not be null!");
        this.product = product;
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incQuantity() {
        quantity++;
    }

    public void decQuantity() {
        quantity--;
    }

    public int getProductId() {
        return product.getId();
    }

    public double getPrice(){
        return quantity * product.getPrice();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(product.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj instanceof CartItem cartItem)
            return getProductId() == cartItem.getProductId();
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s x %d = %.2f", product, quantity, getPrice());
    }
}
