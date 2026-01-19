package ba.yzl3514.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DatabaseMetaDataTest {

    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yzl3514", "devlab", "S3cR3t")) {
            DatabaseMetaData metaData = connection.getMetaData();
            String databaseName = metaData.getDatabaseProductName();
            String dbVersion = metaData.getDatabaseProductVersion();
            System.out.println("Database Name : " + databaseName);
            System.out.println("Database Version : " + dbVersion);
            System.out.println("Database URL : " + metaData.getURL());

            System.out.printf("%nAbout the JDBC Driver... %n");
            System.out.println("Driver Name : " + metaData.getDriverName());
            System.out.println("Driver Version : " + metaData.getDriverVersion());

            System.out.println("Supports Entry Level ANSI-92 SQL : " + metaData.supportsANSI92EntryLevelSQL() );
            System.out.println("Supports Full ANSI-92 SQL : " + metaData.supportsANSI92FullSQL() );
            System.out.println("Supports Batch Updates : " + metaData.supportsBatchUpdates() );

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
