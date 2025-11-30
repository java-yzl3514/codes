package ba.yzl3514.shop.app;

import ba.yzl3514.shop.cart.ShoppingCart;
import ba.yzl3514.shop.data.ProductRepository;
import ba.yzl3514.shop.exception.ProductNotFoundException;
import ba.yzl3514.shop.model.Product;
import ba.yzl3514.shop.service.PricePolicy;
import ba.yzl3514.shop.service.PricePolicyFactory;
import ba.yzl3514.shop.util.StdIn;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ShoppingAppRunner {

    private final Logger logger = Logger.getLogger(ShoppingAppRunner.class.getName());
    private static final int QUIT_CHOICE = 0;
    private final ProductRepository productRepository;

    public ShoppingAppRunner() {
        productRepository = new ProductRepository(); // Dependency Injection
    }

    public void run() {
        System.out.println("### SHOPPING APP STARTED ###");
        ShoppingCart shoppingCart = null;
        while (true) {
            listProducts();
            int choice = StdIn.readInt("Select Product ID (0 to quit):");
            if (choice == QUIT_CHOICE) break;
            if (shoppingCart == null)
                shoppingCart = new ShoppingCart();
            try {
                addToCart(choice, shoppingCart);
            }catch (ProductNotFoundException e){
                System.out.println("Please Enter an Exist Product ID ! ");
            }

        }
        if(shoppingCart != null) processCheckout(shoppingCart);
    }

    private void processCheckout(ShoppingCart cart) {
        System.out.println("\n---- Checkout ----");
        String code = StdIn.read("Please Enter the Discount Code :");
        code = code.toUpperCase().trim();
        PricePolicy pricePolicy = PricePolicyFactory.getPolicyByCode(code);
        System.out.println(">> Calculating with code : " + (code.isEmpty() ? "NONE" : code));
        cart.checkout(pricePolicy);
    }

    private void addToCart(int productId, ShoppingCart cart) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            cart.addProduct(product);
        } else {
            logger.severe("!! Error: Product not found");
            throw new ProductNotFoundException(productId);
        }
    }

    private void listProducts() {
        System.out.println("\n ---- Product Catalog ----");
        List<Product> allProducts = productRepository.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
