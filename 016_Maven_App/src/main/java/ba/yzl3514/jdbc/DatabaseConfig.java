package ba.yzl3514.jdbc;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DatabaseConfig {

    public static class Key {
        public static final String URL = "jdbc.url";
        public static final String USERNAME = "jdbc.username";
        public static final String PASSWORD = "jdbc.password";
    }

    public static class Pool {
        public static class Key {
            public static final String MAX_SIZE = "pool.size.max";
            public static final String MIN_IDLE = "pool.idle.min";
            public static final String IDLE_TIMEOUT = "pool.idle.timeout";
            public static final String TIMEOUT = "pool.timeout";
        }
    }

}
