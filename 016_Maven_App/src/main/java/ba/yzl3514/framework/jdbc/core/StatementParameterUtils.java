package ba.yzl3514.framework.jdbc.core;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Calendar;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StatementParameterUtils {




    public static void setParameterValue(PreparedStatement preparedStatement, int parameterIndex, int sqlType, Object inputValue) throws SQLException {

        if (sqlType == Types.VARCHAR || sqlType == Types.LONGVARCHAR) {
            preparedStatement.setString(parameterIndex, inputValue.toString());
        } else if (sqlType == Types.NVARCHAR || sqlType == Types.LONGNVARCHAR) {
            preparedStatement.setNString(parameterIndex, inputValue.toString());
        } else if (sqlType == Types.CLOB || sqlType == Types.NCLOB) {
            String strValue = inputValue.toString();
            final int length = strValue.length();
            // JDBC 4.0
            if (length > 4000) {
                if (sqlType == Types.NCLOB) {
                    preparedStatement.setNClob(parameterIndex, new StringReader(strValue), length);
                } else {
                    preparedStatement.setClob(parameterIndex, new StringReader(strValue), length);
                }
            } else {
                if (sqlType == Types.NCLOB) {
                    preparedStatement.setNString(parameterIndex, strValue);
                } else {
                    preparedStatement.setString(parameterIndex, strValue);
                }
            }
        } else if (sqlType == Types.DECIMAL || sqlType == Types.NUMERIC) {
            if (inputValue instanceof BigDecimal bigDecimal) {
                preparedStatement.setBigDecimal(parameterIndex, bigDecimal);
            } else {
                preparedStatement.setObject(parameterIndex, inputValue, sqlType);
            }
        } else if (sqlType == Types.BOOLEAN) {
            if (inputValue instanceof Boolean bflag) {
                preparedStatement.setBoolean(parameterIndex, bflag);
            } else {
                preparedStatement.setObject(parameterIndex, inputValue, Types.BOOLEAN);
            }
        } else if (sqlType == Types.DATE) {
            if (inputValue instanceof java.util.Date udate) {
                if (inputValue instanceof java.sql.Date sdate) {
                    preparedStatement.setDate(parameterIndex, sdate);
                } else {
                    preparedStatement.setDate(parameterIndex, new java.sql.Date(udate.getTime()));
                }
            } else if (inputValue instanceof Calendar calendar) {
                preparedStatement.setDate(parameterIndex, new java.sql.Date(calendar.getTime().getTime()), calendar);
            } else {
                preparedStatement.setObject(parameterIndex, Types.DATE);
            }
        } else if (sqlType == Types.TIME) {
            if (inputValue instanceof java.util.Date udate) {
                if (inputValue instanceof java.sql.Time stime) {
                    preparedStatement.setTime(parameterIndex, stime);
                } else {
                    preparedStatement.setTime(parameterIndex, new java.sql.Time(udate.getTime()));
                }
            } else if (inputValue instanceof Calendar calendar) {
                preparedStatement.setTime(parameterIndex, new java.sql.Time(calendar.getTime().getTime()), calendar);
            } else {
                preparedStatement.setObject(parameterIndex, Types.TIME);
            }

        } else if (sqlType == Types.TIMESTAMP) {
            if (inputValue instanceof java.util.Date udate) {
                if (inputValue instanceof java.sql.Timestamp timestamp) {
                    preparedStatement.setTimestamp(parameterIndex, timestamp);
                } else {
                    preparedStatement.setTimestamp(parameterIndex, new java.sql.Timestamp(udate.getTime()));
                }
            } else if (inputValue instanceof Calendar calendar) {
                preparedStatement.setTimestamp(parameterIndex, new java.sql.Timestamp(calendar.getTime().getTime()), calendar);
            } else {
                preparedStatement.setObject(parameterIndex, Types.TIMESTAMP);
            }
        } else {
            try {
                preparedStatement.setObject(parameterIndex, inputValue, sqlType);
            } catch (SQLFeatureNotSupportedException ex) {
                preparedStatement.setObject(parameterIndex, inputValue);
            }
        }
    }
}
