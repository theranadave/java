package Users;

public class UniqueUser extends User {
    public UniqueUser(String username, String password) {
        super(username, password);
        this.auth_type = "unique";
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
