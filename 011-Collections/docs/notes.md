Collections

Bir alışveriş sepetini yönettiğimizi düşünelim. Kullanıcının kaç adet item alacağını önceden
bilmek mümkün mü?
Sonrasında yeni bir eleman eklenmek istenirse nasıl bir maliyet ortaya çıkacak ?

```java

      String[] cart = new String[3];
        cart[0] = "Apple";
        cart[1] = "Water";
        cart[2] = "Soap";
        //cart[3] = "Detergent";

        //...

        String[] newCart = new String[cart.length + 1];
        for(int i = 0; i < cart.length; i++) {
            newCart[i] = cart[i];
        }

        newCart[3] = "Milk";

        cart = newCart;

```
  

---
```java
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println(dynamicArray);

        for(int i = 0; i < 100; i++ ){
            dynamicArray.add(i);
        }

        System.out.println(dynamicArray);
```

---
> Java 1.5 öncesi kod :
```java
 DynamicArray cart = new DynamicArray(3);
        cart.add("Water");
        cart.add("Apple");
        cart.add("Milk");
        cart.add("Soap");

        System.out.println(cart);

        cart.add(3);



        ArrayList list = new ArrayList();
        list.add("Water");
        list.add("Apple");
        list.add("Milk");
        list.add("Soap");
        System.out.println(list);

        list.add(3);

```

### Temel Kavramlar
  Java koleksiyon (collection) kütüphanesi, "nesneleri tutma" (holding objects) fikrini alır ve bunu kütüphanenin 
temel arayüzleriyle ifade edilen iki ayrı kavrama böler:

1. **Collection:** Bir ya da daha fazla kurala göre düzenlenmiş bireysel ögeler dizisidir.
 Örneğin :
- Bir **List**, öğeleri eklendikleri sırayla ***tutmalı***,
- Bir **Set**, mükerrer öğe ***içermemeli***,
- Bir **Queue**, öğeleri kuyruk disiplinine göre ***üretmeli***

2. **Map**: anahtar-değer ikililerinden oluşan bir gruptur.Bir değeri bir anahtar kullanarak bulur.
Bir ArrayList, bir nesneyi bir tamsayı üzerinden bulur; bu yönüyle sayıları nesnelerle ilişkilendirir.
Bir Map ise, bir nesneyi bir başka nesneyle ilişkilendirir.
Bu yüzden:
- **associative array**
- **dictionary**

olarak adlandırılır.

--- 

Tipik kullanım şudur: 
 Bir somut sınıf nesnesi oluşturulur, ilgili arayüze upcast edilir. Kalan kod boyunca bu arayüz kullanılır.

```java

 List<MyType> myTypes = new ArrayList<>();

  //...
  myTypes = new LinkedList<>();
  
```


```java
public class AddingGroupOfObjects {

    public static void main(String[] args) {

        Collection<Integer> collection = Arrays.asList(1,2,3,4,5);

        //collection.add(6); // UnsupportedOperationException // Arrays.asList returns fixed-size list.

        ((List)collection).set(0, 100);

        System.out.println(collection);

    }
}

```

```java

public class AddingGroupOfObjects {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        collection.add(6);

        Integer[] more = {7, 8, 9};

        collection.addAll(Arrays.asList(more));

        System.out.println(collection);

        Collections.addAll(collection, 10, 11, 12, 13);

        System.out.println(collection);

        Collections.addAll(collection,more);
        System.out.println(collection);
    }
}

```

```java

        // Type Inference
         List<Foo> fooList = Arrays.asList(new TarFoo(), new BazFoo(), new BarFoo(), new YBarFoo());
        //fooList.add(new XBarFoo()); // Exception

        // explicit type argument
        for(Object o : Arrays.<Foo>asList(new TarFoo(), new BazFoo(), new BarFoo(), new YBarFoo(), "")){
            System.out.println(o.getClass().getName());
        }

```

```java
        //MyType myType = new MyType();
        //System.out.println(myType); // Default toString

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(collection);

        Map<Integer, String> cities = new HashMap<>();
        cities.put(34, "Istanbul");
        cities.put(6, "Ankara");
        cities.put(35, "İzmir");

        System.out.println(cities);

        //
        String s = cities.get(34);
        System.out.println(s);

        /*
        Output:
                [1, 2, 3, 4, 5]
                {34=Istanbul, 35=İzmir, 6=Ankara}
                Istanbul
         */

```

#### Lists

```java

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 43, 45, 56));

        System.out.println(integers);
        integers.set(2, 800); // O(1)

        System.out.println(integers);

        integers.add(2, 3);
        System.out.println(integers);

```

### Sets
 >* TreeSet : **red-black tree**
>*  HashSet : hash fonksiyonu kullanır, sıralamanın garantisi yoktur.
>*  LinkedHashSet : hızlı arama için hashing kullanır fakat öğeleri eklenme sırasına göre tutuyormuş olarak
>*  görünür(linked list ile)

```java
public class Sets {

    public static void main(String[] args) {


        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; i< 10_000; i++){
            numbers.add(random.nextInt(20));
        }
        System.out.println(numbers);
    }
}

// Output: 
 // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
```
> **Çıktıya göre kullanılan hashing yöntemi integer'ları sıralıymış gibi gösteriyor.**\
> **Bu davranışa güvenmemelisiniz**
---

```java

public class Sets {

    public static void main(String[] args) {

        Set<String> colors = new HashSet<>();

        for(int i = 0; i < 100; i++){
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Green");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Purple");
            colors.add("Blue");
        }

        System.out.println(colors);
    }
}

/*
 Output: 
   [Red, Yellow, Blue, Purple, Orange, Green]
*/
```
> Yukarıdaki örnekte String nesneleri herhangi bir sıra üretmiyor gibi görünmektedir.
> Sonuçları sıralı göstermek istiyorsak; HashSet yerine TreeSet kullanmalıyız.

```java

public class Sets {

    public static void main(String[] args) {

        Set<String> colors = new TreeSet<>();

        for(int i = 0; i < 100; i++){
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Green");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Purple");
            colors.add("Blue");
        }

        System.out.println(colors);
    }
}

/*
 Output: 
   [Blue, Green, Orange, Purple, Red, Yellow]
*/
```
> Sonuçları ekleme sırasıyla göstermek istiyorsak; LinkedHashSet kullanmayı tercih edebiliriz.

```java

public class Sets {

    public static void main(String[] args) {

        Set<String> colors = new LinkedHashSet<>();

        for(int i = 0; i < 100; i++){
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Green");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Purple");
            colors.add("Blue");
        }

        System.out.println(colors);
    }
}
/*
 Output: 
   [Yellow, Blue, Red, Green, Orange, Purple]
*/
```
> Employee sınıfının Set ile kullanımı: 
> 
```java
public class DriverSetEmployee {

    public static void main(String[] args) {

        Set<Employee> employees = new HashSet<>();

        Employee john = new Employee(1, "John", "Doe");

        // read
        employees.add(new Employee(1, "John", "Doe"));


        //read
        employees.add(new Employee(1, "John", "Doe"));
        //employees.add(john);

        System.out.println(employees);
    }
}


```


