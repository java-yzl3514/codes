package ba.yzl3514.main;

import ba.yzl3514.util.JDBCUtil;

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
public class PersonCRUDCases {


    public static void main(String[] args) {
        deletePersonCase();
    }


    public static void insertPersonCase(){
        try (Connection connection = JDBCUtil.getConnection()) {
            connection.setAutoCommit(false);
            if (insertPerson(connection, "Jane", "Doe")) {
                System.out.println("1 person is inserted");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePersonCase(){

        try (Connection connection = JDBCUtil.getConnection()) {
            connection.setAutoCommit(false);

            if (updatePerson(connection, 1,"Adam", "Doe")) {
                System.out.println("1 person is updated");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePersonCase(){
        try (Connection connection = JDBCUtil.getConnection()) {
            connection.setAutoCommit(false);
            if (deletePerson(connection, 1)) {
                System.out.println("1 person is deleted");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean insertPerson(Connection connection, String firstName, String lastName) throws SQLException {
        String sql = "INSERT INTO person (first_name, last_name) VALUES ('" + firstName + "', '" + lastName + "')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(sql) > 0;
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }

    public static boolean updatePerson(Connection connection, int id, String firstName, String lastName) throws SQLException{
            String sql  = "UPDATE person SET first_name = '" + firstName + "', last_name = '" + lastName + "' WHERE person.person_id = " + id;

            Statement statement = null;
            try{
                statement = connection.createStatement();
                return statement.executeUpdate(sql) > 0;
            }finally {
                JDBCUtil.closeStatement(statement);
            }
    }


    public static boolean deletePerson(Connection connection, int id) throws SQLException{
        String sql = "DELETE FROM person WHERE person_id = " + id;

        Statement statement = null;
        try{
            statement = connection.createStatement();
            return statement.executeUpdate(sql) > 0;
        }finally {
            JDBCUtil.closeStatement(statement);
        }
    }
}
