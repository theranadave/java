package Password;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";
    private static final int DEFAULT_LENGTH = 16;

    public static void main(String[] args) {
        System.out.println("Password with special characters: " + generatePassword(16, true));
        System.out.println("Default password without special characters: " + generatePassword(false));
    }

    public static String generatePassword(boolean includeSpecialCharacters) {
        return generatePassword(DEFAULT_LENGTH, includeSpecialCharacters);
    }

    public static String generatePassword(int length, boolean includeSpecialCharacters) {
        StringBuilder characterSet = new StringBuilder(LOWERCASE + UPPERCASE + DIGITS);
        if (includeSpecialCharacters) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // pull a random char
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }


}