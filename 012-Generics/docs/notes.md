## Java 1.5 Generics

Bu, Java'nın en temel ve en dönüştürücü özelliklerinden biridir. Java Generic'ler, dilin tip sisteminin (type system)
evrimindeki en önemli adımdır.Bu konuyu, bu anlamda tarihsel bağlamda anlamak önemlidir.

 Problem (J2SE 1.4 ve Öncesi)
  Generic'ten önce, Java collections ve diğer konteyner sınıfları Object tipi üzerinden çalışmak zorundaydı.
  (Hala bu yönetim arka tarafta Object türü üzerinden işletilir.
  Burada kastedilen Object tipinin gerektirdiği tür dönüşüm işlemlerinin hesaba katılarak kod yazılmasıdır.)

Bu durum bazı sorunları ortaya çıkarmıştır:
1. **Tip güvenliği yoktu:** Bir collection'a (örneğin ArrayList) herhangi bir türde nesne eklenebilirdi. (Bknz: PreJava5.java)
2. **Açık tip dönüşümü (Explicit Casting) zorunluluğu:** Collection'dan bir nesne alındığında, genelde onu tekrar orijinal
tipine dönüştürmek  (cast) zorunluydu ve asıl yapılacak iş için verbose kodların oluşmasına neden oluyordu.
3. **Hataların çalışma zamanında ortaya çıkması:** Yanlış tipte bir nesne collection'a eklendiğinde, bu bir derleme zamanı
hatası vermezdi. Hata, ancak o nesneyi alıp yanlış bir tipe dönüştürmeye çalışıldığında, çalışma zamanında bir
<code style="color: red">**ClassCastException**</code> olarak ortaya çıkardı.

   Bu durum, _"programcının hafızasına güvenen"_ bir sistem yaratıyordu ve büyük ölçekli uygulamalarda ciddi bir hata
   kayanağı oluşturuyordu.
 
### Çözümün doğuşu - JSR 14

Generics, modern JEP (Java Enhancement Proposal) sisteminden önce, JSR(Java Specification Request) süreciyle dile eklendi.

* https://jcp.org/aboutJava/communityprocess/final/jsr014/index.html
* https://jcp.org/en/jsr/detail?id=14 

**Ana Spesifikasyon:** _**JSR 14**_ : _Add Generic Types To The Java Programming Language_ \
**Yayın:** J2SE 5.0 (Kod Adı _"Tiger"_) - 2004 
 #### JSR 14 Temel Gerekçeleri
 1. **Derleme Zamanı Tip Güvenliğinin Sağlanması(Compile-Time Type Safety):** En temel gerekçedir.Yukarıda  belirtilen ClassCastException hatasını çalışma zamanından derleme zamanına taşımak.

 2. **İfade gücünü artırmak:** Kodun "niyetini" daha açık hale getirmek. List<String> tanımı, "bu liste sadece String  nesneleri içerir" demektedir.Bu, hem kodu okuyan geliştirici hem de derleyici için açık bir sözleşmedir.

 3. **Yeniden Kullanılabilirliği ve Soyutlamayı Artırmak(Reusability & Abstraction):** List gibi veri yapılarını,
 içerdikleri tipten bağımsız olarak(tip parametresi alarak) yazabilmeyi sağlamak. Bu bilgisayar bilimlerinde
 ***Parametrik Polimorfizm(Parametric Polymorphism)*** olarak bilinen kavramın Java'ya uygulanmasıdır.

Örn:
```java
      // Tip güvenli bir liste

        List<String> list = new ArrayList<String>();
        list.add("Hello");
        // list.add(1); Compile-Time Error

        Object o = list.get(0); // OK

        String s = list.get(0); // OK
```        
        

 #### Temel Kavramlar ve JLS Referansları

1. **Tip Değişkenleri (Type Variables)** \
    **JLS 4.4**\
    T,K,V,E gibi "yer tutucu" tiplerdir
      
Örn:
```java 
    public class Box<T>{
        private T t;
    }
```
Buradaki \<T>, bu sınıfın bir tip değişkeni aldığını belirtir.

2. **Parametrelendirilmiş Tipler (Parameterized Types)**\
   **JLS 4.5**\
Generic bir tipin, gerçek bir tip argümanıyla kullanılmasıdır.

 Örn:
```text
   Box<Pencil>, List<Integer>..
   List<Integer> bir tiptir, List bir generic tip bildirimidir.
   List<List<Integer>>
```
  

