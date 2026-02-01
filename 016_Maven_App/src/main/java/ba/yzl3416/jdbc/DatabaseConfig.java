package ba.yzl3416.jdbc;

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
public class DatabaseConfig {

    private static final String DEFAULT_APP_PROPERTIES_FILE = "db.properties";
    private static Properties DB_PROPERTIES;

    public static Properties getProperties() {
        if (DB_PROPERTIES != null) return DB_PROPERTIES;
        Properties properties = new Properties();
        try (InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream(DEFAULT_APP_PROPERTIES_FILE)) {
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


    public static class Key {
        public static final String URL = "db.url";
        public static final String USERNAME = "db.username";
        public static final String PASSWORD = "db.password";
    }


}
