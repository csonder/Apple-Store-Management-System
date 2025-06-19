package Sales_Management;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {
	    private String customerName;
	    private String productName;
	    private int quantity;
	    private double price;
	    private Date transactionDate;
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    //Transaction Array
    public static Transaction[] transactions = new Transaction[1000];
    		public static int transactionCount = 0;
    		
    	    //Stored transactions
    	    static {
    	        Product[] products=Product.products;
    	        transactions[0] = new Transaction("ITE", products[0].getName(), 1, products[0].getPrice());
    	        transactions[0].transactionDate = new Date(System.currentTimeMillis() - 86400000); // Yesterday
    	        transactions[1] = new Transaction("ITE",  products[0].getName(), 2, products[0].getPrice());
    	        transactions[1].transactionDate = new Date(System.currentTimeMillis() - 172800000); // 2 days ago
    	        transactionCount = 2;
    	    }
    	    
    //Transaction Constructor
    public Transaction(String customerName, String productName, int quantity, double price) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.transactionDate = new Date();
    }

    // Save transaction to memory
    public void save() {
        if (transactionCount < transactions.length) {
            transactions[transactionCount] = this;
            transactionCount++;
        } else {
            System.err.println("Transaction storage full. Cannot save more transactions.");
        }
    }

    // View all transactions (for admin)
    public static void viewAllTransactions() {
        System.out.println("=== ALL TRANSACTIONS ===");
        if (transactionCount == 0) {
            System.out.println("No transactions recorded yet.");
            return;
        }
        
        for (int i = 0; i < transactionCount; i++) {
            Transaction t = transactions[i];
            System.out.println("Customer: " + t.customerName);
            System.out.println("Product: " + t.productName);
            System.out.println("Quantity: " + t.quantity);
            System.out.println("Price: $" + t.price);
            System.out.println("Date: " + dateFormat.format(t.transactionDate));
            System.out.println("-----------------------------");
        }
    }

    // View customer-specific transactions
    public static void viewCustomerTransactions(String customerName) {
        System.out.println("=== YOUR TRANSACTIONS ===");
        	boolean found = false;
        
        for (int i = 0; i < transactionCount; i++) {
            Transaction t = transactions[i];
            if (t.customerName.equalsIgnoreCase(customerName)) {
                found = true;
                System.out.println("Product: " + t.productName);
                System.out.println("Quantity: " + t.quantity);
                System.out.println("Price: $" + t.price);
                System.out.println("Date: " + dateFormat.format(t.transactionDate));
                System.out.println("-----------------------------");
            }
        }
        
        if (!found) {
            System.out.println("No transactions found for " + customerName);
        }
    }
    
    //Print receipt
    public static void printReceipt(String customerName) {
        Random rand = new Random();
        	int receiptNumber = 100000 + rand.nextInt(900000);
        
        if (transactionCount == 0) {
            System.out.println("No transactions found.");
            return;
        }

        Transaction last = transactions[transactionCount - 1];
        	if (!last.customerName.equalsIgnoreCase(customerName)) {
        		System.out.println("No recent transactions found for " + customerName);
        		return;
        }
        
        //CREDIT	
        if (ProductServices.paymentType.equals("credit")) {
        	System.out.println();
            System.out.println("========= RECEIPT =========");
            System.out.println("Receipt No: " + receiptNumber);
            System.out.println("Customer: " + last.customerName);
            System.out.println("Product: " + last.productName);
            System.out.println("Quantity: " + last.quantity);
            System.out.println("Price: $"+ last.price);
            System.out.println("Date: " + dateFormat.format(last.transactionDate));
            System.out.println("-----------------------------");
            System.out.println("Total: $"+ProductServices.rTotal);
            System.out.println("=============================");
            System.out.println("   Thank you for shopping!  ");
            System.out.println("=============================");  	
        }
        
        //CASH
        else if (ProductServices.paymentType.equals("cash")) {
        System.out.println();	
        System.out.println("========= RECEIPT =========");
        System.out.println("Receipt No: " + receiptNumber);
        System.out.println("Customer: " + last.customerName);
        System.out.println("Product: " + last.productName);
        System.out.println("Quantity: " + last.quantity);
        System.out.println("Price: $"+ last.price);
        System.out.println("Date: " + dateFormat.format(last.transactionDate));
        System.out.println("-----------------------------");
        System.out.println("Cash: "+ProductServices.payment);
        System.out.println("Total: $"+ProductServices.rTotal);
        System.out.println("Change: $"+ProductServices.rChange);
        System.out.println("=============================");
        System.out.println("   Thank you for shopping!  ");
        System.out.println("=============================");}
    }

}