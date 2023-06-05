/**
* @ Himanshu Mude
**/

import java.text.NumberFormat; // Helps with formatting doubles as currency
import java.util.Scanner; 


public class ATM_Interface {
	
    public static void main(String[] args) {
	
		// Create and instantiate two Account objects

		Account checking = new Account();
		checking.setType("Checking");
		checking.setBalance(0.00);
		checking.setRate(0.00);

		Account savings = new Account();
		savings.setType("Savings");
		savings.setBalance(0.00);
		savings.setRate(2.00);

		NumberFormat formatter = NumberFormat.getCurrencyInstance(); // Creates the formatter object for currency
		try (Scanner sc = new Scanner(System.in)) {
            boolean session = true; // This variable will break the (while) loop when false

            int id, pass;

            System.out.print("Enter User-ID: ");
            id= sc.nextInt();
            System.out.print("Enter User-Password: ");
            pass= sc.nextInt();
            System.out.println();
            if(id==777 && pass==12345)
            {
                while (session) {

                    System.out.print("\nATM Menu: \n \n"
                                     + "1. Transaction History \n"
                                     + "2. Withdraw  \n"
                                     + "3. Deposit \n"
                                     + "4. Transfer\n"
                                     + "5. QUIT\n \n"
                                     + "Choose the Option: ");
   
                    int selection = sc.nextInt(); 
                   
                switch (selection) {

            		
                    case 1:
            			System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
            			System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
            			
            			break;

                    case 2:
            			System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
            			int witAccount = sc.nextInt(); // Keeps track of which account to withdraw from

            			if (witAccount == 1) {

            				System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

            				System.out.println("How much money would you like to withdraw?");
            				double withdraw = sc.nextDouble();

            				savings.withdraw(withdraw);

            				System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
            				

            			}

            			else if (witAccount == 2) {
            				
            				System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

            				System.out.println("How much money would you like to withdraw?");
            				double withdraw = sc.nextDouble();

            				checking.withdraw(withdraw);

            				System.out.println("\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");

            			}

            			break;    

            		case 3:
            			System.out.print("Enter (1) for Savings or (2) for Checking: ");
            			int depAccount = sc.nextInt(); // Keeps track of which account to deposit money to

            			if (depAccount == 1) {

            				System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

            				System.out.println("How much money would you like to deposit?");
            				double deposit = sc.nextDouble();

            				savings.deposit(deposit);

            				System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
            				

            			}

            			else if (depAccount == 2) {
            				
            				System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

            				System.out.println("How much money would you like to deposit?");
            				double deposit = sc.nextDouble();

            				checking.deposit(deposit);

            				System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");

            			}

            			break;


            		case 4:
            			System.out.print("\nFrom which account do you wish to transfer funds from?, (1) for Savings or (2) for Checking: ");
            			int tranAccount = sc.nextInt();

            			if (tranAccount == 1) {

            				System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

            				System.out.print("How much money do you wish to transfer from Savings to Checking?: ");
            				double tranAmount = sc.nextDouble();

            				savings.withdraw(tranAmount);
            				checking.deposit(tranAmount);

            				System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");

            				System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
            				System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

            			}

            			else if (tranAccount == 2) {

            				System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

            				System.out.print("How much money do you wish to transfer from Checking to Saving?: ");
            				double tranAmount = sc.nextDouble();

            				checking.withdraw(tranAmount);
            				savings.deposit(tranAmount);

            				System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");

            				System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
            				System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
            				
            			}

            			break;


            		case 5:
            			session = false;
            			
            			break;

            	}				 	
            	
            }

            System.out.println("\nThank you for banking with us!\n");

}
   else 
   {
            System.out.println("Please Enter Correct ID and Password");
   }
        }
        
    }
 
}


class Account {


	String type;
	double balance;
	double rate;

	// The following methods are a combination of getter/setter methods as well
	// as two special deposit() and withdraw() methods

	void setType(String accType) {
		
		type = accType;
	}

	void setBalance(double accBal) {
		
		balance = accBal;
	}

	void setRate(double accRate) {
		
		rate = accRate;
	}

	void deposit(double dep) {
		
		balance += dep; // Take the Account object's balance and add to it the current deposit
	}

	void withdraw(double wit) {
		
		balance -= wit; // Take the Account object's balance and subtract from it the current withdrawal
	}


	String getType() {
		
		return type;
	}

	double getBalance() {
		
		return balance;
	}

	double getRate() {
		
		return rate;
	}

}