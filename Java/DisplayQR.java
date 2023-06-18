// Display Wallet Address QR code

// ---------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// --------------------------------------------------------------------------
// Get pangeanID
String pangeanID = pangeanIDSelected.getValue();

String table = "PangeanAccount";
String column1Value = pangeanID;
	
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
        String query = "SELECT pangeanWalletAddress FROM " + tableName + " WHERE " + pangeanId + "=" + column1Value;
        ResultSet resultSet = statement.executeQuery(query);

        // Close the statement and database connection
        statement.close();
        connection.close();

		// Generate the QR code image using the MultiFormatWriter
		// Set the size, encoding, and error correction level of the QR code using the BitMatrix
		BitMatrix qrCode = new MultiFormatWriter().encode(resultSet, BarcodeFormat.QR_CODE, 512, 512);

		// Convert the BitMatrix to a Bitmap image
		Bitmap qrCodeBitmap = Bitmap.createBitmap(qrCode.getWidth(), qrCode.getHeight(), Bitmap.Config.RGB_565);
		MatrixToImageWriter.writeToBitmap(qrCode, qrCodeBitmap);

		// Display the QR code in qrCodeImageView imagefield
		ImageView qrCodeImageView = findViewById(R.id.qrCodeImageView);
		qrCodeImageView.setImageBitmap(qrCodeBitmap);
	  }
	}
		
	// close the database connection
	connection.close();

//------------------------------------------------------------------------------