3. **Ham Tipler (Raw Types)**\
   **JLS 4.8**\
   Generic bir tipin, tip argümanı olmadan kullanılmasıdır
Örn: 
```
   List list = ....
```
>**Gerekçe**: Geriye Yönelik Uyumluluk (Backward Compatibility). Generic öncesi kodların (legacy code) generic
sonrası kodlarla çalışabilmesi için yapılmıştır.
     
4. **Joker Karakterler (Wildcards)**\
     **JLS 4.5.1**\
     Generic'lerin daha esnek kullanılmasını sağlar. "?" ile ifade edilir.


---
### JEP Tarihçesi: [JEP 1](https://openjdk.org/jeps/1 "JEP 1")

---


### Parametric Polymorphism
   Bilgisayar bilimlerinde, bir fonksiyonun ya da bir veri yapısının, üzerinde işlem yaptığı verinin spesifik tipinden
   bağımsız olarak yazılabilmesini sağlayan bir programlama dili özelliğidir.
    Bu anlamda, bir kod bloğunu, daha sonra belirlenecek bir tip parametresi alacak şekilde yazmaktır denilebilir.

--- 
**Exercises_0 Notları**

 LinkedStack.java

---
  * The null ambiguity
  * Tell, Don't Ask Principle
  * Business Logic Leakage
---
 >"Bir nesne kendi geçerli durumunu doğrulatmak zorunda kalmamalıdır"

  Bu,
   - Encapsulation
   - Object Invariants

   ilkelerini birleştiren özetleyici bir tanımlamadır.

>Yani, bir nesne dış dünyaya "ben tutarlıyım ve geçerliyim" garantisi vermeli

---

PreJava5.java ve Java5Generics.java sınıflarının derleme çıktıları:
 
```terminaloutput

[PreJava5.class]
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
      > 31: checkcast     #11                 // class java/lang/Integer
      > 34: invokevirtual #54                 // Method java/lang/Integer.intValue:()I
      37: iconst_2
      38: imul
      39: invokevirtual #57                 // Method java/io/PrintStream.println:(I)V
      42: iinc          1, 1
      45: goto          2
      48: return


[Java5Generics.class]
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
      > 22: checkcast     #11                 // class java/lang/Integer
      > 25: invokevirtual #49                 // Method java/lang/Integer.intValue:()I
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

  **Ana Bileşenler:**
  * **Product:** Fabrika metodunun üreteceği nesneler için ortak arayüz. 
  * **ConcreteProduct:** Product arayüzünü uygulayan gerçek nesneler
  * **Creator:** _'factoryMethod'_ olarak adlandırılan[^1] soyut bir metodu bildirir. Bu metodun geri dönüş türü Product arayüzüdür.
  * **ConcreteCreator:** Creator sınıfından miras alır ve factoryMethod'u override ederek belli bir ConcreteProduct nesnesini
    üretip geri döner.

[^1]: Bu adlandırma bire bir metot adını nitelendirmez

 ---
> Generic parametreleri new operatörüyle kullanılamazlar.

Örn:
```java

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

---
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
---

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
  ## Generic Methods

   JLS, (özellikle Bölüm 8.4.4), generic bir metodu kendi biçimsel tip parametrelerini (formal type parameters)
   deklare eden bir metot olarak tanımlar.

   **Tanım:** Bir metodun imzası, dönüş tipinden önce açılı parantezler (<>) içinde bir veya daha fazla tip parametresi listesi
   içeriyorsa, bu bir generic metotdur.

   **Kapsam(Scope):** Bu tip parametreleri, yalnızca deklare edildikleri ilgili metodun kapsamı boyunca geçerlidir.

   **Bağımsızlık:** Bir metodun generic olması, içinde bulunduğu sınıfın veya arayüzün generic olup olmamasından bağımsızdır.

```java
   public class Util{
      public static <T> T foo(T t){
            // Bu bir generic metotdur.
      }
   }
```

 Burada <T>, bu metodun bir generic metot olduğunu ve *T* adında bir tip parametresi aldığını bildirir.

 Generic metotlar tip güvenliğini (type safety) korurken, farklı tipler üzerinde çalışabilen genelleştirilmiş metotlar
 olarak da tanımlanabilir.
 >"Kendi tip parametrelerini bildiren metotlar"

 Yukarıdaki "Bağımsızlık" bölümü üzerine: Generic metotlar bir sınıfın tamamını generic yapmaya gerek kalmadan, tek bir
 metodun güvenli bir şekilde farklı tiplerle çalışmasına olanak tanır.
 Tekrar söylemek gerekerse burada generic metotlar için sınıfın generic olması zorunluluğu YOKTUR

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
  ### Generic Varargs
  
  Bu konu, iki Java özelliğinin (Generics ve Varargs) kesişiminde ortaya çıkan karmaşık ve önemli bir durumu ifade 
