import java.util.*;

public class ShoppingCart 
{
    public static void main(String[] args) 
    {
        HashMap<String, Double> priceList = new HashMap<>();
        priceList.put("Apple", 12.0);
        priceList.put("Banana", 10.5);
        priceList.put("Milk", 38.5);
        priceList.put("Bread", 58.0);
        priceList.put("Eggs", 6.0);

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> cart = new HashMap<>();

        System.out.println("Available items and their prices:");
        for (Map.Entry<String, Double> entry : priceList.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "/-");
        }

        while (true) 
        {
            System.out.print("Enter item name (or type 'done' to finish): ");
            String item = scanner.nextLine();

            if (item.equalsIgnoreCase("done")) 
            {
                break;
            }

            if (!priceList.containsKey(item)) 
            {
                System.out.println("Item not available. Please try again.");
                continue;
            }

            System.out.print("Enter quantity for " + item + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            cart.put(item, cart.getOrDefault(item, 0) + quantity);
        }

        double totalPrice = 0.0;
        System.out.println("\nItemized Bill:");
        System.out.println("----------------------------");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) 
        {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double price = priceList.get(item) * quantity;
            totalPrice += price;
            System.out.printf("%-10s x %-3d = %.2f/-\n", item, quantity, price);
        }
        System.out.println("----------------------------");
        System.out.printf("Total Price: %.2f/-\n", totalPrice);
    }
}
