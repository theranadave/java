package Users;

import Password.PasswordGenerator;

public class SuperUser extends User {
    private static final int DEFAULT_LENGTH = 16;

    public SuperUser(String username, String password) {
        super(username, password);
        this.auth_type = "super";
    }
    
    public String getNewUser() {
        //create tmp password
        //UserName uname = new UserNameGenerator("admin");
        return "uname";
    }

    public String getNewPassword() {
        String tempPassword = PasswordGenerator.generatePassword(DEFAULT_LENGTH,false);
        setPassword(tempPassword); 
        return tempPassword;
    }

}