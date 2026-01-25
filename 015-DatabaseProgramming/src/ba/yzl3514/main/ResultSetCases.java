package ba.yzl3514.main;

import ba.yzl3514.domain.Person;
import ba.yzl3514.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ResultSetCases {

    public static void main(String[] args) {
        fetchPersonsCase();

    }


    private static void fetchPersonsCase() {
        String sql = "SELECT person_id, first_name, last_name, email, password FROM person";

        try (Connection connection = JDBCUtil.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Person> personList = new ArrayList<>();
            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));
                personList.add(person);
            }
            personList.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