eder.

>JLS, "generic varargs" terimini doğrudan bir tanım olarak kullanmak yerine, **yeniden doğrulanabilir olmayan(non-reifiable) 
> bir tipin** değişken argüman(varargs) parametresi olarak kullanılmasının sonuçlarını tanımlar.

Bir metot, <code>T... args </code> veya <code>List\<T>... args</code> gibi non-reifiable bir tipte varargs parametresi 
içerdiğinde, bu durum JLS tarafından "potansiyel olarak güvenli olmayan" bir kullanım olarak işaretlenir.

**Sorun: Heap Pollution(Yığın Kirliliği):** JLS's göre sorun: 
1. varargs özelliği, derleyici tarafından gizlice bir **diziye** dönüştürülür. (Örn: <code>T... args</code> metot içinde 
```T[]``` args olur)
2. Ancak, Java'da generic tiplerin dizilerini oluşturmak (tip silinmesi- type erasure nedeniyle) tip-güvenli değildir.\
(```new T[]``` yapılamaz)
3. Derleyici bunun yerine bir ```Object[]``` dizisi oluşturur ve bu diziyi ```T[]``` tipine cast eder.
4. Bu durum, derleme zamanında "unchecked" (kontrolsüz) bir uyarıya neden olur ve çalışma zamanında ```ClassCastException``` 
riskine yol açan ***heap pollution*** potansiyeli yaratır. (Yani ```List<String>...``` olarak gelen diziye, metot içinde 
```List<Integer>``` eklemeye çalışmak gibi)


>JLS'in bahsettiği "heap pollution" riski : ```varargs```'ın dizi tabanlı doğası, generics'in tip silme(type-erasure) 
> doğasıyla çakışır. Derleyici, bu potansiyel tehlikeye karşı programcıyı uyarmak için bir "unchecked warning" verir.

### @SafeVarargs
 ```@SafeVarargs```, tam olarak yukarıda açıklanan "generic varargs" sorununu çözmek için Java 7'de tanıtılmış bir 
annotasyondur.

 **Tanım (JLS 9.6.4.7):** ```@SafeVarargs```, "programcının", ilgili metot veya ctor gövdesinin, ```varargs```  
parametresi (variable arity parameter) üzerinde **potansiyel olarak güvenli olmayan işlemler yapmadığına dair bir beyandır.**

**Amacı:** Bu annotation'ı kullanan programcı, derleyiciye şu sözü verir : "Bu metot, ```varargs``` parametresi olarak gelen
ve aslında bir dizi olan bu yapıyı kötüye kullanmayacak, içine yanlış tipte veri yazmayacak veya heap pollution'a neden 
olacak şekilde dışarıya sızdırmayacak."

**Sonuç:** Derleyici bu beyana güvenir ve metodu kullanan yerlerde ve metodun kendisindeki "unchecked" uyarılarını **bastırır(suppress)**

>@SafeVarargs programcının, derleyiciye "Bana güven, ne yaptığımı biliyorum" deme yoludur. Eğer metot, ```varargs``` dizisine 
> sadece veri okumak veya dizinin elemanlarını işlemek için (yazma yapmadan) kullanılıyorsa, bu annotation güvenle kullanılabilir.

#### Önemli Kısıtlama (JLS)
 ```@SafeVarargs``` her metoda uygulanamaz. Yalnızca override edilemeyen (non-overridable) metotlara uygulanabilir.
Çünkü bir metot override edilebilirse, alt sınıf bu "güvenli" sözleşmeyi bozabilir.

Bu nedenle ```@SafeVarargs``` yalnızca şu metotlara uygulanabilir:
- ```static``` metotlar
- ```final``` metotlar
- (Java 9+) ```private``` instance metotlar
    
 ### Type Erasure
  Java'da generic'ler, büyük ölçüde **yalnızca derleme zamanında(compile-time)** var bir özelliktir.
   
