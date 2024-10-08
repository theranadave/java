package Password;

public class Password {


    // Check password complexity

    public static boolean checkPasswordComplexity(String password) {
        return checkPasswordComplexity(password, 8);

    }

    public static boolean checkPasswordComplexity(String password, int minimumLength) {
        // Check for minimum length
        if (password.length() < minimumLength) {
            System.out.println("Warning: Password is less than " + minimumLength + " characters.");
            return false;
        }

        // Check for uppercase, lowercase, digit, and special character
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static boolean checkPasswordComplexity(String password) {
        // Check for minimum length, uppercase, lowercase, digit, and special character
        boolean minimumLength = true;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) {
            System.out.println("Warning: Password is less than 8 characters.");
            minimumLength = false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;

            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) break;
        }

        if (!hasUppercase ) System.out.println("Warning: Password is a missing uppercase character.");
        if (!hasLowercase) System.out.println("Warning: Password is a lowercase uppercase character.");
        if (!hasDigit) System.out.println("Warning: Password is missing a digit character.");
        if (!hasSpecialChar) System.out.println("Warning: Password is missing a special character character.");

        return minimumLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }




}
