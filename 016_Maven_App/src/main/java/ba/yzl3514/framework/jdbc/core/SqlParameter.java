package ba.yzl3514.framework.jdbc.core;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class SqlParameter {

    private String name;

    private final int type;

    private Integer scale;


    public SqlParameter(int sqlType) {
        type = sqlType;
    }

    public SqlParameter(int sqlType, int scale) {
        type = sqlType;
        this.scale = scale;
    }

    public SqlParameter(String name, int sqlType) {
        this.name = name;
        type = sqlType;
    }

    public SqlParameter(String name, int sqlType, int scale) {
        this.name = name;
        type = sqlType;
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public Integer getScale() {
        return scale;
    }
}
