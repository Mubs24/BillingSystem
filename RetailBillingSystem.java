/*
  QuickMart Retail Billing System
  ---------------------------------
  BUC2125 - Object-Oriented Programming
  Group Assignment: Conditional Statements & Loops

  A simple console app for billing a customer at a small retail shop.

    1. Ternary operator -> singular/plural wording and discount decisions
    2. For loop         -> printing the cart and totalling the items
    3. While loop        -> the main menu, which repeats until the user exits
    4. Do-while loop      -> validating the menu choice and item quantity
  
   up members: 
   . Ssesimba Mu 715677 25/U/15677/PS
   . Kiyemba Imran  64 25/U/15164/EVE
    3. Naluwagga Rayat Saif 2500715443 25/U/15443/PS
    4. Ssentongo Ibrahim Lukwago 2500715671 25/U/15671/EVE
   . Nabalayo Melody 2500715339 25/U/15339/EVE
 * 
 
im t java.util.Scanner;
 
public class RetailBillingSystem {

    static String[] itemNames = new String[20];
    static double[] itemPrices = new double[20];
    static int[] itemQuantities = new int[20];
    static int itemCount = 0; // how many items are currently in the cart

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==== WELCOME TO QUICKMART RETAIL BILLING SYSTEM ====");

        int choice = 0;

        // WHILE LOOP: keep showing the menu until the user chooses Exit (4).
        while (choice != 4) {
            System.out.println("\n1. Add Item  2. View Cart  3. Checkout  4. Exit");

            // DO-WHILE LOOP: ask at least once, repeat only if out of range.
            do {
                System.out.print("Enter your choice (1-4): ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 4);

            if (choice == 1) {
                addItemToCart();
            } else if (choice == 2) {
                viewCart();
            } else if (choice == 3) {
                checkout();
            } else {
                System.out.println("Thank you for using QuickMart Billing System. Goodbye!");
            }
        }

        scanner.close();
    }

    /** Adds one new item to the cart. */
    static void addItemToCart() {
        if (itemCount >= itemNames.length) {
            System.out.println("Cart is full! Please checkout before adding more items.");
            return;
        }

        scanner.nextLine(); // clear leftover newline
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price for " + name + " (UGX): ");
        double price = scanner.nextDouble();

        // DO-WHILE LOOP: quantity must be greater than zero.
        int quantity;
        do {
            System.out.print("Enter quantity for " + name + ": ");
            quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
            }
        } while (quantity <= 0);

        itemNames[itemCount] = name;
        itemPrices[itemCount] = price;
        itemQuantities[itemCount] = quantity;
        itemCount++;

        // TERNARY OPERATOR: "item" vs "items" depending on quantity.
        String unitWord = (quantity == 1) ? "item" : "items";
        System.out.println(quantity + " " + unitWord + " of \"" + name + "\" added to cart.");
    }

    /** Prints every item currently in the cart. */
    static void viewCart() {
        if (itemCount == 0) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("ITEM            PRICE       QTY    SUBTOTAL");

        // FOR LOOP: itemCount is a known, fixed number of repetitions.
        for (int i = 0; i < itemCount; i++) {
            double subtotal = itemPrices[i] * itemQuantities[i];
            System.out.printf("%-15s %8.2f %6d %11.2f%n",
                    itemNames[i], itemPrices[i], itemQuantities[i], subtotal);
        }
    }

    /** Totals the cart, applies a discount, and prints the final receipt. */
    static void checkout() {
        if (itemCount == 0) {
            System.out.println("Your cart is empty. Add items before checking out.");
            return;
        }

        double total = 0;
        // FOR LOOP: sum every item's subtotal.
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i] * itemQuantities[i];
        }

        // TERNARY OPERATOR: 10% discount once the bill reaches UGX 50,000.
        double discount = (total >= 50000) ? total * 0.10 : 0;
        double finalTotal = total - discount;

        System.out.println("\n---------------- RECEIPT ----------------");
        viewCart();
        System.out.printf("Subtotal:      UGX %,.2f%n", total);
        System.out.printf("Discount:      UGX %,.2f%n", discount);
        System.out.printf("TOTAL TO PAY:  UGX %,.2f%n", finalTotal);
        System.out.println("-------------------------------------------");

        itemCount = 0; // reset the cart for the next customer
    }
}
