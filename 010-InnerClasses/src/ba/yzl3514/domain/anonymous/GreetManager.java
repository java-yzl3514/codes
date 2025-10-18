package ba.yzl3514.domain.anonymous;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class GreetManager {

    public Greeter greeter(Language language) {
        return new Greeter() {
            @Override
            public void greet() {
//                System.out.println(switch (language) {
//                    case TR -> "Merhaba";
//                    default -> "Hello";
//                });
                System.out.println(language == Language.TR ?  "Merhaba" : "Hello");
            }
        };
    }

}
