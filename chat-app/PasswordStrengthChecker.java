import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String strength = evaluatePasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    public static String evaluatePasswordStrength(String password) {
        int lengthScore = password.length() >= 8 ? 1 : 0;
        int uppercaseScore = password.matches(".*[A-Z].*") ? 1 : 0;
        int digitScore = password.matches(".*\\d.*") ? 1 : 0;
        int specialCharScore = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*") ? 1 : 0;

        int totalScore = lengthScore + uppercaseScore + digitScore + specialCharScore;

        if (totalScore == 4) {
            return "Strong";
        } else if (totalScore >= 2) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
}
