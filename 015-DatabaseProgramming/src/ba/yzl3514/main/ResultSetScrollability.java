package ba.yzl3514.main;

import ba.yzl3514.domain.Person;
import ba.yzl3514.util.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ResultSetScrollability {

    public static void main(String[] args) {
        fetchPersonsScrollableResultSetCase();

    }

    private static void driverResultSetTypeInfo() {
        try (Connection connection = JDBCUtil.getConnection()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            boolean forwardOnly = databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY);
            boolean scrollSensitive = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
            boolean scrollInsensitive = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);

            System.out.printf("Forward Only : %b%n", forwardOnly);
            System.out.printf("Scroll-Sensitive : %b%n", scrollSensitive);
            System.out.printf("Scroll-InSensitive : %b%n", scrollInsensitive);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void driverResultSetConcurrencyInfo() {
        try (Connection connection = JDBCUtil.getConnection()) {

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            boolean forwardOnlyReadOnly = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            boolean forwardOnlyUpdatable = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            boolean scrollSensitiveReadOnly = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            boolean scrollSensitiveUpdatable = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            boolean scrollInsensitiveReadOnly = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            boolean scrollInsensitiveUpdatable = databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            System.out.printf("Forward Only & Read Only : %b%n", forwardOnlyReadOnly);
            System.out.printf("Forward Only & Updatable : %b%n", forwardOnlyUpdatable);

            System.out.printf("Scroll-Sensitive & Read Only : %b%n", scrollSensitiveReadOnly);
            System.out.printf("Scroll-Sensitive & Updatable : %b%n", scrollSensitiveUpdatable);

            System.out.printf("Scroll-InSensitive & Read Only : %b%n", scrollInsensitiveReadOnly);
            System.out.printf("Scroll-InSensitive & Updatable : %b%n", scrollInsensitiveUpdatable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void fetchPersonsScrollableResultSetCase() {
        String sql = "SELECT person_id, first_name, last_name, email, password FROM person";

        try (Connection connection = JDBCUtil.getConnection(); Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Person> personList = new ArrayList<>();
            System.out.println("Is Before First? " + resultSet.isBeforeFirst());
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));
                personList.add(person);
            }
            personList.forEach(System.out::println);
            personList.clear();
            System.out.println("====================================");

            System.out.println("Is After Last? " + resultSet.isAfterLast());
            while (resultSet.previous()) {
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));
                personList.add(person);
            }
            personList.forEach(System.out::println);

            System.out.println("======= First: ");
            resultSet.first();
            Person first = new Person();
            first.setId(resultSet.getInt("person_id"));
            first.setFirstName(resultSet.getString("first_name"));
            first.setLastName(resultSet.getString("last_name"));
            first.setEmail(resultSet.getString("email"));
            first.setPassword(resultSet.getString("password"));
            System.out.println(first);
            System.out.println("Is First? " + resultSet.isFirst());


            System.out.println("======= Last: ");
            resultSet.last();
            Person last = new Person();
            last.setId(resultSet.getInt("person_id"));
            last.setFirstName(resultSet.getString("first_name"));
            last.setLastName(resultSet.getString("last_name"));
            last.setEmail(resultSet.getString("email"));
            last.setPassword(resultSet.getString("password"));
            System.out.println(last);
            System.out.println("Is Last? " + resultSet.isLast());

            System.out.println("======= Absolute: ");
            resultSet.absolute(5);
            Person absolute = new Person();
            absolute.setId(resultSet.getInt("person_id"));
            absolute.setFirstName(resultSet.getString("first_name"));
            absolute.setLastName(resultSet.getString("last_name"));
            absolute.setEmail(resultSet.getString("email"));
            absolute.setPassword(resultSet.getString("password"));
            System.out.println(absolute);

            System.out.println("======= Relative: ");
            resultSet.relative(-1);
            Person relative = new Person();
            relative.setId(resultSet.getInt("person_id"));
            relative.setFirstName(resultSet.getString("first_name"));
            relative.setLastName(resultSet.getString("last_name"));
            relative.setEmail(resultSet.getString("email"));
            relative.setPassword(resultSet.getString("password"));
            System.out.println(relative);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
