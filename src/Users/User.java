package Users;

public class User {
    
    protected String username;
    protected String password;

    // Constructor to initialize username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Overridable method to display user information
    public String getUserDetails() {
        return "Username: " + username;
    }
}

