// Convert crypto amount

// ---------------------------------------------------------------------
import java.net.*;
import java.io.*;
import javax.swing.*;
import org.json.*;

// ---------------------------------------------------------------------
// Example with CoinGecko API 
public class CryptoConverter {
    public static void main(String[] args) throws Exception {
		// Get the entered data from the text fields
		String cryptoAmountData = cryptoAmount.getText();
		String cryptoNameData = cryptoName.getText();
		String gaiaToken = "GAIA";
		
        // URL with the query parameters
		URL url = new URL("https://api.coingecko.com/api/v3/simple/price?ids=" + cryptoNameData + "&vs_currencies=" + gaiaToken + "&amount=" + cryptoAmountData);
        
		// makes an HTTP GET request to the API endpoint
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
		// parses the response JSON object
		JSONObject jsonObj = new JSONObject(response.toString());
        
		// calculates the converted value
		double result = jsonObj.getJSONObject(cryptoNameData).getDouble(gaiaToken) * Double.parseDouble(cryptoAmountData);
        
		// Show "result" value in "cryptoAmountResult" textfield
		// OR
		// Send GAIAs to Donor address through Solidity smart contract
    }
}

// --------------------------------------------------------------------------
