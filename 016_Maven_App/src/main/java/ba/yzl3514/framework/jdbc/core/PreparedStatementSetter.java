package ba.yzl3514.framework.jdbc.core;

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
public interface PreparedStatementSetter {


    void setValues(PreparedStatement preparedStatement) throws SQLException;
}
