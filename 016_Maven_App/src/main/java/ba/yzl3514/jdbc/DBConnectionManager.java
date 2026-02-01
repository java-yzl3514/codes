package ba.yzl3514.jdbc;

import ba.yzl3514.framework.ConfigLoader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DBConnectionManager {

    private static Logger logger = LoggerFactory.getLogger(DBConnectionManager.class);
    private static DataSource dataSource;

    public static void start() {
        if (dataSource != null) {
            return;
        }

        logger.info("[Framework] Database configuration is started... ");
        Properties properties = ConfigLoader.loadProperties();
        final String url = properties.getProperty(DatabaseConfig.Key.URL);
        final String username = properties.getProperty(DatabaseConfig.Key.USERNAME);
        final String password = properties.getProperty(DatabaseConfig.Key.PASSWORD);

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty(DatabaseConfig.Pool.Key.MAX_SIZE)));
        hikariConfig.setMinimumIdle(Integer.parseInt(properties.getProperty(DatabaseConfig.Pool.Key.MIN_IDLE)));
        hikariConfig.setIdleTimeout(Integer.parseInt(properties.getProperty(DatabaseConfig.Pool.Key.IDLE_TIMEOUT)));
        hikariConfig.setConnectionTimeout(Integer.parseInt(properties.getProperty(DatabaseConfig.Pool.Key.TIMEOUT)));

        dataSource = new HikariDataSource(hikariConfig);
        logger.info("[Framework] Database configuration is success.");
    }


    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new RuntimeException("[ERROR] Database is not configurated");
        }
        return dataSource.getConnection();
    }

    public static void shutdown(){
        if(dataSource != null && !((HikariDataSource)dataSource).isClosed()){
            ((HikariDataSource)dataSource).close();
            logger.info("[Framework] Database connection pool is closed");
        }

    }


}
