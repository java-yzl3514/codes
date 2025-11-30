package ba.yzl3514.shop.cart;

import ba.yzl3514.shop.model.Product;
import ba.yzl3514.shop.service.PricePolicy;

import java.util.*;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ShoppingCart {

    private final Logger logger = Logger.getLogger(ShoppingCart.class.getName());
    private Set<CartItem> items = new HashSet<>();

    public void addProduct(Product product) {
        if(findItemAndIncQuantity(product)) return;
        items.add(new CartItem(product));
        logger.info(" --> Added to cart : " + product.getName());
    }

    private boolean findItemAndIncQuantity(Product product) {
        for (CartItem cartItem : items) {
            if (product.getId() == cartItem.getProductId()) {
                cartItem.incQuantity();
                return true;
            }
        }
        return false;
    }

    public double getRawTotal(){
        double sum = 0;
        for(CartItem item : items){
            sum += item.getPrice();
        }
        return sum;
    }


    public void checkout(PricePolicy pricePolicy){
        final double rawTotal = getRawTotal();
        final double finalPrice = pricePolicy.apply(rawTotal);
        // TODO : receipt writer
        System.out.println("\n-------------- RECEIPT --------------");
        for(CartItem item : items){
            System.out.println(" - " + item);
        }

        System.out.println("------------------------------------------");
        System.out.println("Subtotal: [P] " + String.format("%.2f", rawTotal));
        System.out.println("Final Total: [P] " + String.format("%.2f", finalPrice));
        System.out.println("------------------------------------------");
    }
}
