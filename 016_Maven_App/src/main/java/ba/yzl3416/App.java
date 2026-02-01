package ba.yzl3416;

import ba.yzl3416.jdbc.DatabaseManager;
import ba.yzl3416.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        connectionPool();
    }


    private static void jdbcConnection() {
        try (Connection connection = JDBCUtil.getConnection()) {
            System.out.println("Connection is established");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectionPool() {
        try (Connection connection = DatabaseManager.getDataSource().getConnection()) {
            System.out.println("Connection is established");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
