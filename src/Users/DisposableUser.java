package Users;

import java.security.SecureRandom; //better way to create temp values 
import java.util.Base64;

public class DisposableUser extends User {

    // Secure random instance for generating random strings
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int DEFAULT_LENGTH = 16;

    public static void main(String[] args) {
        // Create a new User
        User regularUser = new User("regularUser", "regularPass");
        System.out.println("Regular User Details: " + regularUser.getUserDetails());

        // Create a DisposableUser
        DisposableUser tempUser = new DisposableUser("oldUser", "oldPassword");

        // Generate new credentials for DisposableUser
        String newUsername = tempUser.getNewUserName();
        String newPassword = tempUser.getNewPassword();

        System.out.println("Temporary Username: " + newUsername);
        System.out.println("Temporary Password: " + newPassword);
        System.out.println("Temp User Details: " + tempUser.getUserDetails());

        newUsername = tempUser.getNewUserName("dave");
        newPassword = tempUser.getNewPassword(8);

        System.out.println("Temporary Username: " + newUsername);
        System.out.println("Temporary Password: " + newPassword);
        System.out.println("Temp User Details: " + tempUser.getUserDetails());

    }
    
    public DisposableUser(String username, String password) {
        super(username, password);
        this.auth_type = "disposable";
    }

    public DisposableUser() {
        super();
        this.username = getNewUserName();
        this.password = getNewPassword();
        this.auth_type = "disposable";
    }

    // Generate a new temporary username (e.g., username + random number)
    public String getNewUserName() {
        // Generate random username
        String tempUsername = "temp_" + RANDOM.nextInt(10000);
        // Update the username in the parent class (User)
        setUsername(tempUsername); 
        return tempUsername;
    }

    // Generate a new temporary username (e.g., username + random number)
    public String getNewUserName(String s) {
        // Generate random username
        String hash = Integer.toHexString(s.hashCode());
        String tempUsername = s + "_" + hash; 
        // Update the username in the parent class (User)
        setUsername(tempUsername); 
        return tempUsername;
    }

    // Generate a new temporary password
    public String getNewPassword() {
        // Create a random password with 10 characters
        String tempPassword = generateRandomPassword(DEFAULT_LENGTH); 
        // Update the password in the parent class (User)
        setPassword(tempPassword); 
        return tempPassword;
    }

    // Generate a new temporary password
    public String getNewPassword(int n) {
        // Create a random password with n characters
        String tempPassword = generateRandomPassword(n); 
        // Update the password in the parent class (User)
        setPassword(tempPassword); 
        return tempPassword;
    }

    // Utility method to generate a random password
    private String generateRandomPassword(int length) {
        byte[] randomBytes = new byte[length];
        RANDOM.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes).substring(0,length); 
    }
}

