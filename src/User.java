public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}


public class SuperUser extends User {

}


public class AnonUser extends User {

    public String getNewUser() {
        //create tmp password
    }

    public String getNewPassword() {
        //create tmp password
    }
}


public class DisposibleUser extends User {

}


public class UniqueUser extends User {

}
