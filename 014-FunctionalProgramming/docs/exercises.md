##### Excercise:
E-Ticaret Fiyat Hesaplama Sistemi

Hedef: Bir ürünün fiyatını farklı indirim veya vergi kurallarına göre hesaplayan bir yapı 
kurulması bekleniyor.


>- PricePolicy Interface olmalı.
>- Bu interface'in tek metodu olmalı:  double  apply(double price)

>- ShopSystem Sınıfı olmalı
>- Bu sınıfın static checkout(double price, PricePolicy policy) metodu olmalı. Bu metot
sonucu hesaplayıp ingilizce formatta standart çıktıya göndermeli.

### Senaryo-1 : Standard Tax
>Fiyata %18 KDV (VAT) eklenmesi. 
 
Hint: Anonymous Class 

### Senaryo-2 : Seasonal Discount
>Fiyat 1000'den büyükse %20; değilse %10 indirim yapılmalı

Hint: Multi-Line Lambda

### Senaryo-3 : Black Friday
> Fiyat ne olursa olsun %50 indirim yapılsın

Hint: Single-Line Lambda

---
##### Excercise:

```RepeatUtil``` isimli sınıf içerisinde static olarak ```repeat``` isimli metodu yazınız. Metot kaç kez tekrar yapılacağı
bilgisiyle, "ne" yapılacağını parametresiyle alsın.\
**Hint:*** ```IntStream``` arayüzü üzerindeki ```range``` metoduna bakınız.

--- 

##### Excercise (Homework):

```PasswordUtil``` isimli sınıf içerisinde static olarak ```generate``` isimli metodu yazınız. Metot 
aldığı int türden parametre ile üretilecek password'ün uzunluk bilgisini alacak.
Metot password oluşturma kurallarını kendi içinde yürütecek.



