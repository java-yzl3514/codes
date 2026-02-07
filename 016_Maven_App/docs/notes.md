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


```java
public Invoice saveOld(Invoice entity) {
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            statement.setLong(1, entity.getVendorId());
            statement.setString(2, entity.getInvoiceNumber());
            statement.setObject(3, entity.getInvoiceDate(), Types.DATE);
            statement.setBigDecimal(4, entity.getInvoiceTotal());
            statement.setBigDecimal(5, entity.getPaymentTotal());
            statement.setBigDecimal(6, entity.getCreditTotal());
            statement.setLong(7, entity.getTermsId());
            statement.setObject(8, entity.getInvoiceDueDate());
            statement.setObject(9, entity.getPaymentDate());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert is unsuccessful");
            }
            JDBCUtil.commit(connection);

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
                    entity.setId(generatedId);
                }
            } catch (SQLException e) {
                throw new SQLException("The record id could not be handled!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

```


