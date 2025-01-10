import java.util.Scanner;

class Cryptography 
{

    // Caesar Cipher encryption
    static String caesarEncrypt(String text, int key) 
    {
        StringBuilder result = new StringBuilder();
        key = key % 26; 
        for (char c : text.toCharArray()) 
        {
            if (Character.isUpperCase(c)) 
            {
                result.append((char) ((c - 'A' + key) % 26 + 'A'));
            } 
            else if (Character.isLowerCase(c)) 
            {
                result.append((char) ((c - 'a' + key) % 26 + 'a'));
            } 
            else 
            {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Caesar Cipher decryption
    static String caesarDecrypt(String text, int key) 
    {
        return caesarEncrypt(text, 26 - (key % 26)); 
    }

    // Vigenère Cipher encryption
    static String vigenereEncrypt(String text, String key, boolean decrypt) 
    {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) 
        {
            int shift=0;
            if (Character.isLetter(c)) 
            {
                /*if (Character.isUpperCase(key.charAt(keyIndex))) 
                {
                    shift = key.charAt(keyIndex) - 'A'; 
                }*/
                 /*if (Character.isLowerCase(key.charAt(keyIndex))) 
                {
                    shift = key.charAt(keyIndex) - 'a'; 
                }*/
                shift = key.charAt(keyIndex) - 'a';
                if (decrypt) 
                {
                    shift = 26 - shift; // Reverse the shift for decryption
                }
                if (Character.isUpperCase(c)) 
                {
                    result.append((char) ((c - 'A' + shift) % 26 + 'A'));
                } 
                else 
                
                {
                    result.append((char) ((c - 'a' + shift) % 26 + 'a'));
                }
                keyIndex = (keyIndex + 1) % key.length();
            } 
            else 
            {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Vigenère Cipher decryption
    static String vigenereDecrypt(String text, String key) 
    {
        return vigenereEncrypt(text, key, true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Cryptography Encoder/Decoder");
        System.out.println("Choose a cipher:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenere Cipher");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 
    
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
    
        if (choice == 1) 
        {
            System.out.println("Choose an operation:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.print("Enter your choice: ");
            int operation = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter the key (integer): ");
            int key = sc.nextInt();
    
            if (operation == 1) 
            {
                System.out.println("Encrypted text: " + caesarEncrypt(text, key));
            } 
            else if (operation == 2) 
            {
                System.out.println("Decrypted text: " + caesarDecrypt(text, key));
            } 
            else 
            {
                System.out.println("Invalid operation choice!");
            }
        } 
        else if (choice == 2) 
        {
            System.out.println("Choose an operation:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.print("Enter your choice: ");
            int operation = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter the key (string): ");
            String key = sc.nextLine();
    
            if (operation == 1) 
            {
                System.out.println("Encrypted text: " + vigenereEncrypt(text, key, false)); 
            } 
            else if (operation == 2) 
            {
                System.out.println("Decrypted text: " + vigenereDecrypt(text, key)); 
            } 
            else 
            {
                System.out.println("Invalid operation choice!");
            }
        } 
        else 
        {
            System.out.println("Invalid cipher choice!");
        }
    
        sc.close();
    }
    
}
