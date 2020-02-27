import java.util.*;
public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba = new BankAccount("Nivesh", "25786");
		int choice;
		do
		{
			ba.showMessage();
			System.out.println("->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<-");
			switch(choice)
			{
			case 1:System.out.println("***************************************");
				ba.checkBalance();
				System.out.println("***************************************");
				break;
			case 2: int amount;
			System.out.println("***************************************");
				System.out.println("Enter amount to be deposited : ");
				amount = scan.nextInt();
				System.out.println("-----------------------------------------");
				ba.deposit(amount);
				System.out.println("-----------------------------------------");
				System.out.println("***************************************");
				break;
			case 3:int withdraw;
			System.out.println("***************************************");
				System.out.println("Enter amount to be deposited : ");
				withdraw = scan.nextInt();
				System.out.println("-----------------------------------------");
				ba.withdraw(withdraw);
				System.out.println("-----------------------------------------");
				System.out.println("***************************************");
				break;
			case 4:System.out.println("-----------------------------------------");
				ba.previousTrans();
				System.out.println("-----------------------------------------");
				break;
			case 5:System.exit(0);
			default: System.out.println("Wrong input");
				break;
			}
		}while(choice!=5);

	}

}

class BankAccount
{
	int balance;
	int prevTransaction;
	String CustomerName;
	String CustomerID;
	
	BankAccount(String cname, String cid)
	{
		CustomerName = cname;
		CustomerID = cid;
	}
	
	void deposit(int amount)
	{
		if(amount !=0)
		{
			balance += amount;
			prevTransaction = amount;
			System.out.println("An amount of $" + amount + " has been deposited.");
		}
	}
	void withdraw(int amount)
	{
		if(amount > balance)
		{
			System.out.println("You have entered amount greater than balance.");
			System.out.println("So You can not withdraw money");
		}
		else if(amount!=0)
		{
			balance -= amount;
			prevTransaction = -amount;
			System.out.println("An amount of $" + amount + " has been withdrawn.");
		}
	}
	void checkBalance()
	{
		System.out.println("Current Balance is $" + balance + ".");
	}
	void previousTrans()
	{
		if(prevTransaction>0)
		{
			System.out.println("Deposited an amount of $" + prevTransaction +".");
		}
		else if(prevTransaction < 0)
		{
			System.out.println("Withdrawn an amount of $" + Math.abs(prevTransaction) +".");
		}
		else
		{
			System.out.println("No transaction has occured.");
		}
	}
	void showMessage()
	{
		System.out.println("Welcome Mr. " + CustomerName +".");
		System.out.println("Your ID is " + CustomerID + ".");
		System.out.println("Choose one of the options below");
		System.out.println("1. Check Balance.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Check Previous Transaction.");
		System.out.println("5. Exit.");
	}
}
