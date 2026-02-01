package ba.yzl3416.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DatabaseManager {

    private static DataSource dataSource;

    static{
        Properties properties = DatabaseConfig.getProperties();
        final String url = properties.getProperty(DatabaseConfig.Key.URL);
        final String username = properties.getProperty(DatabaseConfig.Key.USERNAME);
        final String password = properties.getProperty(DatabaseConfig.Key.PASSWORD);

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setIdleTimeout(300_000);
        hikariConfig.setConnectionTimeout(20_000);

        dataSource = new HikariDataSource(hikariConfig);
    }


    public static DataSource getDataSource(){
        return dataSource;
    }

}
