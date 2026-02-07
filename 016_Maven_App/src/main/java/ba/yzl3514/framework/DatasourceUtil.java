package ba.yzl3514.framework;

import ba.yzl3514.framework.exception.JdbcConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DatasourceUtil {

    private static Logger logger = LoggerFactory.getLogger(DatasourceUtil.class);


    /**
     *
     * @param dataSource
     * @return
     */
    public static Connection getConnection(DataSource dataSource) {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException ex) {
            throw new JdbcConnectionException("JDBC Connection can not obtain", ex);
        } catch (IllegalStateException ex) {
            throw new JdbcConnectionException("JDBC Connection can not obtain", ex);
        }
    }


    /**
     *
     *
     * @param dataSource
     * @return
     * @throws SQLException
     */
    private static Connection doGetConnection(DataSource dataSource) throws SQLException {
        Objects.requireNonNull(dataSource, "No Datasource specified");
        // Transaction management
        logger.info("Obtaining JDBC connection from Datasource");
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new IllegalStateException("null returned from getConection()");
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
