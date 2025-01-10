import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a string
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        // Check if the string is a palindrome using stack
        if (isPalindrome(str)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    // Method to check if a string is a palindrome using a stack
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        int length = str.length();

        // Push all characters of the string onto the stack
        for (int i = 0; i < length; i++) {
            stack.push(str.charAt(i));
        }

        // Compare the string with the reversed string using stack
        for (int i = 0; i < length; i++) {
            // Pop a character from the stack and compare it with the original string
            if (str.charAt(i) != stack.pop()) {
                return false; // If characters don't match, it's not a palindrome
            }
        }

        return true; // If all characters match, it's a palindrome
    }
}
