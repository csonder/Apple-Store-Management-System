package Sales_Management;

import java.util.Scanner;

public class CustomerMenu {

    public static void options() {
    	Display d = new Display();
        Scanner sc = new Scanner(System.in);

        	boolean customerMenuRunning = true;
        	
        while (customerMenuRunning) {
        	//Calls customer menu display
            d.customerMenu();
            
            System.out.print("To get started, select a number: ");
            	int number = sc.nextInt();
            	System.out.println();

            switch (number) {
                case 1:
                	System.out.println(d.title[0][0]);
                		Product.viewProducts();
                	System.out.println();
                	System.out.println();
                    break;
                case 2:
                	System.out.println(d.title[0][1]);
                		ProductServices.purchaseProducts();
                	System.out.println();
                	System.out.println();
                    break;
                case 3:
                	System.out.println(d.title[0][2]);
                    	Transaction.viewCustomerTransactions(Login.activeCustomer);
                    System.out.println();
                    System.out.println();
                    break;
                case 0:
                    System.err.println("Logging out...");
                    customerMenuRunning = false;
//RETURN TO LOGIN--------------------
                    	Login.beginLogin();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        
        sc.close();

    }
}
