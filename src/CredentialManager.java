import java.util.Scanner;
import PasswordStore.PasswordStore;
import java.util.List;

public class CredentialManager {

	public static void main(String[] arg) {
        // String website = "ebay";
        // String username = "dave";
        // String password = "dave";
        //Credentials.retrieveCredentials();
        //PasswordStore.addData(website, username, password);
        //PasswordStore.removeData(website, username);
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
        return;
    }  

    public static void getWebsiteDetails(String website, String username) {
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
        return;
    }

    public static void createCredentials() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        System.out.print("Enter username: ");
        String username=input.nextLine();
        System.out.print("Enter password: ");
        String password=input.nextLine();

        PasswordStore.addData(website, username, password);

    }

    public static void deleteCredentials() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter website (or Exit): ");
        String website=input.nextLine();
        System.out.print("Enter username: ");
        String username=input.nextLine();
        PasswordStore.removeData(website, username);
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

}
