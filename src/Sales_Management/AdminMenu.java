package Sales_Management;

import java.util.Scanner;

public class AdminMenu {
	
    public static void options() {
    	Display d = new Display();
    	Scanner sc = new Scanner(System.in);

        	boolean adminMenuRunning = true;
        	
        while (adminMenuRunning) {
        	//Calls admin menu display
            d.adminMenu();
            
            System.out.print("To get started, select a number: ");
            	int number = sc.nextInt();
            	System.out.println();

            switch (number) {
                case 1:
                	//Sends admin to another product management panel
                		ManageProducts.pmOptions();
                	break;
                case 2:
                	System.out.println(d.title[1][0]);
                		Customer.viewCustomers();
                	System.out.println();
                	System.out.println();
                    break;
                case 3:
                	System.out.println(d.title[0][2]);
                    	Transaction.viewAllTransactions();
                	System.out.println();
                	System.out.println();
                    break;
                case 0:
                    System.err.println("Logging out...");
                    	adminMenuRunning = false;
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
