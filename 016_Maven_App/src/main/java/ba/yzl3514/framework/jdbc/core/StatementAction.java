package ba.yzl3514.framework.jdbc.core;

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
