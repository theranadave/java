package Users;

import Password.PasswordGenerator;

public class AnonUser extends User {

    public AnonUser() {  
        super(); // Calls the constructor of the superclass.      
        this.username = getNewUserName();
        this.password = getNewPassword();
        this.auth_type = "anon";
    }

    public String getNewUserName() {
        String username = PasswordGenerator.generatePassword(8, false);
        return username;
    }


    public String getNewPassword() {
        String password = PasswordGenerator.generatePassword(true);
        setPassword(password); 
        return password;
    }

    @Override // overrides the superclass
    public String getType() {
        return "anon_user";
    }

    public String returnType() {
        return super.getType(); // calls the superclass's getType method.
    }

}

