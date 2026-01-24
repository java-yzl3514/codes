package ba.yzl3514.main;

import ba.yzl3514.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PreparedStatementCases {

    public static void main(String[] args) {
        insertPersonCase();
    }


    public static void insertPersonCase() {
        try (Connection connection = JDBCUtil.getConnection()) {
            if (insertPerson(connection, "Adam", "Smith", "adam.smith@email.com", "secret3")) {
                System.out.println("1 person is inserted");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static boolean insertPerson(Connection connection, String firstName, String lastName, String email, String password) throws SQLException {
        String sql = "INSERT INTO person (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            // variable binding
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, password);
            return statement.executeUpdate() > 0;
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }

}
