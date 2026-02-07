package ba.yzl3514.jdbc.core;

import ba.yzl3514.framework.DatasourceUtil;
import ba.yzl3514.framework.JDBCUtil;
import ba.yzl3514.framework.exception.SQLWarningException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class JdbcTemplate {

    private Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);

    private DataSource dataSource;

    private int fetchSize = -1;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T execute(ConnectionAction<T> action) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            return action.executeInConnection(connection);
        } catch (SQLException ex) {
            // release connection
            throw new RuntimeException(ex);
        }
    }

    private <T> T execute(StatementAction<T> action) {
        Objects.requireNonNull(action, "StatementAction must not be null");
        Connection connection = DatasourceUtil.getConnection(dataSource);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            configureStatement(statement);
            T result = action.executeInStatement(statement);
            handleWarnings(statement);
            return result;
        } catch (SQLException e) {
            if (statement != null)
                handleWarnings(statement, e);
            JDBCUtil.closeStatement(statement);
            statement = null;
            DatasourceUtil.closeConnection(connection);
            connection = null;
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeStatement(statement);
            DatasourceUtil.closeConnection(connection);
        }
    }

    public void execute(String sql) {
        Objects.requireNonNull(sql, "SQL must not be null");
        // <check> debugging
        logger.info("Executing SQL statement [{}]", sql);

        class LocalStatementAction implements StatementAction<Object> {
            @Override
            public Object executeInStatement(Statement statement) throws SQLException {
                statement.execute(sql);
                return null;
            }
        }
        execute(new LocalStatementAction());
    }


    public <T> T query(String sql, ResultSetExtractor<T> resultSetExtractor) {
        Objects.requireNonNull(sql, "SQL must not be null");
        Objects.requireNonNull(resultSetExtractor, "ResultSetExtractor must not be null");
        // <check> debugging
        logger.info("Executing SQL statement [{}]", sql);

        class LocalQueryStatementAction implements StatementAction<T> {
            @Override
            public T executeInStatement(Statement statement) throws SQLException {
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(sql);
                    return resultSetExtractor.extract(resultSet);
                } finally {
                    JDBCUtil.closeResultSet(resultSet);
                }
            }
        }
        return execute(new LocalQueryStatementAction());
    }


    public int update(String sql) {
        Objects.requireNonNull(sql, "SQL must not be null");
        // <check> debugging
        logger.info("Executing SQL statement [{}]", sql);
        class LocalUpdateStatementAction implements StatementAction<Integer> {
            @Override
            public Integer executeInStatement(Statement statement) throws SQLException {
                int affectedRows = statement.executeUpdate(sql);
                // <check> debugging
                logger.info("SQL update affected {} rows", affectedRows);
                return affectedRows;
            }
        }
        return execute(new LocalUpdateStatementAction());
    }

    public <T> T execute(PreparedStatementCreator preparedStatementCreator, PreparedStatementAction<T> action) {
        Objects.requireNonNull(preparedStatementCreator, "PreparedStatementCreator must not be null");
        Objects.requireNonNull(action, "PreparedStatementAction must not be null");
        Connection connection = DatasourceUtil.getConnection(dataSource);
        PreparedStatement statement = null;
        try {
            statement = preparedStatementCreator.create(connection);
            configureStatement(statement);
            T result = action.executeInPreparedStatement(statement);
            handleWarnings(statement);
            return result;
        } catch (SQLException ex) {
            if (statement != null)
                handleWarnings(statement, ex);
            preparedStatementCreator = null;
            JDBCUtil.closeStatement(statement);
            statement = null;
            DatasourceUtil.closeConnection(connection);
            connection = null;
            throw new RuntimeException(ex);
        } finally {
            JDBCUtil.closeStatement(statement);
            DatasourceUtil.closeConnection(connection);
        }
    }

    public <T> T execute(String sql, PreparedStatementAction<T> action) {
        Objects.requireNonNull(sql, "SQL must not be null");
        return execute((connection) -> connection.prepareStatement(sql), action);
    }


    public <T> T query(PreparedStatementCreator preparedStatementCreator, PreparedStatementSetter preparedStatementSetter, ResultSetExtractor<T> resultSetExtractor) {
        Objects.requireNonNull(preparedStatementCreator, "PreparedStatementCreator must not be null");
        Objects.requireNonNull(preparedStatementSetter, "PreparedStatementSetter must not be null");
        Objects.requireNonNull(resultSetExtractor, "ResultSetExtractor must not be null");
        return execute(preparedStatementCreator, preparedStatement -> {
            ResultSet resultSet = null;
            try {
                preparedStatementSetter.setValues(preparedStatement);
                resultSet = preparedStatement.executeQuery();
                return resultSetExtractor.extract(resultSet);
            } finally {
                JDBCUtil.closeResultSet(resultSet);
            }
        });
    }

    public <T> T query(String sql, PreparedStatementSetter preparedStatementSetter, ResultSetExtractor<T> resultSetExtractor) {
        Objects.requireNonNull(sql, "SQL must not be null");
        return query((connection) -> connection.prepareStatement(sql),preparedStatementSetter,resultSetExtractor);
    }


    private void configureStatement(Statement statement) throws SQLException {
        if (fetchSize != -1) {
            statement.setFetchSize(fetchSize);
        }
        // max row
    }


    private void handleWarnings(Statement statement, SQLException exception) {
        try {
            handleWarnings(statement);
        } catch (SQLWarningException ex) {
            exception.setNextException(ex.getSQLWarning());
        } catch (SQLException ex) {
            logger.info("Warnings ", ex);
        }
    }

    private void handleWarnings(Statement statement) throws SQLException {
        // <check> debugging
        SQLWarning warnings = statement.getWarnings();
        while (warnings != null) {
            logger.info("SQL Warning : SQL state '{}', error code '{}', message [{}]", warnings.getSQLState(),
                    warnings.getErrorCode(), warnings.getMessage());
            warnings = warnings.getNextWarning();
        }

        handleWarnings(warnings);
    }

    private void handleWarnings(SQLWarning sqlWarning) {
        if (sqlWarning != null)
            throw new SQLWarningException("SQL Warnings are handled", sqlWarning);
    }

}
