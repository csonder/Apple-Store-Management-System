package Sales_Management;

import java.util.Scanner;

public class ManageProducts {	
	
	public static void pmOptions() {
		Display d = new Display();
		Scanner sc = new Scanner(System.in);
		
			boolean pmMenuRunning = true;

	    while (pmMenuRunning) {
	    	
	    	System.out.println();
        	System.out.println(d.title[1][1]);
        	d.adminProductMenu();
	        
	        int numbers = sc.nextInt();
	        sc.nextLine();
	        
	        System.out.println();


	        switch (numbers) {
	            case 1:
	                	ProductServices.addProduct();
	                break;
	            case 2:
	                	ProductServices.deleteProduct();
	                break;
	            case 3:
	            	System.out.println(d.title[0][0]);
	                	Product.viewProducts();
	                break;
	            case 0:
	            	pmMenuRunning = false;
	                return;
	            default:
	                System.out.println("Invalid option. Try again.");
	        }
	    }
	    
	    sc.close();
	}


}
