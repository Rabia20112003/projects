import java.util.*;

class prime {

    public static void primeFactors(int n) {
        // Divide by 2 until n is no longer divisible by 2
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // Try odd numbers from 3 onwards
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) {
            System.out.print(n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        System.out.print("Prime factors: ");
        primeFactors(number);
    }
}