Java derleyicisi, generic tip bilgilerini(örn: ```List<String>``` veya ```Map<Integer, Customer>``` ) kullanarak 
kodun tip güvenliğini derleme zamanında kontrol eder. Bu kontrolü bitirdikten sonra, derleyici bu tip bilgilerinin çoğunu 
**bytecode'dan siler**
 
Çalışma zamanında (runtime), ```List<String>``` diye bir şey yoktur. O sadece ham tip (raw type) olan bir ```List``` 
olarak var olur.

  #### Nasıl ?
  
  Derleyici, generic tip parametrelerini (örn: ```<T>```) alır ve onları "sınırları"(bounds) ile değiştirir.
* Eğer bir tip ```<T extends Animal>``` olarak tanımlanmışsa, ```T```'nin geçtiği her yer derleme sonrası 
```Animal``` tipi ile değiştirilir.
* Eğer bir tip ```T``` gibi sınırsız(unbounded) tanımlanmışsa, ```T```'nin geçtiği her yer ```Object``` tipi 
ile değiştirilir.

  #### The Mystery (Gizemli olan taraflar)
Burada vurguladığımız "gizem", bu silme işleminin çalışma zamanındaki yan etkilerinden kaynaklanır.

1.**Çalışma Zamanında Tipler Aynıdır:** ```List<String>``` ve ```List<Integer>``` sınıfları, çalışma zamanında 
tamamen aynı ```Class``` nesnesini paylaşır.

```java

        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        System.out.println(stringList.getClass() == integerList.getClass()); // true
```

2.**```instanceof``` Kullanılmamalı:** Bir nesnenin generic bir tipe ait olup olmadığı 
```instanceof``` ile kontrol edilmemelidir. Çünkü çalışma zamanında bu bilgi yoktur.
Referansın kendi türüne izin verebilir. 

Örn: Referansın türü ```List<String``` olsun. 

```java
    if(obj instanceof List<String>) { ... } // COMPILE-TIME ERROR 
    if(obj instanceof List) { ... } // Legal 
```
3. **Generic Dizi Oluşturulamaz:** ```new T[]``` gibi bir ifade kullanılamaz. Çünkü derleyici ```T```'in ne olduğunu 
bilmeden bir dizi oluşturamaz. (En fazla ```new Object[]``` oluşturup cast edilebilir. Bu da ***risklidir/tehlikelidir***)

4. **```Class<T>``` Sınırlamaları:** Bir ```Class``` nesnesi generic bir tipten alınamaz.
 Örn: ```String.class``` ifadesi yazılabilirken: 
```java
    List<String>.class; // COMPILE-TIME ERROR 
```

#### Neden Erasure? 
  Bu tasarım kararının en büyük ana nedeni: **Geriye Dönük Uyumluluk(Backward Compatibility)**

- Generic'ler (yukarıda da belirtildiği gibi) Java'ya 1.5 (JDK 5) sürümünde eklendi.
- O zamana yazılmış _milyonlarca_ satır "eski" (non-generic) Java kodu vardı.(Bknz:  ```PreJava5.java```)
- Java'nın tasarımcıları, bu eski kodların değiştirilmeden yeni generic kodlarla bir arada çalışabilmesini istiyordu.
- Eğer Java, C# gibi **"Reified Generics"** (tip bilgisini çalışma zamanında koruyan) bir yaklaşım seçseydi, ```List```(eski)
ve ```List<String>```(yeni) tamamen farklı ve uyumsuz tipler olurdu.Bu, tüm eski kütüphanelerin kırılması anlamına gelirdi.

"Tip Silinmes", eski ve yeni kodların aynı ```List``` tipini paylaşarak bir arada yaşamasına izin veren bir "köprü" 
mekanizması olarak seçildi.


### Reifiable Types (Yeniden Doğrulanabilir Tipler- Çalışma Zamanında Bilgisine Erişilebilir Tipler)
  
  JLS, bir tipin reifiable olmasını, "çalışma zamanında(runtime) tip bilgisinin tamamen mevcut ve doğrulanabilir" olması 
olarak tanımlar.Eğer bir tip bilgisi tip silinmesi(erasure) nedeniyle kayboluyorsa, bu tip **non-reifiable** olur 

