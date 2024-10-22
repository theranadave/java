import java.util.Scanner;

import Password.PasswordGenerator;
import PasswordStore.PasswordStore;
import Users.AnonUser;
import Users.DisposableUser;
import Users.User;

import java.util.List;

public class CredentialManager {

	public static void main(String[] arg) {
        // String website = "ebay";
        // String username = "dave";
        // String password = "dave";
        //CredentialManager.retrieveCredentials();
        //PasswordStore.addData(website, username, password);
        //PasswordStore.removeData(website, username);
        CredentialManager.generateCredentials();
	}

    public static void retrieveCredentials() {   
	    Scanner input=new Scanner(System.in);
	    System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        System.out.println("Website: " + website);

        if (website.equals("Exit")){
            System.out.println("Returning to main menu.");
            return;
        }
	
        String username = "";
        boolean valid=false;
        boolean find_user=false;
        while(!valid){
            System.out.print("Do you know the username (Yes/No): ");
            String choice=input.nextLine();
            switch(choice){
                case "Yes":
                case "yes":
                    valid = true;
                    find_user = true;
                    break;
                case "No":
                case "no":
                    valid = true;
                    find_user = false;
                    break; 
                default:
                    System.out.print("Enter either (Yes/No): ");    
            }
        }
        if (find_user){
            System.out.print("Enter username: ");
            username=input.nextLine();
            getWebsiteDetails(website, username);
        } else {
            getWebsiteDetails(website);
        }   

	}

    public static void getWebsiteDetails(String website){
        //System.out.println("getWebsiteDetails");
        System.out.println("=====================\n");
        List<List<String>> data = PasswordStore.getData();  
        boolean found=false;
        for(List<String> entry: data){
            if (entry.get(0).equals(website)){
                System.out.println("User: "+entry.get(1)+
                " Password: "+entry.get(2)+
                "\n Found for website: "+ entry.get(0)); 
                found = true; 
            }
        }  
        if (!found){
            System.out.println("No entry found for website: "+website);
        }
        System.out.println("=====================\n");
        return;
    }  

    public static void getWebsiteDetails(String website, String username) {
        System.out.println("=====================\n");
        List<List<String>> data = PasswordStore.getData();  
        boolean found=false;
        for(List<String> entry: data){
            if (entry.get(0).equals(website)){
                if(entry.get(1).equals(username)){                
                    System.out.println("Password is: "+entry.get(2)+
                    "\n for user: "+entry.get(1) +
                    " at website :"+ entry.get(0)); 
                    found = true; 
                }
            }
        }  
        if (!found){
            System.out.println("No entry found for user: "+
            username+ " at website: "+website);
        }
        System.out.println("=====================\n");
        return;
    }

    public static void createCredentials() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        if (website.equals("Exit")) {
            return;
        }
        System.out.print("Enter username: ");
        String username=input.nextLine();
       
        System.out.print("Enter password: ");
        String password=input.nextLine();
        PasswordStore.addData(website, username, password);

    }

    public static void deleteCredentials() {
        System.out.println("=====================\n");
        Scanner input=new Scanner(System.in);
        System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        System.out.print("Enter username: ");
        String username=input.nextLine();
        PasswordStore.removeData(website, username);
        System.out.println("=====================\n");
    }  

    public static void dumpData(){
        List<List<String>> data = PasswordStore.getData();  

        for(List<String> entry: data){
            System.out.println("User: "+entry.get(1)+
            " Password: "+entry.get(2)+
            "\n Found for website: "+ entry.get(0)); 
        }  
        return;
    }

    public static void generateCredentials() {

        String username, password;
        User user;

        Scanner input=new Scanner(System.in);
        System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        if (website.equals("Exit")) {
            return;
        }

        System.out.println("Choose from the following options:");
        System.out.println("1. Manual username for website.");
        System.out.println("2. AnonUser for website.");
        System.out.println("3. DisposableUser for website.");
        System.out.print("Enter choice: "); // keeps to same line!
        String choice=input.nextLine();

        switch(choice){
            case "1":
                System.out.print("Enter username: ");
                username=input.nextLine();
                password = PasswordGenerator.generatePassword(false);
                user = new User(username, password);
                break;
            case "2": 
                user = new AnonUser();
                username= user.getUsername();
                password = user.getPassword();
                System.out.println("Generated Anon Username is: " + username);  
                break; 
            case "3":
                user = new DisposableUser();
                username= user.getUsername();
                password = user.getPassword();
                System.out.println("Generated Disposable Username is: " + username);  
                break; 
            default:
                System.out.print("Exiting.");
                return;    
        }
        System.out.println("Generated Password is: " + password);
        PasswordStore.addData(website, username, password);    
    }  

}
