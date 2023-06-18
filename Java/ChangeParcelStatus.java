// Change Parcel Status

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// ---------------------------------------------------------------------
// Get parcelID
String parcelID = parcelIDSelected.getValue();
// Get status type (free/reserved/sold) by parameters
String statusType = statusType.getValue();

String table = "ParcelData";
String column1Value = parcelID;
String column2Value = statusType;
	
	try {
		MySQLHelper.changeData(table, column1Value, column2Value);
		System.out.println("Parcel Status Changed");
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			}
    
//------------------------------------------------------------------------------
public class MySQLHelper {
    private static final String URL = "jdbc:mysql://hostname:3306/database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void changeData(String tableName, String column1Value, String column2Value) throws SQLException {
        // Establish a connection to the MySQL database
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// update the database with the new data
		PreparedStatement ps = connection.prepareStatement("UPDATE " + tableName + " SET " + parcelStatus + "=" + column2Value + " WHERE " + parcelId + "=" + column1Value);
		ps.setString(1, column2Value);					
		ps.executeUpdate();
	  }
	}
		
	// close the database connection
	connection.close();

//------------------------------------------------------------------------------
