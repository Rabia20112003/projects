import java.util.Scanner;

class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) profit[i] = sc.nextInt();

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) weight[i] = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        System.out.println("Maximum value: " + knapsack(n, profit, weight, capacity));
        sc.close();
    }

    // Knapsack method
    static int knapsack(int n, int[] profit, int[] weight, int capacity) {
        if (n == 0 || capacity == 0) return 0;

        if (weight[n - 1] > capacity) 
        {
            return knapsack(n - 1, profit, weight, capacity);
        } else 
        {
            int include = profit[n - 1] + knapsack(n - 1, profit, weight, capacity - weight[n - 1]);
            int exclude = knapsack(n - 1, profit, weight, capacity);
            return Math.max(include, exclude); 
        }
    }
}
