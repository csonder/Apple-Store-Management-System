package Sales_Management;

public class Display {	
	
		String[][] title = {
						{"[Apple Inventory]", "[Purchase Product]", "[Transactions]"},
						{"[Customer Accounts]", "[Product Manager]"},
				};
	
    public void adminMenu() {
        System.out.println("======================  ");
        System.out.println("  🍎 Admin Dashboard    ");
        System.out.println("======================  ");
        System.out.println("(1) Manage Products     ");
        System.out.println("(2) View Customer Accounts");
        System.out.println("(3) View Transactions   ");
        System.out.println("(0) Logout              ");
    }
    
    public void customerMenu() {
        System.out.println("==========================");
        System.out.println("    🍎 Customer Menu      ");
        System.out.println("==========================");
        System.out.println("(1) View Products        ");
        System.out.println("(2) Purchase Product     ");
        System.out.println("(3) View My Transactions ");
        System.out.println("(0) Logout               ");
    }
    
    public void adminProductMenu() {
        System.out.println("(1) Add Product");
        System.out.println("(2) Delete Product");
        System.out.println("(3) View Products");
        System.out.println("(0) Back");
        System.out.print("Select a number: ");
    }

}
