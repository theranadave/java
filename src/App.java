import UserInterface;
import CredentialManager;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, there!");
      //  Credentials.retrieveCredentials();
        int choice  = UserInterface.showMenu();
	    System.out.println("You choice is : "+choice);
        App.getOption(choice);

    }

    static void getOption(int choice)
	{
        switch (choice) {
            case 1:
                System.out.println("Retrieve username/password for website.");
                CredentialManager.retrieveCredentials();
                break;
            case 2:
                System.out.println("Create username/password for a website.");
                CredentialManager.createCredentials();
                break;
            case 3:
                System.out.println("Delete username/password for a website.");
                CredentialManager.deleteCredentials();
                break;
            case 4:
                System.out.println("Change a username for a website.");
                break;
            case 5:
                System.out.println("Change a password for a website.");
                break;
            case 6:
                System.out.println("Delete user.");
                break;
            case 7:
                System.out.println("Print usernames/passwords for website.");
                break;
            case 0:
                System.out.println("Exit.");
                break;
          }


	    return;
	}


}
