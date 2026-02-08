package ba.yzl3514.framework.jdbc.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
@FunctionalInterface
public interface PreparedStatementCreator {

    PreparedStatement create(Connection connection) throws SQLException;
}
