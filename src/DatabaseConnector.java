import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Catherine on 11/15/2015.
 */
public class DatabaseConnector {
    public DatabaseConnector() { }

    private Connection createConnection(String username, char[] password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            // TODO handle exception
        }

        try {
            Properties connection = new Properties();
            connection.put("user", username);
            connection.put("password", password);
            conn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/", connection);
        }
        catch (SQLException sqlex) {
            System.out.println("SQLException: " + sqlex.getMessage());
            System.out.println("SQLState: " + sqlex.getSQLState());
            System.out.println("VendorError: " + sqlex.getErrorCode());
        }

        return conn;
    }

    private Connection conn;

}
