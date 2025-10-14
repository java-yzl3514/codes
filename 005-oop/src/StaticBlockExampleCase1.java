/**
 *
 *
 *
 * @author Onder Sahin
 *
 */

import java.util.HashMap;

/**
 * Aşağıdaki sınıfta bir dosyadan okunan konfigürasyon parametrelerinin bir dosyadan okunarak
 * Map türünden bir veri yapısının initialize edilmesini örnekler.
 */
public class StaticBlockExampleCase1 {
        public static final java.util.Map<String,String> CONFIG_MAP;

        static {
            System.out.println("Static block is running: Configuration is loading ...");
            CONFIG_MAP = new HashMap<>();
            // Reading File Logic...
            CONFIG_MAP.put("api.url", "https://api.example.com");
            CONFIG_MAP.put("configX", "configX_value");
            //....
        }

}
