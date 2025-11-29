package ba.yzl3514.main;


import ba.yzl3514.domain.DuplicateMessageStrategy;
import ba.yzl3514.domain.Strategize;
import ba.yzl3514.domain.Strategy;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {


        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String apply(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },

                m -> m.substring(0, 5),
                DuplicateMessageStrategy::apply
        };

        Strategize strategize = new Strategize("Hello Java Functional Programming");
        strategize.runStrategy();

        System.out.println("=======");

        for(Strategy s : strategies){
            strategize.changeStrategy(s);
            strategize.runStrategy();
        }
    }
}
