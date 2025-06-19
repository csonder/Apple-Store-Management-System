# Apple-Store-Management-System
Java Skills Project
## Overview

This is a **console-based Java application** simulating an Apple Store management system. It provides separate interfaces for **Admins** and **Customers** to manage products, make purchases, and track transactions.

---

## Features

### Admin
- Secure login with username and password.
- Manage products:
  - Add new products (name, price, stock).
  - Delete existing products by product ID.
  - View all available products.
- View all registered customers.
- View all transactions made in the store.
- Logout and return to login menu.

### Customer
- Sign up for a new account with email, name, username, and password.
- Login securely.
- View available products.
- Purchase multiple products in one transaction.
- Choose payment method (cash or credit card) with validation.
- View own purchase history.
- Logout and return to login menu.

---

## Getting Started

### Prerequisites
- Java JDK 8 or higher installed on your system.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or command line setup for compiling and running Java programs.

### Running the Application

1. Compile all `.java` files in the project.
2. Run the `Launch` class which contains the `main` method.
3. Follow the on-screen prompts to login as Admin or Customer.

---

## Code Structure

- **Launch.java**: Entry point of the application.
- **Login.java**: Handles user authentication and main menu navigation.
- **Admin.java**: Stores admin credentials.
- **AdminMenu.java**: Admin dashboard for managing products, customers, and transactions.
- **Customer.java**: Manages customer data and registration.
- **CustomerMenu.java**: Customer dashboard for browsing, purchasing, and viewing transactions.
- **Display.java**: Responsible for displaying menus and titles.
- **ManageProducts.java**: Product management panel for Admin.
- **Product.java**: Represents product data and product listing.
- **ProductServices.java**: Contains logic for adding, deleting, and purchasing products including payment handling.
- **Transaction.java**: Records and displays purchase transactions and prints receipts.

---

## How It Works

1. The application starts and prompts the user to login as Admin or Customer.
2. Admins can add/delete/view products, view customers, and view all transactions.
3. Customers can sign up, login, browse products, make purchases, and view their own transaction history.
4. Purchases update product stock and save transactions.
5. Payment options include cash (with change calculation) and credit card (basic validation).
6. Receipts are printed after successful payment.
7. Users can logout to return to the login menu or exit the program.

---

## Limitations

- Data is stored in-memory using static arrays; no persistent database.
- Basic validation for inputs; no encryption for passwords.
- Limited error handling.
- Console-based UI using `Scanner` and `JOptionPane`.

---

## Future Improvements

- Add persistent storage (database integration).
- Encrypt passwords for security.
- Enhance UI with a graphical interface.
- Add more detailed payment validation.
- Implement product categories and search.
- Include reporting and analytics features.

---

## Author

Chonlada Saetang — []
