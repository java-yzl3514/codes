package ba.yzl3514.framework.jdbc.core;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class SqlParameterValue extends SqlParameter {

    private final Object value;

    public SqlParameterValue(int sqlType, Object value) {
        super(sqlType);
        this.value = value;
    }

    public SqlParameterValue(int sqlType, int scale, Object value) {
        super(sqlType, scale);
        this.value = value;
    }

    public SqlParameterValue(String name, int sqlType, Object value) {
        super(name, sqlType);
        this.value = value;
    }

    public SqlParameterValue(String name, int sqlType, int scale, Object value) {
        super(name, sqlType, scale);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
