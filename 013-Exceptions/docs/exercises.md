

1- **DynamicFields** 

1.1- Özel Exception Sınıfı : \
- ```DynamicFieldsException``` adında olmalı,
- Custom exception kurallarına uymalı

1.2- Ana sınıf: ```DynamicFields``` 
 ```DynamicFields``` adında bir ana sınıf oluşturun. Bu sınıf, aşağıdaki gereksinimleri karşılamalıdır.
#### Gereksinimler:

- > **Sınıfın Dahili Yapısı**
  > 
  > ```Object[][]``` türünde, ```fields``` adında bir üye değişkeni olmalıdır. Bu dizi, key-value (anahtar-değer) 
  > çiftlerini tutacaktır. (Örn: fields[0][0] anahtar, fields[0][1] değer)

- > **Ctor**
  > 
  > ```fields``` dizisi, ```initialSize``` adında bir parametre ile başlatmalıdır.
  > 
  > Dizinin tüm elemanlarını(hem anahtar hem değer konumlarını) ```null``` olarak ayarlamalıdır.
    
- > #### Public Metotlar
  > >##### toString() :
  > ```toString``` metodu override edilmeli : ```fields``` dizisindeki tüm elemanları "key: value\n" formatında 
  > ```String``` olarak döndürmelidir.
  > >##### public Object getField(String id) throws NoSuchFieldException :
  > ```id``` ile eşleşen anahtarı dizide aramalıdır.
  > Bulamazsa, NoSuchFieldException fırlatmalıdır.
  > Bulursa, o anahtara karşılık gelen değeri döndürmelidir.
  > > ##### public Object setField(String id, Object value) throws DynamicFieldsException : 
  > Bu metot aşağıdaki mantığı sırasıyla uygulamalıdır: 
  > 1. **```initCause()``` Kullanımı (Null Kontrolü)**
  > - Metodun başında ```value``` parametresinin ```null``` olup olmadığı kontrol edilmeli.
  > - Eğer ```value``` **null** ise: 
  > - - ```DynamicFieldsException``` ile yeni bir exception nesnesi oluşturulmalı.
  > - - Oluşturulan yeni exception objesi referansını kullanarak ```initCause()``` metoduna istisnanın kök nedeni belirtimeli: 
  > ```NullPointerException```
  > - - Oluşturulan yeni exception fırlatılmalı.
  > 2. **Alanı Bulma veya Oluşturma** 
  >- - ```id``` ile eşleşen bir anahtarın dizide olup olmadığı aranmalı.
  >- - **Eğer alan mevcutsa:** O alanın indeksi bir değişkende saklanmalı.
  >- - **Eğer alan mevcut değilse:**
  >  1. Dizideki ilk boş satır bulunmalı.
  >  2. Bu satırın anahtarı ```id``` olarak ayarlanmalı.
  >  3. Bu satırın indeksi bir değişkende saklanmalı.
  >  4. Eğer dizide hiç boş alan yoksa, ```fields``` dizisinini kapasitesi 1 artırılmalı.Ardından yeni eklenen satırın 
  >  indeksi kullanılmalı.
  >3.  **```Constructor Chaining``` Kullanımı**
  >- Eski değeri tutacak bir alanın tanımlanması.
  >- ```getField(id)``` metodunu kullanarak eski değerin alınması ve bu alanda saklanması.
  >- ```getField``` metodunun fırlatabileceği exceptionların nasıl handle edileceğine karar verilmesi.
  >4. **Değeri Atama ve Dönüş**
  >- Akış başarılı olursa: 
  >- -  İkinci adımda bulunan index numarasının kullanılarak ilgili dizi satırına ```value``` değerinin atanması.
  >- -  Metot eski değere geri dönerek sonlanmalı.  





