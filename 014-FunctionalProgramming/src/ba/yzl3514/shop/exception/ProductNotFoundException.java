package ba.yzl3514.shop.exception;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(int productId) {
        super(String.format("The product { id: %d } is not found!", productId));
    }
}
