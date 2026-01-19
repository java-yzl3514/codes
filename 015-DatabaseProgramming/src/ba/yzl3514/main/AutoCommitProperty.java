package ba.yzl3514.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class AutoCommitProperty {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yzl3514", "devlab", "S3cR3t")) {

            System.out.println(connection.getAutoCommit()); // By default

            connection.setAutoCommit(false);
            // Perform database transaction activities

            //on success
            connection.commit();

            //on failure
            connection.rollback();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
