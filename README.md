# QuickMart Retail Billing System

**BUC2125 — Object-Oriented Programming | Group Assignment**

A simple console-based Java application that simulates billing a customer at a
small retail shop: add items to a cart, view the cart, and check out with an
automatic discount for large purchases.

## Group Members
1. Ssesimba Mubarak 2500715677 25/U/15677/PS
2. Kiyemba Imran 2500715164 25/U/15164/EVE
3. Naluwagga Rayat Saif 2500715443 25/U/15443/PS
4. Ssentongo Ibrahim Lukwago 2500715671 25/U/15671/EVE
5. Nabalayo Melody 2500715339 25/U/15339/EVE

## Why this project?

A retail billing system is a real world task everyone understands, and it
naturally needs all four concepts from the tutorial videos.

| Concept | Where it's used | Why it fits there |
|---|---|---|
| **While loop** | The main menu in `main()` | We don't know in advance how many times the cashier will use the menu before exiting, a condition-controlled loop is the right tool. |
| **For loop** | `viewCart()` and `checkout()` | We know exactly how many items are in the cart (`itemCount`) — a fixed, known number of repetitions. |
| **Do-while loop** | Menu choice validation in `main()`, and quantity validation in `addItemToCart()` | We must ask for input *at least once* before we can check whether it's valid. |
| **Ternary operator** | `addItemToCart()` and `checkout()` | Short, single-value decisions: singular/plural wording, and the discount amount. |

## How to run it

1. Make sure you have a JDK installed (Java 17+ recommended).
2. Compile:
   ```
   javac RetailBillingSystem.java
   ```
3. Run:
   ```
   java RetailBillingSystem
   ```
4. Follow the on-screen menu: add a few items, view the cart, then check out.
   Try a total above UGX 50,000 to see the discount logic trigger.

## Features

- Add multiple items to a cart (name, price, quantity)
- Re-prompts if the menu choice is out of range, or if quantity is zero or negative
- View the current cart with a formatted, aligned table
- Checkout: totals the bill, applies a 10% discount at UGX 50,000+, prints a receipt
- Cart resets automatically after checkout, ready for the next customer

## Known limitation

The program expects numeric input where a number is asked for. Typing text
(e.g. a letter) at a numeric prompt will crash the program rather than
re-asking, since exception handling for that isn't covered until later in
the course.