#### Neler "Reifiable" ?
   * **Primitive Tipler:** ```int```,```double``` vb.
   * **Non-Generic Sınıflar/Arayüzler:**```String```,```Integer```, ```Number```, ```Object```, ```PdfDocument``` vb.
   * **Ham Tipler(Raw Types):**```List```, ```Queue```,```Map``` vb. (Generic bilgisi olmayan tipler)
   * **Diziler(Arrays):** ```String[]```, ```int[]``` vb.
   * **Sadece Sınırlandırılmamış Wilcard (Unbounded Wilcards) İçerenler:** ```List<?>, Map<?,?>```  vb. (Çünkü "ne olduğunu bilmiyorum" 
bilgisi çalışma zamanında da geçerlidir.)

  
### Generic Bounds
   "Bounds", bir generic tipi veya metodu **deklare ederken(bildirilirken)** kullanılır.
 
#### Sorun:
Basit bir generic tip (```<T>```) yazıldığında, ```T``` hakkında hiç bir şey bilinmez.JLS'e göre bu ```T```, 
tip silinmesi sırasında ```Object``` ile değiştirilir.

```java
   public class Box<T>{
        private T item;
        
        public void foo() {
            item.doSomething(); // ERROR: T'nin Object olduğu varsayılır
                                // 'Object' sınıfında doSomething() metodu yoktur.
        }
  }
```

#### Çözüm: Bound(Sınır) Koymak

  ```<T extends SomeClass``` sözdizimi, derleyiciye "T'nin ne olduğunu bilmiyorum ama _en azından_ ```SomeClass``` 
  (veya onun bir alt sınıfı) olduğunu biliyorum" demektir.

```java
public class NumericBox <T extends Number> {

    private T item;

    public void foo(){
        item.intValue();
    }
}

```
> JLS bunu "Tip Değişkeni Sınırı" (Type Variable Bound) olarak adlandırır. ```T```'nin yerine geçebilecek tiplerin 
> _üst sınırını_(upper bound) tanımlar. JLS, ```T```'nin tip silinmesi sırasında ```Object``` yerine ```Number``` (yani sınırıyla) 
> değiştirileceğini söyler.

>Bu da bir "Erasure Telafi Tekniği" olarak görülebilir: Tip silinmesi ```T```'yi ```Object```'e dönüştürerek tüm anlamı 
> yok edecekti; _bound_ kullanarak en azından silinmiş tipin daha anlamlı bir üst tipe dönüşmesini sağlarız.

>"Generic bir tip üzerinde belirli metotları çağırmak isteyebiliriz." İlgili tipin bu metotlara sahip olmasını garantilemek 
> için 'bounded type' kullanılır.


### Wildcards - <?>
 "Wildcards", generic tipleri **kullanırken** (örneğin metot parametresi olarak) kullanılır.Bounds tanımlama, Wildcards kullanma ile 
ilgilidir.

#### Sorun: Generic'ler "Invariant"tır(Değişmez)
 En önemli kural budur. ```Integer```, ```Number```'ın bir alt sınıfıdır. **Ancak** ```List<Integer>```, ```List<Number>```'ın 
**bir alt sınıfı DEĞİLDİR**

Neden?
 Eğer olsaydı....

```java
  List<Number> numberList = new ArrayList<Integer>();  // Kovaryans varsayımı

  // numberList bir 'List<Number>' olduğu için 'Double' ekleyebilmemiz gerekirdi.

  numberList.add(1.); // ??

  //Ama bu liste aslında List<Integer> idi. !!!
// Bir List<Integer> içine Double atarak yığını kirlettik (Heap Pollution)

```

Java bu tehlikeyi baştan engeller ve ```List<Integer>```'ı ```List<Number>```'a atamammıza izin vermez.

#### Çözüm: Esneklik için Wildcards
  Peki, ```Integer``` listesi veya ```Double``` listesi kabul eden ve içindekilerin toplamını hesaplayan bir metodu 
nasıl yazarız ?

Cevap: **Upper-Bounded Wildcards(Kovaryans)**

**A.Upper-Bounded Wildcards:** ```<? extends Number>```

 * **Anlamı:** "Bilinmeyen bir tip ```?```, ama ```Number```'ın alt sınıfı(veya kendisi)"
 * **Ne İşe Yarar?:** ```List<Integer>```, ```List<Double>``` ve ```List<Number>``` tiplerinin hepsinin  
```List<? extends Number>``` tipine atanabilmesini sağlar. Buna **Kovaryans(Covariance)** denir.
 * **Kural:** **"Producer"(üretici)-READ ONLY** Bu tip bir listeden **sadece okuma(get)** yapabilirsiniz.
Bu listeye **yazma (add) YAPAMAZSINIZ** (```null``` dışında)

