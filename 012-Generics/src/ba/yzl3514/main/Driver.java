package ba.yzl3514.main;

import ba.yzl3514.domain.Car;
import ba.yzl3514.domain.Holder;
import ba.yzl3514.domain.ParametricHolder;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {


        Holder holder = new Holder();
        holder.setData(new Car());

        holder.setData(1);


        holder.setData("message");

        //------------------

        ParametricHolder<Integer> parametricHolder = new ParametricHolder<Integer>();
        parametricHolder.setData(1);

        //parametricHolder.setData("abc");


        ParametricHolder<String> stringParametricHolder = new ParametricHolder<String>();

        //parametricHolder = stringParametricHolder;

        if(parametricHolder.getClass() == stringParametricHolder.getClass()){
            System.out.println("Same Class");
        }

        if(stringParametricHolder instanceof ParametricHolder){
            System.out.println("Yes it is ParametricHolder instance");
        }

        if(stringParametricHolder instanceof ParametricHolder<String>){
            System.out.println("Yes it is ParametricHolder<String> instance");
        }

        /*
        // COMPILE-TIME ERROR
        if(stringParametricHolder instanceof ParametricHolder<Integer>){
            System.out.println("Yes it is ParametricHolder<Integer> instance");
        }
         */


    }
}
