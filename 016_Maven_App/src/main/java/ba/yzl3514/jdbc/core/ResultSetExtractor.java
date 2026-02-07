package ba.yzl3514.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface ResultSetExtractor<T> {

    T extract(ResultSet resultSet) throws SQLException;
}
