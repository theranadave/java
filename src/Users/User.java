package Users;

public class User implements Person{
    protected String username;
    protected String password;
    protected String auth_type;

    // Constructor to initialize username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.auth_type = "";
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

    // Getter for password
    public String getType() {
        return auth_type;
    }
    

    // Overridable method to display user information
    public String getUserDetails() {
        return "Username: " + username;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public void setName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    @Override
    public String getDOB() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDOB'");
    }

    @Override
    public void setDOB(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDOB'");
    }
}

