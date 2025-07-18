
/**
 * PasswordStrengthChecker.java
 *
 * A professional-level utility that evaluates the strength of passwords based on length,
 * character diversity, and presence of common patterns. This is useful for simulating
 * secure password creation practices in cybersecurity.
 *
 * Author: Eldar Abdivaitov
 * Date: 2025-07-17
 */

import java.util.*;

public class PasswordStrengthChecker {

    private static final Set<String> COMMON_PASSWORDS = Set.of(
        "123456", "password", "admin", "qwerty", "letmein", "12345678", "iloveyou"
    );

    /**
     * Evaluates the strength of a given password and returns a score and message.
     *
     * @param password the password string to evaluate
     * @return feedback on password strength
     */
    public static String evaluatePassword(String password) {
        if (COMMON_PASSWORDS.contains(password.toLowerCase())) {
            return "❌ Very Weak: Common password detected.";
        }

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?].*")) score++;

        switch (score) {
            case 5: return "✅ Excellent: Strong password!";
            case 4: return "✅ Good: Consider adding more special characters.";
            case 3: return "⚠️ Moderate: Add uppercase letters, numbers or symbols.";
            case 2: return "⚠️ Weak: Add length and variety.";
            default: return "❌ Very Weak: Easily guessable.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Enter a password to evaluate:");
        String password = scanner.nextLine();

        String result = evaluatePassword(password);
        System.out.println("🔎 Evaluation Result: " + result);
    }
}
