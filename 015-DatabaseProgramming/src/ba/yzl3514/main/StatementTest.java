package ba.yzl3514.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StatementTest {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yzl3514", "devlab", "S3cR3t");
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false);

            String sql = "CREATE TABLE person( " +
                    "person_id SERIAL PRIMARY KEY, " +
                    "first_name VARCHAR(100) NOT NULL, " +
                    "last_name VARCHAR(100) NOT NULL" +
                    ")";

            statement.execute(sql);

            connection.commit();

            System.out.println("Person Table is created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
