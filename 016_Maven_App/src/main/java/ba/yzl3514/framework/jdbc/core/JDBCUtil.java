package ba.yzl3514.framework.jdbc.core;

import java.sql.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class JDBCUtil {

    static final int UNKNOWN_TYPE = Integer.MIN_VALUE;

    public static void commit(Connection connection) {
        try {
            if (connection != null) {
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
