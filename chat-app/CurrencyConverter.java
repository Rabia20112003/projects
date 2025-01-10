import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter 
{
    public static void main(String[] args) 
    {
        HashMap<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);  //usa
        conversionRates.put("EUR", 0.85); //european
        conversionRates.put("INR", 74.5); //indian rupee
        conversionRates.put("GBP", 0.73); //british 
        conversionRates.put("JPY", 110.0); //japanese

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: USD, EUR, INR, GBP, JPY");
        System.out.print("Enter source currency (e.g., USD): ");
        String sourceCurrency = scanner.nextLine().toUpperCase();


        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!conversionRates.containsKey(sourceCurrency) || !conversionRates.containsKey(targetCurrency)) 
        {
            System.out.println("Invalid currency. Please try again.");
            return;
        }

        System.out.print("Enter amount in " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();

        double sourceToUSD = amount / conversionRates.get(sourceCurrency);
        double convertedAmount = sourceToUSD * conversionRates.get(targetCurrency);

        System.out.printf("%.2f %s is equivalent to %.2f %s.%n", amount, sourceCurrency, convertedAmount, targetCurrency);
    }
}
