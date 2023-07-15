// Display Parcel Data

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// --------------------------------------------------------------------------
// Get parcelID
String parcelID = parcelIDSelected.getValue();

String table = "ParcelData";
String column1Value = parcelID;
	
	try {
		MySQLHelper.displayData(table, column1Value);
		System.out.println("Data Found");
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			}
    
//------------------------------------------------------------------------------
public class MySQLHelper {
    private static final String URL = "jdbc:mysql://hostname:3306/database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void displayData(String tableName, String column1Value) throws SQLException {
        // Establish a connection to the MySQL database
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// Create a statement object to execute SQL query
        Statement statement = connection.createStatement();

        // Execute a query to retrieve data from a table
        String query = "SELECT parcelId, parcelLatitude, parcelLongitude, parcelValue FROM " + tableName + " WHERE " + parcelId + "=" + column1Value;
        ResultSet resultSet = statement.executeQuery(query);

        // Close the statement and database connection
        statement.close();
        connection.close();

		// Display parcel data (parcelId, parcelLatitude, parcelLongitude, parcelValue) in textfield
		TextView displayParcelData = findViewById(R.id.displayParcelData);
		displayParcelData.setText(resultSet);
	  }
	}
		
	// close the database connection
	connection.close();

//------------------------------------------------------------------------------
