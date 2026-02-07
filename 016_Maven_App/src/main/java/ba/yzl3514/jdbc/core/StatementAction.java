package ba.yzl3514.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface StatementAction<T> {


    T executeInStatement(Statement statement) throws SQLException;
}
