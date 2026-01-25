package ba.yzl3514.main;

import ba.yzl3514.domain.Person;
import ba.yzl3514.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PreparedStatementCases {

    public static void main(String[] args) {
        insertPersonListCase();
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

    public static void insertPersonListCase() {
        try (Connection connection = JDBCUtil.getConnection()) {
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("Adam", "Smith", "adam.smith@email.com", "secret3"));
            personList.add(new Person("Jeniffer", "Pink", "jeniffer.pink@email.com", "secret13"));
            if(insertPersons(connection, personList)){
                System.out.println("People is inserted");
            }
            connection.commit();
            System.out.println("Inserts are committed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updatePersonCase() {
        try (Connection connection = JDBCUtil.getConnection()) {

            if (updatePerson(connection, 5, "Tom", "Stone", "tom.stone@email.com", "secret5")) {
                System.out.println("1 person is updated");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deletePersonCase() {
        try (Connection connection = JDBCUtil.getConnection()) {
            if (deletePerson(connection, 5)) {
                System.out.println("1 person is deleted");
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

    private static boolean insertPersons(Connection connection, List<Person> personList) throws SQLException {
        String sql = "INSERT INTO person (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            int insertCount = 0;
            for (Person person : personList) {
                statement.setString(1, person.getFirstName());
                statement.setString(2, person.getLastName());
                statement.setString(3, person.getEmail());
                statement.setString(4, person.getPassword());
                insertCount += statement.executeUpdate();
                statement.clearParameters();
            }
            return personList.size() == insertCount;
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }


    private static boolean updatePerson(Connection connection, int id, String firstName, String lastName, String email, String password) throws SQLException {
        String sql = "UPDATE person SET first_name = ?, last_name = ?, email = ?, password = ? WHERE person_id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, id);
            return statement.executeUpdate() > 0;
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }

    private static boolean deletePerson(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM person WHERE person_id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }

}
