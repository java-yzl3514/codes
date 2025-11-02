package ba.yzl3514.invariant;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        //List<Number> numbers = new ArrayList<Integer>(); // COMPILE-TIME ERROR

        iterateList(new ArrayList<Number>());

        List<? extends Number> numbers = new ArrayList<Integer>();

        var list = new ArrayList<String>();


    }

    public static void iterateList(List<Number> list){

    }


    public double sum(List<? extends Number> numbers){
        double total = 0;
        for(Number n: numbers){
            total += n.doubleValue();
        }

        // numbers.add(5); // Integer listesi olduğunu nereden biliyoruz ????
        // Derleyici bu riski almaz

        numbers.add(null); // safe !
        return total;
    }

    public void addIntegers(List<? super Integer> dest, List<Integer> source){

        for(Integer i : source) {
            dest.add(i); // YAZMA GÜVENLİ. Çünkü dest listesi List<Integer>, List<Number> veya List<Object> olabilir.
            // Bu tiplerin hepsi de 'Integer' kabul eder.
        }

        // Integer i = dest.get(0); // ERROR
        // Neden? Ya dest listesi List<Object> ise ?
        // 'get(0)' bir Object döndürür, bu Integer'a güvenle atanamaz.

    }


    public int getSizeInfo(List<?> list){
        return list.size();
    }

}
