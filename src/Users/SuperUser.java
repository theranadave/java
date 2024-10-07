package Users;

public class SuperUser extends User {

    public SuperUser(String username, String password) {
        super(username, password);
        //TODO Auto-generated constructor stub
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