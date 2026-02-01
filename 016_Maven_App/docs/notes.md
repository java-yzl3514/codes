https://repo1.maven.org/maven2/


https://github.com/brettwooldridge/HikariCP?tab=readme-ov-file


```java
public class App {
    public static void main(String[] args) {
        connectionPool();
    }


    private static void jdbcConnection() {
        try (Connection connection = JDBCUtil.getConnection()) {
            System.out.println("Connection is established");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectionPool() {
        try (Connection connection = DBConnectionManager.getDataSource().getConnection()) {
            System.out.println("Connection is established");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### ASCII-ART

https://www.asciiart.eu/text-to-ascii-art


### ANSI CODES

https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797


Inversion of Control- IoC
Dependency Injection- DI

https://start.spring.io/
