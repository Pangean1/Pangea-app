// Save Session Status

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// ---------------------------------------------------------------------
// handleApiRequestsession() check session state
public void handleApiRequestSession(Request request) {
  // sessionToken variable is obtained from the request headers or shared preferences
  String sessionToken = request.getHeaders().get("sessionToken");
  if (sessionToken == null) {
    SharedPreferences sharedPreferences = context.getSharedPreferences("app_name", Context.MODE_PRIVATE);
    sessionToken = sharedPreferences.getString("sessionToken", null);
  }

  // If session token is found user data is saved for logs
  if (sessionToken) {
	// getSessionData retrieves the session data from the server using sessiontoken
	Session session = getSessionData(sessionToken);
	Instant currentTime = Instant.now();

	String table = "UserLog";
	String column1Value = currentTime;
	String column2Value = session.sessionTokenId;
	String column3Value = session.sessionTokenExpiration;	
	
	try {
		MySQLHelper.saveData(table, column1Value, column2Value, column3Value);
		System.out.println("Data saved");
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			}
    }
	return;
}

//------------------------------------------------------------------------------
public class MySQLHelper {
    private static final String URL = "jdbc:mysql://hostname:3306/database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void saveData(String tableName, String column1Value, String column2Value, String column3Value) throws SQLException {
        // Establish a connection to the MySQL database
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Create a prepared statement object to execute SQL queries with parameters
        String query = "INSERT INTO " + tableName + " (sessionTokenDate, sessionTokenId, sessionTokenExpiration) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Set the parameter values for the prepared statement
        preparedStatement.setString(1, column1Value);
        preparedStatement.setString(2, column2Value);
        preparedStatement.setString(3, column3Value);

        // Execute the prepared statement to insert the data into the table
        preparedStatement.executeUpdate();

        // Close the prepared statement and database connection
        preparedStatement.close();
        connection.close();
    }
}