```java
    public double sum(List<? extends Number> numbers){
            double total = 0;
            for(Number n: numbers){
                total += n.doubleValue();
            }
            
            numbers.add(5); // Integer listesi olduğunu nereden biliyoruz ????
                            // Derleyici bu riski almaz
            return total;
   }

```

**B.Lower-Bounded Wildcards:** ```<? super Integer>```

* **Anlamı:** "Bilinmeyen bir tip ```?```, ama ```Integer```'ın üst sınıfı(veya kendisi)"
* **Ne İşe Yarar?:** Esnek bir yazma hedefi sağlar. Buna **Kontravaryans(Contravariance)** denir.
* **Kural:** **"Consumer"(tüketici)-WRITE ONLY** Bu tip bir listeye **yazma(add)** yapabilirsiniz.
  Bu listeden **okuma (get) YAPAMAZSINIZ** (dönen tipin ```Object``` olduğunu kabul etmiyorsanız)

```java
  
  public void addIntegers(List<? super Integer> dest, List<Integer> source){
    
    for(Integer i : source) {
        dest.add(i); // YAZMA GÜVENLİ. Çünkü dest listesi List<Integer>, List<Number> veya List<Object> olabilir.
                     // Bu tiplerin hepsi de 'Integer' kabul eder.
    }
    
    Integer i = dest.get(0); // ERROR
      // Neden? Ya dest listesi List<Object> ise ? 
      // 'get(0)' bir Object döndürür, bu Integer'a güvenle atanamaz.
    
  }

```

**C.Unbounded Wildcards:** ```<?>```

* **Anlamı:** "Bilinmeyen herhangi bir tip. ```<? extends Object>``` ile neredeyse aynıdır"
* **Kullanım:** Tipin ne olduğunun hiç önemli olmadığı durumda kullanılır. ```List.size()``` veya ```List.clear()```
gibi metotlar yazmak için idealdir.
* **Kural:** ```get()``` sadece ```Object``` döner, ```add()``` ise ```null``` dışında hiçbir şey kabul etmez.

### Intersection Types (Kesişim Tipleri)
 
**Tanım(JLS 4.9):** JLS, "intersection type" kavramını, bir tipin **birden fazla** üst sınıra(upper-bound) sahip olma 
durumu olarak tanımlar. Bu, tip parametresinin aynı anda birden fazla tipin özelliğini taşımasını garanti altına alır.


* **Sözdizimi(Syntax):** Kesişim tipler ```&``` operatörü ile belirtilir.
* **Kullanım:** ```<T extends A & B & C & D>```

>**En Önemli JLS Kuralı:** JLS, bu listede (& ile belirtilen tip listesi) **en fazla bir adet sınıf(class)** olabileceğini 
ve eğer varsa bu sınıfın listenin **en başında** yer alması gerektiğini şart koşar.Listede geri kalan tüm tipler 
**arayüz(interface)** olmalıdır.

>**Neden?** Java'da bir sınıf, sadece bir üst sınıftan miras alabilir(single inheritance) ama birden fazla arayüzü implemente edebilir.
Kesişim tipi, bu kuralı yansıtır.


```java
 public <T extends MyClass & MyInterface> void process(T item){
    item.myClassMethod();
    item.myInterfaceMethod();
}

```

> (!) **Primitive Türler parametrik tür olarak kullanılamazlar !**\
> örn: ```List<int>``` YAZILAMAZ


 ### Diamond Operatörü (JAVA 7)
   Type Inference ile ilgili bir durumdur. Java 7 ile birlikte gelen diamond(<>) operatörünün, tip çıkarımının en büyük
   kolaylığı olduğunu söyleyebiliriz. Derleyici, "hedef tipe" (target type-atanacak olan tip) bakarak ```new``` ifadesinin 
   generic tipini anlar.

```java
  // ESKİ (JAVA 6) - Gereksiz Tekrar 
  List<String> list = new ArrayList<String>();

  // YENİ (Java 7+) - Diamond ile Tip Çıkarımı:
  List<String> list = new ArrayList<>(); // SAĞ TARAF list'ten anlaşılmıştır. (Type Inference)
```
 

> JAVA 10+:  Aynı çıkarım contexual keyword olan ```var``` anahtar kelimesiyle kullanımda da geçerlidir.\
>  ```var list = new ArrayList<String>()```

> **CASE !!** Peki ya hem var hem de diamond kullanılırsa ?\
>  var list = new ArrayList<>(); Bu durumu açıklayınız.



