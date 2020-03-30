package dataSources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    public Connection getConnectionToMsSQL() throws SQLException {
        return DriverManager
                .getConnection(
                        "jdbc:sqlserver://localhost:1433",
                        "sa",
                        "newPassw0rd");
    }

    public Connection getConnectionToPostgres() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testdb",
                "postgres",
                "password"
        );
    }
}
