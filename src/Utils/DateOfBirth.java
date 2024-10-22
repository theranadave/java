package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateOfBirth {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your date of birth (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();

        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean adult = over18(dateOfBirth);

        System.out.println("Your date of birth is: " + dateOfBirth.format(DateTimeFormatter.ofPattern("MMM d, yyyy")));
        System.out.println("Is an adult: " + adult);
    }

    public static boolean over18(LocalDate dateOfBirth) {

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears() > 18;

    }

}