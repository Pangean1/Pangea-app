// Display Crypto List

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// --------------------------------------------------------------------------
// Call method
ResultSet resultSet = MySQLHelper.readDataFromMySQL("CryptoList");

while (resultSet.next()) {
    String column1 = resultSet.getString("cryptoName");
    String column2 = resultSet.getString("cryptoIcon");
    
    // Display data in "select crypto" combobox
}

resultSet.close();

// --------------------------------------------------------------------------
public class MySQLHelper {
    private static final String URL = "jdbc:mysql://hostname:3306/database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static ResultSet readDataFromMySQL(String tableName) throws SQLException {
        // Establish a connection to the MySQL database
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Create a statement object to execute SQL queries
        Statement statement = connection.createStatement();

        // Execute a query to retrieve data from a table
        String query = "SELECT cryptoName, cryptoIcon FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(query);

        // Close the statement and database connection
        statement.close();
        connection.close();

        // Return the result set containing the fetched rows
        return resultSet;
    }
}

// --------------------------------------------------------------------------
