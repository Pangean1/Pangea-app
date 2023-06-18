// Session Manager

//------------------------------------------------------------------------------
// handleApiRequest check if the session has expired
public void handleApiRequest(Request request) {
  // sessionToken variable is obtained from the request headers or shared preferences
  String sessionToken = request.getHeaders().get("sessionToken");
  if (sessionToken == null) {
    SharedPreferences sharedPreferences = context.getSharedPreferences("app_name", Context.MODE_PRIVATE);
    sessionToken = sharedPreferences.getString("sessionToken", null);
  }

  // If the session token is not found, the user is not authenticated
  if (sessionToken == null) {
    // Redirect user
    redirect("Sign In option");
    return;
  }

  // getSessionData retrieves the session data from the server using sessiontoken
  Session session = getSessionData(sessionToken);

  // If the session has expired, require the user to log in again
  // Call method
  if (isSessionExpired(session)) {
    // Delete the sessiontoken and data from shared preferences
    SharedPreferences sharedPreferences = context.getSharedPreferences("app_name", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.remove("sessionToken");
    editor.apply();
    // deleteSessionData deletes the session data from the server 
    deleteSessionData(sessionToken);
    // Redirect user
    redirect("Sign In option");
    return;
  }
  // If the session is still active, continue handling the API request
  // ...
}

//------------------------------------------------------------------------------
// isSessionExpired takes a Session object and returns true if the session has expired 
public boolean isSessionExpired(Session session) {
  // Check if the session has an expiration time set
  if (session.getExpirationTime() != null) {
    // Get the current time
    Instant currentTime = Instant.now();
    // Compare the current time to the expiration time
    if (currentTime.isAfter(session.getExpirationTime())) {
      // Session has expired
      return true;
    }
  }
  // If the session doesn't have an expiration time or hasn't expired yet, return false
  return false;
}

//------------------------------------------------------------------------------
