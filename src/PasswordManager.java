import java.util.Scanner;

public class PasswordManager {
	public static void main(String[] arg)
	{
        PasswordManager pm=new PasswordManager();
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter user id : ");
	    String userId=sc.nextLine();	
	    System.out.println("Password for user id is : " + pm.getPassword(userId));

        boolean isUnique = pm.isUniquePassword(userId);

	}
    
    static String getPassword(String s)
	{
	    String password="";
        // load user ids and passwords
        // look for user ids and passwords
	    for(int j=s.length();j>0;--j)
	        {
	            password=password+(s.charAt(j-1)); 
	        }
	    return password;
	}


    static Boolean isUniquePassword(String s)
	{
	    String password="";
        // load user ids and passwords
        // look for user ids and passwords
	    for(int j=s.length();j>0;--j)
	        {
	            password=password+(s.charAt(j-1)); 
	        }
			//fix me
	    return true;
	}

}
