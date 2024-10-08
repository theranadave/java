package Password;

public class Password {

    public static void main(String[] args) {
        String password = "SecurePass123!";

        // Check password complexity
        if (Password.checkPasswordComplexity(password)) {
            System.out.println("Password meets complexity requirements.");
        } else {
            System.out.println("Password does not meet complexity requirements.");
        }

        password = "pass";
        Password.validatePasswordComplexity(password);

    }



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

    public static boolean validatePasswordComplexity(String password) {
        // Check for minimum length, uppercase, lowercase, digit, and special character
        boolean minimumLength = true;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean fail = false;

        if (password.length() < 8) {
            System.out.println("Warning: Password is less than 8 characters.");
            minimumLength = false;
            fail =true;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;

            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) break;
        }

        if (!hasUppercase ) {
            System.out.println("Warning: Password is a missing uppercase character.");
            fail =true;
        }
        if (!hasLowercase) {
            System.out.println("Warning: Password is a lowercase uppercase character.");
            fail =true;
        }
        if (!hasDigit) {
            System.out.println("Warning: Password is missing a digit character.");
            fail =true;
        }
        if (!hasSpecialChar) {
            System.out.println("Warning: Password is missing a special character character.");
            fail =true;
        }
        
        if (fail) {
            System.out.println("FAILED: Password is not strong enough.");
        }
        return minimumLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }




}
