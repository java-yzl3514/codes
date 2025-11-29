package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Strategize {

    private Strategy strategy;
    private String message;


    public Strategize(String msg){
        message = msg;
        strategy = new LowerStrategy();
    }

    public void runStrategy() {
        System.out.println(strategy.apply(message));
    }

    public void changeStrategy(Strategy strategy){
            this.strategy = strategy;
    }
}
