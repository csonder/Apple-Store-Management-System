package Sales_Management;

import java.util.Scanner;

public class ProductServices {
	
			static Scanner sc = new Scanner(System.in);
	
		public static double rChange;
		public static double rTotal;
		public static double payment;
		public static String paymentType;
	 
//Method to add products-------------------------
	 public static void addProduct() {
	        
	        if (Product.productCount >= Product.products.length) {
	            System.out.println("Product list is full.");
	            return;}
	        
	        System.out.print("Enter Product Name: ");
	        	String name = sc.nextLine().toUpperCase();
	        System.out.print("Enter Product Price: ");
	        	double price = sc.nextDouble();

	        System.out.print("Enter Product Stock: ");
	        	int stock = sc.nextInt();
		        //Increase the ID for each new product
		        Product.nextId++;
	        
	        Product newProduct = new Product(Product.nextId, name, price, stock);
	        	//Updates the array with the new product
	        	Product.products[Product.productCount] = newProduct;
	        	Product.productCount++;

	        System.out.println("Product added with ID: " + newProduct.getId());
	    }
	 
//Method to delete product-------------------------
	 public static void deleteProduct() {
		   
		    System.out.print("Enter Product ID to delete: ");
		    int idToDelete = sc.nextInt();

		    	boolean found = false;
		    for (int i = 0; i < Product.productCount; i++) {
		        if (Product.products[i] != null && Product.products[i].getId() == idToDelete) {
		            for (int j = i; j < Product.productCount - 1; j++) {
		                Product.products[j] = Product.products[j + 1];
		            }
		            Product.products[Product.productCount - 1] = null;
		            Product.productCount--;

		            System.out.println("Product with ID " + idToDelete + " deleted.");
		            found = true;
		            break;
		        }
		    }

		    if (!found) {
		        System.out.println("Product not found.");
		    }
		}
	 
//Method to purchase product----------------------------
	 public static void purchaseProducts() {
		 
		    System.out.println("Here are our available products:");
		    	Product.viewProducts();

		    System.out.print("How many different products do you want to buy? ");
		    int numberOfItems = sc.nextInt();

		    double total = 0.0;

		    for (int i = 0; i < numberOfItems; i++) {
		        System.out.print("Enter Product ID: ");
		        int productId = sc.nextInt();

		        System.out.print("Enter Quantity: ");
		        int quantity = sc.nextInt();
		        
		        //Calls find product method
		        Product selectedProduct = Product.findProductById(productId);


		        if (selectedProduct == null) {
		            System.out.println("Product ID not found.");
		            continue;
		        }

		        if (selectedProduct.getStock() >= quantity) {
		            int newStock = selectedProduct.getStock() - quantity;
		            selectedProduct.setStock(newStock);

		            double itemTotal = selectedProduct.getPrice() * quantity;
		            total += itemTotal;

		            System.out.println("Purchased " + quantity + " x " + selectedProduct.getName() +
		                    " ($" + selectedProduct.getPrice() + " each) = $" + Math.round(itemTotal * 100.0) / 100.0);


		            // Save transaction
		            Transaction t = new Transaction(Login.activeCustomer, selectedProduct.getName(), quantity, selectedProduct.getPrice());
		            t.save();
		        } 
		        
		        else {
		            System.out.println("Not enough stock for " + selectedProduct.getName());
		        }

		        System.out.println();
		    }

		    rTotal = Math.round(total * 100.0) / 100.0;
		    System.out.println("Total amount due: $" + rTotal);


		    // Ask for payment type
		    System.out.print("Enter payment method (cash/credit): ");
		    sc.nextLine();
		    paymentType = sc.nextLine().toLowerCase();

		    	boolean paymentSuccessful = false;
		    	
		    //CASH	
		    if (paymentType.equals("cash")) {
		        System.out.print("Enter cash amount: $");
		        payment = sc.nextDouble();	      
		        
		        if (payment >= total) {
		            double change = payment - total;		            
		            rChange = Math.round(change* 100.0) / 100.0;
		            System.out.println("Payment successful.");
		            System.out.println("Your change is: $"+rChange);
		            paymentSuccessful = true;
		        } else {
		            double shortfall = total - payment;
		            System.out.println("Insufficient funds. You are short by: $"+ shortfall);
		        }
		    } 
		    
		    //CREDIT
		    else if (paymentType.equals("credit")) {
		        System.out.print("Credit card number: ");
		        int cardNumber = sc.nextInt();
		        sc.nextLine();

		        System.out.print("Credit card holder: ");
		        String cardHolder = sc.nextLine();

		        System.out.print("Expiration date (M/Y): ");
		        String expireDate = sc.nextLine();

		        System.out.print("CCV: ");
		        int ccv = sc.nextInt();

		        if (String.valueOf(cardNumber).length() >= 6 && !cardHolder.isEmpty() && !expireDate.isEmpty() && ccv >= 100 && ccv <= 999) {
		            System.out.println("Credit payment accepted.");
		            paymentSuccessful = true;
		        } else {
		            System.out.println("Invalid credit card details. Purchase cancelled.");
		        }
		    }
		    
		    //Successful payment
		    if (paymentSuccessful) {
		        System.out.println("Your receipt is printed below.");
		        //Calls receipt print method
		        	Transaction.printReceipt(Login.activeCustomer);
		    } 
		    
		    else {
		        System.out.println("Transaction failed. No purchase was saved.");
		    }
		}


	}



