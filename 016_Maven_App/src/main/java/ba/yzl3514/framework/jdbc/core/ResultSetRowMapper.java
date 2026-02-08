package ba.yzl3514.framework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
@FunctionalInterface
public interface ResultSetRowMapper<T> {

    T mapRow(ResultSet resultSet,int rowNumber) throws SQLException;
}
