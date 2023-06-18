// Read Beneficiary / Campaign Data

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// --------------------------------------------------------------------------
// Call method
ResultSet resultSet = MySQLHelper.readDataFromMySQL("BeneficiaryData");

while (resultSet.next()) {
    String column1 = resultSet.getString("beneficiaryName");
    String column2 = resultSet.getString("beneficiaryStory");
    String column3 = resultSet.getString("beneficiaryPurpose");
    String column4 = resultSet.getString("beneficiaryMision");
    String column5 = resultSet.getString("beneficiaryActivities");
    String column6 = resultSet.getString("beneficiaryIssues");
    String column7 = resultSet.getString("beneficiaryVideo");
    String column8 = resultSet.getString("beneficiaryImpact");
    String column9 = resultSet.getString("beneficiaryImage");
    String column10 = resultSet.getString("beneficiaryCountry");
    String column11 = resultSet.getString("beneficiaryCity");
    String column12 = resultSet.getString("beneficiaryAddress");
    
    // Show data
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
        String query = "SELECT * FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(query);

        // Close the statement and database connection
        statement.close();
        connection.close();

        // Return the result set containing the fetched rows
        return resultSet;
    }
}

// --------------------------------------------------------------------------
