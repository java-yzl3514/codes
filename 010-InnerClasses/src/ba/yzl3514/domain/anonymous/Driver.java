package ba.yzl3514.domain.anonymous;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        GreetManager greetManager = new GreetManager();
        greetManager.greeter(Language.TR).greet();
        greetManager.greeter(Language.EN).greet();


        // Öyle bir sınıf ki, AbstractClass sınıfını türünden olsun.
        AbstractClass abstractClass = new AbstractClass(){};

        abstractClass.foo();

        // Öyle bir sınıf ki, ConcreteClass sınıfını türünden olsun.
        ConcreteClass concreteClass = new ConcreteClass(){

            @Override
            public void tar() {
                bar();
            }

            void bar(){
                System.out.println("ConcreteClass.<anonymous>.bar()");
            }
        };

        //concreteClass.bar();
        concreteClass.tar();
    }
}
