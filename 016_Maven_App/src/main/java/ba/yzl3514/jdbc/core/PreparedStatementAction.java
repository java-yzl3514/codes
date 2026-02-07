package ba.yzl3514.jdbc.core;

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
public interface PreparedStatementAction<T> {

    T executeInPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
}
