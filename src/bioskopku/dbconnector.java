package bioskopku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class dbconnector {

    public static Connection connection;
    public static java.sql.Statement statement;
    public static String username;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskopku", "root", "");
            } catch (ClassNotFoundException ex) {
                System.err.println("MySQL Connector/J driver not found");
            }
        }
        return connection;
    }

}
