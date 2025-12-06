
https://en.wikipedia.org/wiki/Lambda_calculus
https://en.wikipedia.org/wiki/Fortran
https://openjdk.org/projects/lambda/
https://www.jcp.org/en/jsr/detail?id=335
https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html#javase8

f(x) = x + 1 fonksiyonunu düşünelim.

λ-Calculus
Matematiksel gösterimle, bir fonksiyonun argüman alması ve bir gövdeye
sahip olması aşağıdaki biçimde soyutlanır:
            λx.x+1
Burada λ, fonksiyonun başlangıcını, x parametreyi, . gövdeye geçişi temsil
eder.

#### Declarative:
SELECT first_name, last_name FROM employee;

Nasıl yapılacağı değil, Ne yapılacağının söylenmesi


#### Lambda İfadeleri
 Lambda ifadeleri (Lambda Expressions), mümkün olan en az sözdizimi(syntax) 
 kullanılarak yazılan fonksiyon tanımlarıdır.
> - Lambda ifadeleri sınıf değil, fonksiyon üretir.
> - Lambda sözdizimi mümkün olduğunca yalındır. 

Poly Expressions
https://cr.openjdk.org/~dlsmith/jsr335/jsr335-0.6.2/D.html



Func(Arg0, Arg1) -> Arg0.method(Arg1)







Target Types

java.util.function

### Fonksiyonel Arayüzler (Functional Interfaces)

Hem metot referansları hem de lambda ifadeleri bir yere atanmalıdır(assignment) ve bu atamalar,
derleyicinin tip doğruluğunu sağlayabilmesi için tip bilgisine ihtiyaç duyar.

Özellikle lambda ifadeleri yeni gereksinimler ortaya çıkarır.
Örneğin :
>   x -> x.toString()

Burada geri dönüş tipinin ```String``` olması gerektiğini görüyoruz, peki ```x```'in 
tipi nedir ? Lambda ifadeleri bir tür tip çıkarımı(type inference) içerdiğinden (yani derleyici,
programcının açıkça belirtmesine gerek kalmadan tiplerle ilgili bazı şeyleri çözümler), derleyici bir şekilde ```x```'in
tipini türetebilmelidir.

#### Operator Belirsizliği
> (x, y) -> x + y

Bu durumda ```x``` ve ```y```, ```+``` operatörünü destekleyen herhangi bir tip olabilir.Buna iki farklı sayısal 
tip veya bir ```String``` ile ```String```'e otomatik dönüşebilen başka bir tip dahildir. Ancak bu lambda ifadesi 
bir yere atandığında, derleyici doğru kodu üretmek zorundadır.Bu doğru üretebilmek için ```x``` ve ```y```'nin 
kesin tiplerini belirlemek zorundadır.

Aynı durum metot referansları için de geçerlidir.
Örneğin şu referansı bir metoda geçmek istediğimizi varsayalım : ```System.out::println```
Bu metodun argümanı için hangi tipi vereceğiz ?

Bu sorunu çözmek için Java 8, lambda ifadeleri ver metot referansları için hedef tipler(target types) olan 
bir dizi arayüzü içeren ```java.util.function``` paketini tanıttı.
Her arayüz, **fonksiyonel metod** olarak adlandırılan yalnızca bir adet soyut metot içerir.

Bu "fonksiyonel arayüz" deseni, arayüzleri yazarken ```@FunctionalInterface``` notasyonu(annotation) kullanılarak 
zorunlu kılınabilir

```java
@FunctionalInterface
public interface MyFunctionalInterface {

    String foo(String arg);

    //int bar();

    default void bar(){
        System.out.println("default method");
    }
}

public interface MyFunctionalInterfaceNoAnn {

    String tar(String arg);
}

public class Driver {

    public String goodBye(String arg){
        return "Goodbye, " + arg;
    }


    public static void main(String[] args) {

        Driver driver = new Driver();

        driver.goodBye("");

        // Target Types
        MyFunctionalInterface functionalInterface = driver::goodBye;
        MyFunctionalInterfaceNoAnn interfaceNoAnn = driver::goodBye;

        MyFunctionalInterface fl = s -> "Goodbye, " + s;
        MyFunctionalInterfaceNoAnn fnal = s -> "Goodbye, " + s;

        //MyFunctionalInterface myFunctionalInterface = driver;

    }
}

```

#### java.util.function Paketi

Bu paketin amacı, genellikle arayüz tanımlanmasına gerek kalmayacak kadar eksiksiz 
bir hedef arayüz seti oluşturmaktır. Çoğunlukla primitive tipler nedeniyle, bu durum 
bir arayüz patlamasına yol açmıştır. İsimlendirme deseninin anlaşılması arayüzün ne iş 
yaptığını daha rahat anlamamıza olanak tanır.

Temel isimlendirme kuralları şöyledir:
>- Eğer sadece nesnelerle çalışıyorsa, ```Function```,```Consumer```,```Predicate``` vb. gibi
>isme sahiptir.
>- Eğer primitive bir argüman alıyorsa, bu ismin ilk kısmında (prefix) belirtilir;örneğin 
>```LongConsumer```, ```DoublePredicate```, ```DoubleFunction``` vb. Buna istisna 
>```Supplier``` tiplerdir.
>- Eğer primitive bir sonuç döndürüyorsa bu,```To``` ile belirtilir; örneğin 
>```ToLongFunction<T>```,  ```IntToLongFunction``` 
>- Eğer argüman(lar)ı ile aynı tipi döndürüyorsa, bu bir  ```Operator```dür.Tek argüman 
>için ```UnaryOperator```, iki argüman ```BinaryOperator```
>- Eğer iki argüman alıyor ve ```boolean``` döndürüyorsa, bu bir ```Predicate```dir(BiPredicate)
>- Eğer farklı tiplerde(teorik olarak aynı tipler de olabilir) iki argüman alıyorsa, isminde ```Bi``` bulunur.

> https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

### High-Order Functions



### Closures







