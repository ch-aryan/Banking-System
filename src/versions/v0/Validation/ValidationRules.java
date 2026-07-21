package versions.v0.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRules {
    public static boolean isValidUsername(String name) {

        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (name == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(name);

        // Return if the username
        // matched the ReGex
        return m.matches();
    }
//password must contains minimum 8 character include 1 captial letter, a special char and a number

    /**
     * Validates password:
     * - Minimum 8 characters
     * - At least 1 uppercase letter
     * - At least 1 special character (!@#$%^&*()-+=[])
     * - At least 1 digit
     */
    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        // Regex explanation:
        // ^                              - start of string
        // (?=.*[A-Z])                   - at least one uppercase letter
        // (?=.*\d)                       - at least one digit
        // (?=.*[!@#$%^&*()-+=\[]])       - at least one special character
        // .{8,}                          - minimum 8 characters
        // $                              - end of string
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+=\\[]).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            return false;
        }
        return fullName.length() > 3 && fullName.length() <= 25;
    }
}
