package PasswordStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
//import java.io.Writer;

public class PasswordStore {
    private static final String CREDENTIALFILENAME = "data.csv";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String SALT = "12345";

	public static void main(String[] arg) {
        List<List<String>> data  = PasswordStore.getData();
        System.out.println("File data is : "+data);
        //PasswordStore.addData("1", "2", "3");
        //PasswordStore.addData("a", "b", "3");
        PasswordStore.addData("x", "y", "3");
        PasswordStore.removeData("x", "y");
	}

    public static List<List<String>> getData() {
        try{
            List<List<String>> data = PasswordStore.loadData();
	        //System.out.println("You choice is : "+data);
            return data;
        } catch (FileNotFoundException e){
            System.out.println("No credential file found."); 
            PasswordStore.createCredentialFile();
        }
        return null; 
    } 

    private static List<List<String>> loadData() throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(CREDENTIALFILENAME))) {
            System.out.println("Loading data from credential file.");
            while (scanner.hasNextLine()) {          
                records.add(getRecordFromLine(scanner.nextLine()));
            }
       }
        return records;  
    } 

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    private static void createCredentialFile() {
        File csvOutputFile = new File(CREDENTIALFILENAME);
        try {
            csvOutputFile.createNewFile();
            System.out.println("Created credential file."); 
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void addData(String website, String username, String password) {
        List<List<String>> data  = PasswordStore.getData();
        PasswordStore.deleteCredentialFile();
        PasswordStore.createCredentialFile();
        
        
        try (PrintWriter writer = new PrintWriter(CREDENTIALFILENAME, "utf-8")) {
            for (int i = 0; i < data.size(); i++) {
                List<String> record = data.get(i); 
                writer.println(record.get(0) + "," + 
                                record.get(1)+ "," +
                                record.get(2));
                //System.out.println(record); 

            }
            writer.println(website + ','+username+ ','+ password);
            writer.close();
            System.out.println("Added to credential file."); 

        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void deleteCredentialFile() {
        File csvOutputFile = new File(CREDENTIALFILENAME);
        csvOutputFile.delete();
        System.out.println("Removed credential file."); 
    }

    public static void removeData(String website, String username) {
        List<List<String>> data  = PasswordStore.getData();
        PasswordStore.deleteCredentialFile();
        PasswordStore.createCredentialFile();
        boolean removed = false;

        try (PrintWriter writer = new PrintWriter(CREDENTIALFILENAME, "utf-8")) {
            for (int i = 0; i < data.size(); i++) {
                List<String> record = data.get(i); 
                if (record.get(0).equals(website) && record.get(1).equals(username) ){
                    removed = true;
                    System.out.println("record");
                    System.out.println(record);
                    System.out.println("Skipping website/username:" + website + " " + username); 
                    System.out.println("record");
                } else {
                    writer.println(record.get(0) + "," + 
                                    record.get(1)+ "," +
                                    record.get(2));
                    System.out.println(record); 
                }
            }
            writer.close();
            if(removed){
                System.out.println("Removed from credential file."); 
            } else {
                System.out.println("Not found in credential file.");
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }
}

