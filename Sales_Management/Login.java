package Sales_Management;

import javax.swing.JOptionPane;

public class Login {

    public static String activeCustomer;
    
    //ADMIN USERNAME AND PASSWORD
    static Admin a = new Admin("a", "1");

    public static void beginLogin() {

        boolean exitProgram = false;

        while (!exitProgram) {

            String[] loginMenu = {"Admin", "Customer", "Exit"};
            int loginChoice = JOptionPane.showOptionDialog(null, "Welcome to the Apple Store 🍎\nSelect an option:", "Apple Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, loginMenu, loginMenu[0]);
            
            //2=Exit
            if (loginChoice == 2 || loginChoice == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for visiting the Apple Store!");
                break;
            }
            //0=ADMIN
            if (loginChoice == 0) {

                boolean adminLogin = false;

                while (!adminLogin) {

                    String adminUsernameInput = JOptionPane.showInputDialog(null, "Username:", "Admin Login", JOptionPane.QUESTION_MESSAGE);
                    if (adminUsernameInput == null) {
                    	break;
                    }

                    String adminPasswordInput = JOptionPane.showInputDialog(null, "Password:", "Admin Login", JOptionPane.QUESTION_MESSAGE);
                    if (adminPasswordInput == null) {
                    	break;
                    }

                    if (adminUsernameInput.equals(a.getAdminUsername()) && adminPasswordInput.equals(a.getAdminPassword())) {
                        JOptionPane.showMessageDialog(null, "Access Granted! Welcome, Admin 🍎", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                        adminLogin = true;
//ADMIN MENU METHOD-----------------
                         AdminMenu.options(); 
                        exitProgram = true;
                    } else {
                        String[] wrongInputEscape = {"Try Again", "Back to Start"};
                        int wrongInputChoice = JOptionPane.showOptionDialog(null, "Incorrect username or password.\nPlease try again:", "Admin Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, wrongInputEscape, wrongInputEscape[0]);
                        if (wrongInputChoice == 1 || wrongInputChoice == JOptionPane.CLOSED_OPTION) break;
                    }
                }
            } 
            
            //1=CUSTOMER
            else if (loginChoice == 1) {

                String[] customerLoginMenu = {"Login", "Sign Up", "Back"};
                int cLoginMenuChoice = JOptionPane.showOptionDialog(null, "Select an option:", "Customer Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, customerLoginMenu, customerLoginMenu[0]);
                
                //2=BACK
                if (cLoginMenuChoice == 2 || cLoginMenuChoice == JOptionPane.CLOSED_OPTION) {
                    continue;
                }
                
                //0=LOGIN
                else if (cLoginMenuChoice == 0) {

                    boolean customerLogin = false;

                    while (!customerLogin) {

                        String customerUsernameInput = JOptionPane.showInputDialog("Customer Username:");
                        if (customerUsernameInput == null) {
                        	break;
                        }

                        String customerPasswordInput = JOptionPane.showInputDialog("Customer Password:");
                        if (customerPasswordInput == null) {
                        	break;
                        }

                        activeCustomer = customerUsernameInput;

                        	boolean customerFound = false;

                        for (int i = 0; i < Customer.customerCount; i++) {
                            Customer c = Customer.customers[i];
                            if (c.getUsername().equals(customerUsernameInput) && c.getPassword().equals(customerPasswordInput)) {
                                customerFound = true;
                                break;
                            }
                        }

                        if (customerFound) {
                            JOptionPane.showMessageDialog(null, "Access Granted! Welcome, " + activeCustomer + " 🍎");
                            customerLogin = true;
//CUSTOMER MENU METHOD ------------------
                            CustomerMenu.options();
                            exitProgram = true;
                        } else {
                            String[] wrongInputEscape = {"Try Again", "Back to Start"};
                            int wrongInputChoice = JOptionPane.showOptionDialog(null, "Incorrect username or password.\nPlease try again:", "Customer Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, wrongInputEscape, wrongInputEscape[0]);
                            if (wrongInputChoice == 1 || wrongInputChoice == JOptionPane.CLOSED_OPTION) break;
                        }
                    }

                } 
                //1=SIGNUP
                else if (cLoginMenuChoice == 1) {

                    if (Customer.customerCount >= Customer.customers.length) {
                        JOptionPane.showMessageDialog(null, "Customer limit reached. Cannot register more.");
                        continue;
                    }

                    //Email
                    String newEmail = JOptionPane.showInputDialog("Enter email:");
                    if (newEmail == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Cancel registration?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) continue;
                        }
                    
                    
                    if (newEmail.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error: Please enter a valid email address.");
                        continue;
                        }

                    //Name
                    String newCustomer = JOptionPane.showInputDialog("Enter full name:");
                    if (newCustomer == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Cancel registration?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) continue;

                    }
                    if (newCustomer.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error: Please enter a valid name.");
                        continue;
                    }

                    //Username
                    String newUser = JOptionPane.showInputDialog("Enter new username:");
                    if (newUser == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Cancel registration?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) continue;
                    }
                    if (newUser.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error: Please enter a valid username.");
                        continue;
                    }

                    //Password
                    String newPass = JOptionPane.showInputDialog("Enter new password:");
                    if (newPass == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Cancel registration?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) continue;
                    }
                    if (newPass.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error: Please enter a valid password.");
                        continue;
                    }

                    //Check for existing username - Calls method 
                    boolean usernameTaken = Customer.usernameExists(newUser);

                    if (usernameTaken) {
                        JOptionPane.showMessageDialog(null, "Username already exists. Please choose another.");
                    } else {
                        Customer.customers[Customer.customerCount] = new Customer(newCustomer, newEmail, newUser, newPass);
                        Customer.customerCount++;
                        JOptionPane.showMessageDialog(null, "Sign-up successful! You can now log in as " + newUser);
                    }
                }
            }
        }
    }
}


