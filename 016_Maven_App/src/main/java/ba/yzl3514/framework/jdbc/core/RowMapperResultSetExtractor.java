package ba.yzl3514.framework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RowMapperResultSetExtractor<T> implements ResultSetExtractor<List<T>> {

    private final ResultSetRowMapper<T> rowMapper;

    public RowMapperResultSetExtractor(ResultSetRowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public List<T> extract(ResultSet resultSet) throws SQLException {
        List<T> resultList = new ArrayList<>();
        int rowNumber = 0;
        while (resultSet.next()) {
            resultList.add(rowMapper.mapRow(resultSet, rowNumber++));
        }
        return resultList;
    }
}
