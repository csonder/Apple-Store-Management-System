package Sales_Management;

public class Customer {
	
		private String name;
		private String email;
		private String username;
		private String password;
	
	//Customer Array
	public static Customer[] customers = new Customer[1000];
		public static int customerCount = 1;
	
	static {
		customers[0] = new Customer("ITE Student", "ite@example.com", "ITE", "222");
	}
	//Customer Constructor
	public Customer(String name, String email, String username, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);}
	
	//Getters and Setters
	String getPassword() {
		return password;}
	void setPassword(String password) {
		this.password = password;}
	String getUsername() {
		return username;}
	void setUsername(String username) {
		this.username = username;}
	String getEmail() {
		return email;}
	void setEmail(String email) {
		this.email = email;}
	String getName() {
		return name;}
	void setName(String name) {
		this.name = name;}
	
	//View Customers
	public static void viewCustomers() {
		if(customerCount == 0) {
			System.out.println("No customers found.");
			return;}
		
		else{
			System.out.println("Registered Customers: ");
			
				for(int i = 0; i < customerCount; i++) {
						Customer c = customers[i];
					System.out.println((i + 1) + ". Name: " + c.getName());
        			System.out.println("   Email: " + c.getEmail());
        			System.out.println("   Username: " + c.getUsername());
        			System.out.println("-----------------------------");}
			}
		}
	//Check if Username Exists
	public static boolean usernameExists(String username) {
	    for (int i = 0; i < customerCount; i++) {
	        	Customer c = customers[i];
	        if (c != null && c.getUsername().equals(username)) {
	            return true;}
	    }
	    return false;
	}

}

