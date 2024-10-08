package Users;

public class AnonUser extends User {

    public AnonUser(String username, String password) {
        super(username, password);
        this.auth_type = "anon";
    }

    public String getNewUser() {
        //create tmp password
        return "fixme";
    }

    public String getNewPassword() {
        //create tmp password
        return "fixme";
    }
}

