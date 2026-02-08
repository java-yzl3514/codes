package ba.yzl3514.framework.jdbc.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PreparedStatementArgumentSetter implements PreparedStatementSetter {

    private Object[] args;

    public PreparedStatementArgumentSetter(Object[] args) {
        this.args = args;
    }

    @Override
    public void setValues(PreparedStatement preparedStatement) throws SQLException {
        if (args == null) return;
        for (int i = 0; i < args.length; i++) {
            StatementParameterUtils.setParameterValue(preparedStatement, i + 1, Types.INTEGER, args[i]);
        }
    }
}
