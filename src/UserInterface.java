import java.util.Scanner;

public class UserInterface {
	public static void main(String[] arg) {
        int choice = UserInterface.showMenu();
	    System.out.println("You choice is : "+choice);

	}

    public static int showMenu() {
        Integer result;

        Scanner input=new Scanner(System.in);
        System.out.println("\nWelcome to Password Manager!");
        System.out.println("************************\n");
        System.out.println("Choose from the following options:");
        System.out.println("1. Retrieve username/password for website.");
        System.out.println("2. Create username/password for a website.");
        System.out.println("3. Generate username/password for a website.");
        System.out.println("4. Delete username/password for a website.");
        System.out.println("5. Change a username for a website.");
        System.out.println("6. Change a password for a website.");
        System.out.println("7. Delete user.");
        System.out.println("8. Print usernames/passwords for website.");
        System.out.println("0. Exit.");
        System.out.println("A. Raise unchecked exception.");
        System.out.println("************************\n");
        System.out.print("Enter choice: "); // keeps to same line!
        String choice=input.nextLine();
        
        try {
            result = Integer.valueOf(choice);
        } catch (NumberFormatException e) {
            if (choice.equals("A")){
                // unchecked exception
                System.out.println("Raise unchecked exception.");
                result = Integer.valueOf(choice);
            } 
            System.out.println("Invalid Choice, defaulting to exit.");
            result = 0;
        }
        
        if (result == 99) {
            System.out.println("Debug");
            result = 99;
        } else if (0 > result || result > 7) {
            System.out.println("Invalid Choice, defaulting to exit.");
            result = 0;
        }

        return result;
    }

}
