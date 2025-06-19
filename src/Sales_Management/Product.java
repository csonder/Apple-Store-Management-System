package Sales_Management;

public class Product extends ProductServices{
	
	     private int id;
	     private String name;
	     private double price;
	     private int stock;
	
	//Product Array
	public static Product[] products = new Product[100];
	    public static int productCount = 3;
	    public static int nextId = 3;

	    static {
	        products[0] = new Product(1, "IPHONE 15", 999.99, 10);
	        products[1] = new Product(2, "MACBOOK AIR", 1299.99, 5);
	        products[2] = new Product(3, "AIRPOD PRO", 249.99, 20);
	        }
	    
	    //Product Constructor 
	    public Product(int id, String name, double price, int stock) {
	        this.setId(id);
	        this.setName(name);
	        this.setPrice(price);
	        this.setStock(stock);}

	    //Getters and Setters
		int getStock() {
			return stock;}
		void setStock(int stock) {
			this.stock = stock;}
		double getPrice() {
			return price;}
		void setPrice(double price) {
			this.price = price;}
		String getName() {
			return name;}
		void setName(String name) {
			this.name = name;}
		int getId() {
			return id;}
		void setId(int id) {
			this.id = id;}
	
		//View Products
		 public static void viewProducts() {
		        for (int i = 0; i < Product.products.length; i++) {
		            	Product product = Product.products[i];
		            if (product != null) {
		                System.out.println("ID: " + product.getId());
		                System.out.println("Name: " + product.getName());
		                System.out.println("Price: $" + product.getPrice());
		                System.out.println("Stock: " + product.getStock());
		                System.out.println("-------------------------");
		            }
		        }
		    }
		 
		//Finds Product by ID
		public static Product findProductById(int productId) {
		    for (int i = 0; i < products.length; i++) {
		        if (products[i] != null && products[i].getId() == productId) {
		            return products[i];
		        }
		    }
		    return null;
		}


}
