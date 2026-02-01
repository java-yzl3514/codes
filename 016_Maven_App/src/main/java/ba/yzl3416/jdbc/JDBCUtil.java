package ba.yzl3416.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class JDBCUtil {


    public static Connection getConnection() throws SQLException {
        try {
            Properties properties = DatabaseConfig.getProperties();
            final String url = properties.getProperty(DatabaseConfig.Key.URL);
            final String username = properties.getProperty(DatabaseConfig.Key.USERNAME);
            final String password = properties.getProperty(DatabaseConfig.Key.PASSWORD);
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection connection) {
        try {
            if (connection != null) {
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
