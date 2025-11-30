package ba.yzl3514.shop.data;

import ba.yzl3514.shop.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ProductRepository {

     private static List<Product> products = new ArrayList<>();

     static{
            products.add(new Product(1, "Gaming Laptop", 1500.00));
            products.add(new Product(2,"Mechanical Keyboard", 200.00));
            products.add(new Product(3, "Wireless Mouse", 50.00));
            products.add(new Product(4, "4K Monitor", 500.00));
            products.add(new Product(4, "USB Type-C Cable", 20.00));
     }

     // Before JDK 10 : new ArrayList(products);
     public List<Product> getAllProducts(){
         return List.copyOf(products);
     }

     public Product findById(int id){
            for(Product product : products){
                if(product.getId() == id){
                    return product;
                }
            }
            return null;
     }

}
