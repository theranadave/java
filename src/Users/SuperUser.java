package Users;

public class SuperUser extends User {

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
        //create tmp password
        //UserPassword upassword = new UserNamePassword("admin");
        return "upassword";
    }

}