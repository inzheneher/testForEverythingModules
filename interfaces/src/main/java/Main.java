import dataSources.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();

        switch (args[0]) {
            case "1":
                try (Connection connection = dataSource.getConnectionToMsSQL()) {
                    PreparedStatement select =
                            connection.prepareStatement("select * from home_db.dbo.client");
                    ResultSet resultSet = select.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("last_name"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try (Connection connection = dataSource.getConnectionToPostgres()) {
                    PreparedStatement select =
                            connection.prepareStatement("select * from testdb.testschema.client");
                    ResultSet resultSet = select.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("last_name"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
