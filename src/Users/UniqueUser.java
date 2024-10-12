package Users;
import Password.PasswordGenerator;

public class UniqueUser extends User {
    public UniqueUser(String username, String password) {
        super(username, password);
        this.auth_type = "unique";
    }

    public String getNewUser() {
        //check user does not exist 
        return "fixme";
    }

    public String getNewPassword() {
        //create tmp password
        String pass =  PasswordGenerator.generatePassword(false);
        setPassword(pass);        
        return pass;
    }
}
