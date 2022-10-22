import java.util.*;
import javax.swing.*;

/*
 * Application that SimlateS an ATM Machine. When you start the program, the application must request you to
 * enter your four-digit pin number. If the pin number is not four digits long, the user is given two more chances to enter a valid pin number. If after two chances
 * the user fails, the program ends; but if the pin is valid, the user is given transaction options to choose from, namely b for checking current balance, d for
 * depositing money, w for withdrawing money and e for exiting the program. If the user enters b, the current balance is shown. If the user enters d, the user
 * is given a option to enter the amount he/she wishes to deposit and update the balance with this amount. If the user enters a w, the user is given a chance to enter the amount he/she
 * wishes to withdraw. If the withdrawal amount is greater than the current balance, an error message will be displayed. If the user enters an e, the application will exit.
 * the application will execute continuously as long as the user wants to. Lastly, the user of the application is assigned 1111 as a default pin at the beginning of
 * the program. This pin will be compared once against the user entered pin before the transaction options can be given to the user. If the user enters 1111,
 * the program will proceed to show the user the available options, otherwise two chances are to be given for the user to enter the match. Also, the starting balance is R1000.00.
 */

public class AtmSimulation
{
	public static boolean isPinCorrect(int pin)
	{
		boolean isPinValid = false;

		 if((((pin / 1000) > 0) && ((pin / 1000) < 10)) && (pin == 1111))
		 {
			 isPinValid = true;
		 }
		 return isPinValid;
	}

	public static int pinMenu()
	{
		int pin;

		pin = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your pin: ", "Pin", JOptionPane.INFORMATION_MESSAGE));

		return pin;
	}

	public static char menu()
	{
		char option;

		  option = (JOptionPane.showInputDialog(null, "Welcome to ABC bank. Choose one of the following services: " + "\n" +  "--------------------------------------------------------------------------------------" + "\n" +  "D or d ----> to deposit money" + "\n" + "W or w ----> to withdraw money" + "\n" + "B or b ----> to check your balance" + "\n" + "E or e ----> to exit", "ABC bank services", JOptionPane.INFORMATION_MESSAGE)).charAt(0);

		  return option;
	}

	public static void main(String[] args)
	{
		 char option;
		 double amount;
		 double balance = 1000.00;
		 boolean isPinValid = false;
		 int noOfChances = 0;
		 int pin;

		 do
		 {
			 //--> prompt for the pin
			 pin = pinMenu();

			 //--> check if the pin is correct
			 if(isPinCorrect(pin))
			 {
				 isPinValid = true;
			 }
			 else
			 {
				JOptionPane.showMessageDialog(null, "Invalid pin. Please enter a valid pin", "Invalid pin", JOptionPane.ERROR_MESSAGE);

				noOfChances ++;
			 }
		 }
		 while((!isPinValid) && (noOfChances < 3));


		 //--> check the reason why the above loop terminated
		 if(isPinValid)
		 {
			 //--> show user options
			 option = menu();

			 //--> iterate whilst the user wants to
			 while((option != 'E') && (option != 'e'))
			 {
				 //--> switch according to the user's option
				 switch(option)
				 {
					case 'B':
					case 'b':
						 JOptionPane.showMessageDialog(null, "Your balance is R" + balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
						 break;
					case 'D':
					case 'd':
						amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the amount to deposit", "Deposit", JOptionPane.INFORMATION_MESSAGE));
						balance = balance + amount;
						break;
					case 'W':
					case 'w':
						 amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the amount to withdraw", "Withdraw",  JOptionPane.INFORMATION_MESSAGE));
						 if(amount < balance)
						 {
							 balance = balance - amount; 
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null, "Insufficient funds", "No enough money", JOptionPane.ERROR_MESSAGE);
						 }
						 break;
				         default:
						 JOptionPane.showMessageDialog(null, "Invalid code entered. Please enter either B/b, D/d, W/w or E/e.", "Invalid code", JOptionPane.ERROR_MESSAGE);
																																																																							 								 JOptionPane.showMessageDialog(null, "Insufficient fun																																																																 							JOptionPane.showMessageDialog(null, "Invalid code entered. Please enter either B/b, D/d, W/w or E/e.", "Invalid code", JOptionPane.ERROR_MESSAGE);
				 }

			 }

			 //--> ask again
			 option = menu();
		 }
		 JOptionPane.showMessageDialog(null, "GoodBye", "End of program", JOptionPane.INFORMATION_MESSAGE);

	}
}
