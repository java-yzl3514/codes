package ba.yzl3514.streams.create;

import ba.yzl3514.streams.Data;

import java.util.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class CollectionToStream {

    public static void main(String[] args) {

        List<Data> dataList = Arrays.asList(new Data(1), new Data(2), new Data(1000), new Data(400));

        System.out.println(dataList.stream().mapToInt(Data::getI).sum());



        Set<String> strings =
                new HashSet<>(
                        Arrays.asList("Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                                .split(" ")));

        strings.stream().map(string -> string + "-").forEach(System.out::println);


        Map<String, Double> map = new HashMap<>();

        map.put("pi", 3.14159);
        map.put("e", 2.718);
        map.put("avagadro's number", 6.022e23);

        map.entrySet()
                .stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
    }
}
