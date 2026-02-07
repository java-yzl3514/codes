package ba.yzl3514.jdbc.core;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
@FunctionalInterface
public interface ConnectionAction<T> {


    T executeInConnection(Connection connection) throws SQLException;
}
