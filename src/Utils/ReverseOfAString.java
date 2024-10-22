package Utils;

import java.util.Scanner;

public class ReverseOfAString {
	public static void main(String[] arg) {
        //ReverseOfAString rev=new ReverseOfAString();
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter a string : ");
	    String  str=sc.nextLine();	
	    System.out.println("Reverse of a String  is : " + ReverseOfAString.reverse(str));
        sc.close();
	}

	static String reverse(String s) {
	    String rev="";
	    for(int j=s.length();j>0;--j)
	        {
	            rev=rev+(s.charAt(j-1)); 
	        }
	    return rev;
	}
}
