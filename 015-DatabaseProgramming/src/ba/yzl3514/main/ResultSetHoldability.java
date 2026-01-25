package ba.yzl3514.main;

import ba.yzl3514.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ResultSetHoldability {

    public static void main(String[] args) {
        // ResultSet.CLOSE_CURSORS_AT_COMMIT // Default olarak Postgresql commit işlemi cursor'ı öldürür.

        String sql = "SELECT person_id, first_name, last_name, email, password FROM person";
        try (Connection connection = JDBCUtil.getConnection(); Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            // connection.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
            ResultSet resultSet = statement.executeQuery(sql);
            //statement.setFetchSize(1000);

            resultSet.moveToInsertRow();
            resultSet.updateString("first_name", "John");
            resultSet.updateString("last_name", "Brown");
            resultSet.updateString("email", "john.brown@email.com");
            resultSet.updateString("password", "secret11");
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

            // HOLD_CURSORS_OVER_COMMIT ile konfigürasyon yapıldıysa resultSet.close() işleminin mutlaka yapıldığından emin olunuz.
            JDBCUtil.commit(connection); // ResultSet closes

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
