package ba.yzl3514.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ConfigLoader {

    private static final String DEFAULT_APP_PROPERTIES_FILE = "db.properties";
    private static Properties DB_PROPERTIES;

    public static Properties loadProperties() {
        if (DB_PROPERTIES != null) return DB_PROPERTIES;
        Properties properties = new Properties();
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(DEFAULT_APP_PROPERTIES_FILE)) {
            if (inputStream == null) {
                System.out.println("Error : Database config file [" + DEFAULT_APP_PROPERTIES_FILE + "] is not found");
                return null;
            }
            properties.load(inputStream);
            DB_PROPERTIES = properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}
