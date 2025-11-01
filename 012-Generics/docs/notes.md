Java 1.5 Generics

Bu, Java'nın en temel ve en dönüştürücü özelliklerinden biridir. Java Generic'ler, dilin tip sisteminin (type system)
evrimindeki en önemli adımdır.Bu konuyu, bu anlamda tarihsel bağlamda anlamak önemlidir.

 Problem (J2SE 1.4 ve Öncesi)
  Generic'ten önce, Java collections ve diğer konteyner sınıfları Object tipi üzerinden çalışmak zorundaydı.
  (Hala bu yönetim arka tarafta Object türü üzerinden işletilir.
  Burada kastedilen Object tipinin gerektirdiği tür dönüşüm işlemlerinin hesaba katılarak kod yazılmasıdır.)

  Bu durum bazı sorunları ortaya çıkarmıştır:
   1. Tip güvenliği yoktu: Bir collection'a (örneğin ArrayList) herhangi bir türde nesne eklenebilirdi. (Bknz: PreJava5.java)
   2. Açık tip dönüşümü (Explicit Casting) zorunluluğu: Collection'dan bir nesne alındığında, genelde onu tekrar orijinal
   tipine dönüştürmek  (cast) zorunluydu ve asıl yapılacak iş için verbose kodların oluşmasına neden oluyordu.
   3. Hataların çalışma zamanında ortaya çıkması: Yanlış tipte bir nesne collection'a eklendiğinde, bu bir derleme zamanı
   hatası vermezdi. Hata, ancak o nesneyi alıp yanlış bir tipe dönüştürmeye çalışıldığında, çalışma zamanında bir
   "ClassCastException" olarak ortaya çıkardı.

   Bu durum, "programcının hafızasına güvenen" bir sistem yaratıyordu ve büyük ölçekli uygulamalarda ciddi bir hata
   kayanağı oluşturuyordu.

   # Çözümün doğuşu - JSR 14
    Generics, modern JEP (Java Enhancement Proposal) sisteminden önce, JSR(Java Specification Request) süreciyle dile
    eklendi.

    - https://jcp.org/aboutJava/communityprocess/final/jsr014/index.html
    - https://jcp.org/en/jsr/detail?id=14
    Ana Spesifikasyon: JSR 14 : Add Generic Types To The Java Programming Language
    Yayın: J2SE 5.0 (Kod Adı "Tiger")- 2004

    JSR 14 Temel Gerekçeleri
     1. Derleme Zamanı Tip Güvenliğinin Sağlanması(Compile-Time Type Safety): En temel gerekçedir.Yukarıda
     belirtilen ClassCastException hatasını çalışma zamanından derleme zamanına taşımak.

     2. İfade gücünü artırmak: Kodun "niyetini" daha açık hale getirmek. List<String> tanımı, "bu liste sadece String
     nesneleri içerir" demektedir.Bu, hem kodu okuyan geliştirici hem de derleyici için açık bir sözleşmedir.

     3. Yeniden Kullanılabilirliği ve Soyutlamayı Artırmak(Reusability & Abstraction): List gibi veri yapılarını,
      içerdikleri tipten bağımsız olarak(tip parametresi alarak) yazabilmeyi sağlamak. Bu bilgisayar bilimlerinde
      Parametrik Polimorfizm(Parametric Polymorphism)* olarak bilinen kavramın Java'ya uygulanmasıdır.

       Örn:
          // Tip güvenli bir liste

          List<String> list = new ArrayList<String>();
          list.add("Hello");
          // list.add(1); Compile-Time Error

          Object o = list.get(0); // OK

          String s = list.get(0); // OK

        Temel Kavramlar ve JLS Referansları

        1. Tip Değişkenleri (Type Variables)
        JLS 4.4
        T,K,V,E gibi "yer tutucu" tiplerdir
        Örnek :  public class Box<T>{
                    private T t;
                 }
        Buradaki <T>, bu sınıfın bir tip değişkeni aldığını belirtir.
        2. Parametrelendirilmiş Tipler (Parameterized Types)
           JLS 4.5
         Generic bir tipin, gerçek bir tip argümanıyla kullanılmasıdır.
         Örn:  Box<Pencil>, List<Integer>..
         - List<Integer> bir tiptir, List bir generic tip bildirimidir.
           List<List<Integer>>
        3. Ham Tipler (Raw Types)
           JLS 4.8
           Generic bir tipin, tip argümanı olmadan kullanılmasıdır
            Örn: List list = ....
             Gerekçe: Geriye Yönelik Uyumluluk (Backward Compatibility). Generic öncesi kodların (legacy code) generic
             sonrası kodlarla çalışabilmesi için yapılmıştır.
       4. Joker Karakterler (Wildcards)
          JLS 4.5.1
          Generic'lerin daha esnek kullanılmasını sağlar. "?" ile ifade edilir.


  -------------------------------------------------------
  ### JEP Tarihçesi:

  [https://openjdk.org/jeps/1](URL "JEP 1")

  --------------------------------------------------------


  ### Parametric Polymorphism
   Bilgisayar bilimlerinde, bir fonksiyonun ya da bir veri yapısının, üzerinde işlem yaptığı verinin spesifik tipinden
   bağımsız olarak yazılabilmesini sağlayan bir programlama dili özelliğidir.
    Bu anlamda, bir kod bloğunu, daha sonra belirlenecek bir tip parametresi alacak şekilde yazmaktır denilebilir.



 ----------------------------------------------------------------
  * The null ambiguity
  * Tell, Don't Ask Principle
  * Business Logic Leakage
-------------------------------------------------------------------------
 "Bir nesne kendi geçerli durumunu doğrulatmak zorunda kalmamalıdır"
  Bu
   - Encapsulation
   - Object Invariants
   ilkelerini birleştiren özetleyici bir tanımlamadır.
   Yani, bir nesne dış dünyaya "ben tutarlıyım ve geçerliyim" garantisi vermeli

---------------------------------------------------------------------
```

 PreJava5.class
 ...
public static void doProcessOnList(java.util.List);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: aload_0
       4: invokeinterface #38,  1           // InterfaceMethod java/util/List.size:()I
       9: if_icmpge     48
      12: aload_0
      13: iload_1
      14: invokeinterface #44,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      19: astore_2
      20: aload_2
      21: instanceof    #11                 // class java/lang/Integer
      24: ifeq          42
      27: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      30: aload_2
      31: checkcast     #11                 // class java/lang/Integer
      34: invokevirtual #54                 // Method java/lang/Integer.intValue:()I
      37: iconst_2
      38: imul
      39: invokevirtual #57                 // Method java/io/PrintStream.println:(I)V
      42: iinc          1, 1
      45: goto          2
      48: return


Java5Generics
...
 public static void doProcessOnList(java.util.List<java.lang.Integer>);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: aload_0
       4: invokeinterface #33,  1           // InterfaceMethod java/util/List.size:()I
       9: if_icmpge     39
      12: getstatic     #39                 // Field java/lang/System.out:Ljava/io/PrintStream;
      15: aload_0
      16: iload_1
      17: invokeinterface #45,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      22: checkcast     #11                 // class java/lang/Integer
      25: invokevirtual #49                 // Method java/lang/Integer.intValue:()I
      28: iconst_2
      29: imul
      30: invokevirtual #52                 // Method java/io/PrintStream.println:(I)V
      33: iinc          1, 1
      36: goto          2
      39: return
 ```     
--------------------------------------------------------------------------------------------------------------------
  ### Factory Method Design Pattern
  Creational(Yaratımsal) tasarım desenlerinden biridir.

  Temel Amaç: Bir nesne yaratmak için bir arayüz(interface) tanımlar, ancak hangi sınıfın örneğinin(instance) oluşturulacağına
  alt sınıfların karar vermesine izin verir. Yani nesne oluşturma(instantiation) işlemini alt sınıflara erteler.

  Bu desen, bir sınıfın, hangi somut sınıftan nesne üreteceğini bilemediği ve "bilmek zorunda olmadığı/bilmek istemediği"
  durumlarda kullanılır.Sorumluluğu kendisinden miras alan alt sınıflara bırakır.

  Ana Bileşenler:
    Product: Fabrika metodunun üreteceği nesneler için ortak arayüz.
    ConcreteProduct: Product arayüzünü uygulayan gerçek nesneler
    Creator: "factoryMethod" olarak adlandırılan* soyut bir metodu bildirir. Bu metodun geri dönüş türü Product arayüzüdür.
    ConcreteCreator: Creator sınıfından miras alır ve factoryMethod'u override ederek belli bir ConcreteProduct nesnesini
    üretip geri döner.

  * Bu adlandırma bire bir metot adını nitelendirmez

 ---------------------------------------------------------------------------------------------------------------------------
 ```java
    Generic parametreleri new operatörüyle kullanılamazlar.

    Örn:

    public interface GenericDocumentFactory<T> {

        /*
            factoryMethod
         */
        T createDocument();

    }

    public class DefaultDocumentFactoryImpl<T> implements GenericDocumentFactory<T>{


        @Override
        public T createDocument() {
            return new T(); // COMPILE-TIME ERROR
        }

    }

    public class Driver {

        public static void main(String[] args) {
            GenericDocumentFactory<WordDocument> wordDocumentFactory = new DefaultDocumentFactoryImpl<WordDocument>();

            wordDocumentFactory.createDocument();

            GenericDocumentFactory<PdfDocument> pdfDocumentFactory = new DefaultDocumentFactoryImpl<PdfDocument>();

        }

    }
```
  Yukarıdaki tasarım kısıtını düşününüz.
---------------------------------------------------------------------
```java
        public interface GenericDocumentFactory<T> {

            /*
                factoryMethod
             */
            T createDocument();

        }


 public class DefaultDocumentFactoryImpl implements GenericDocumentFactory<Document>{

     private Class<?> type;

     public DefaultDocumentFactoryImpl(Class<?> type){
         this.type = type;
     }

     @Override
     public Document createDocument() {
         try {
             return (Document) type.getDeclaredConstructor().newInstance();
         } catch (NoSuchMethodException e) {
             throw new RuntimeException(e);
         } catch (InvocationTargetException e) {
             throw new RuntimeException(e);
         } catch (InstantiationException e) {
             throw new RuntimeException(e);
         } catch (IllegalAccessException e) {
             throw new RuntimeException(e);
         }
     }
 }


 public class Driver {


     public static void main(String[] args) {

         GenericDocumentFactory<Document> documentFactory = new DefaultDocumentFactoryImpl(PdfDocument.class);

         Document document = documentFactory.createDocument();
         document.open();

         document.close();

     }

 }
```
----------------------------------------------------------------------------------------------------------------------
  Yukarıdaki tasarımın aşağıdaki şekilde yeniden yapıldığına dikkat ediniz.
```java
   // GenericDocumentFactory.java
   public interface GenericDocumentFactory {

       /*
           factoryMethod
        */
       static <T> T createDocument(Class<T> type){
           try {
               return type.getDeclaredConstructor().newInstance();
           } catch (InstantiationException e) {
               throw new RuntimeException(e);
           } catch (IllegalAccessException e) {
               throw new RuntimeException(e);
           } catch (InvocationTargetException e) {
               throw new RuntimeException(e);
           } catch (NoSuchMethodException e) {
               throw new RuntimeException(e);
           }
       }

   }
 
   // Driver.java ... .
   public class Driver {
       public static void main(String[] args) {
           Document document = GenericDocumentFactory.createDocument(WordDocument.class); // Generic Method !
           document.open();
           document.close();

       }
   }
```
--------------------------------------------------------------------------------------------------------------------
  # Generic Methods

   JLS, (özellikle Bölüm 8.4.4), generic bir metodu kendi biçimsel tip parametrelerini (formal type parameters)
   deklare eden bir metot olarak tanımlar.

   Tanım: Bir metodun imzası, dönüş tipinden önce açılı parantezler (<>) içinde bir veya daha fazla tip parametresi listesi
   içeriyorsa, bu bir generic metotdur.

   Kapsam(Scope): Bu tip parametreleri, yalnızca deklare edildikleri ilgili metodun kapsamı boyunca geçerlidir.

   Bağımsızlık: Bir metodun generic olması, içinde bulunduğu sınıfın veya arayüzün generic olup olmamasından bağımsızdır.

   ```java
   public class Util{
      public static <T> T foo(T t){
            // Bu bir generic metotdur.
      }
   }
   ```

 Burada <T>, bu metodun bir generic metot olduğunu ve T adında bir tip parametresi aldığını bildirir.

 Generic metotlar tip güvenliğini (type safety) korurken, farklı tipler üzerinde çalışabilen genelleştirilmiş metotlar
 olarak da tanımlanabilir.
   "Kendi tip parametrelerini bildiren metotlar"

 Yukarıdaki "Bağımsızlık" bölümü üzerine: Generic metotlar bir sınıfın tamamını generic yapmaya gerek kalmadan, tek bir
 metodun güvenli bir şekilde farklı tiplerle çalışmasına olanak tanır.
 Tekrar söylemek gerekerse burada generic metotlar için sınıfın generic olması zorunluluğu YOKTUR.

  ### Tip Çıkarımı (Type Inference):
  ```java
   public class Driver {
       public static void main(String[] args) {
           Document document = GenericDocumentFactory.<WordDocument>createDocument(WordDocument.class);
           ...
       }
   }
   
  ``` 
    
Çoğu zaman derleyicinin, metoda geçilen argümanlara bakarak, ilgili tip parametrelerinin, ne olması gerektiğini
 otomatik olarak çıkarsayabilmesine "tip çıkarımı" denir.Bu sayede metot çağrımlarının yukarıdaki örnekte olduğu gibi
        
```java
     ...
     GenericDocumentFactory.<WordDocument>createDocument(WordDocument.class);
     ...
``` 
olarak yapılmasındansa:
       
```java     
       ...  
       GenericDocumentFactory.createDocument(WordDocument.class);
       ...
```   
   şeklinde yapılarak metot çağrılarının "temiz" kaldığını söylemek mümkündür.

---------------------------------------------------------------------------------------------------------

```java
//...
public class GenericMethods {
    public <T> void foo(T t){
        System.out.println(t.getClass().getName());
    }
}
//...
public class Driver {

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.foo(""); // type argument inference
        genericMethods.foo(1); // type argument inference
        genericMethods.foo(1.); // type argument inference
        genericMethods.foo('a'); // type argument inference
        genericMethods.foo(genericMethods); // type argument inference

    }
}
```
```text
[Output]
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Character
ba.yzl3514.generic_methods.GenericMethods
```
---

GenericMethods sınıfı aşağıdaki gibi düşününüz :

```java
public class GenericMethods {
    public void foo(Object t){
        System.out.println(t.getClass().getName());
    }
}
```
GenericMethods sınıfını aşağıdaki gibi değiştirerek çıktıyı inceleyiniz ve çıktıyı açıklayınız.

```java
//...
public class GenericMethods {
    public void foo(Object... t){
        System.out.println(t.getClass().getName());
    }
}

//....
public class GenericMethods {
    public <T> void foo(T... t){
        System.out.println(t.getClass().getName());
    }
}

public class Driver {

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.foo();
        genericMethods.foo(""); // type argument inference
        genericMethods.foo(1); // type argument inference
        genericMethods.foo(1.); // type argument inference
        genericMethods.foo('a'); // type argument inference
        genericMethods.foo(genericMethods); // type argument inference

    }
}
```

---




