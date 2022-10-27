//Yewon Kim
//Assignment 3 - revised
//Completed on 9/27/2022

import java.util.*;

// This program will calculate how long it will take to pay off the credit card balance that depends on the menu
public class Assign3 {
	// Main method
	public static void main(String[] args) {
		int menu;						// option number
		double balance;					// balance that the user will input
		double totalCharge;				// the total of the finance charges the user paid
		double monthly_amount;			// it depends on the menu
		double interest;				// interest that the user will input (a percentage or a decimal number)
		double financeCharge;			
		int extraDollar;				// using for menu 3
		int time;						// the number of years and months that it will take to pay off the debt
		String execute;					// for checking if the user wants to end or continues the program 
		int year;						// for displaying results (years)
		int month;						// for displaying results (months)
		
		Scanner keyboard = new Scanner(System.in);
				
		while(true) {
			System.out.println("- Payment menu -");
			
			System.out.println("(1) pay just the minimum payment");
			System.out.println("(2) pay at least twice the minimum payment");
			System.out.println("(3) pay at least the minimum + entered in dollar amount\n\n");
			
			System.out.println("Please select the menu (enter the number of menu) : ");
			menu = keyboard.nextInt();
						 
			System.out.println("Please input the balance : ");
			balance = keyboard.nextDouble();
			
			System.out.println("Please input the interest :");
			interest = keyboard.nextDouble();

			// if the user inputs a percentage (ex 15), we divide by 100
			// else we assume that the user inputs a decimal number (ex 0.15)
			if(interest >= 1) {
				interest = interest / 100;			
			}
			
			time = 0;					// calculate the payoff time
			totalCharge = 0;			// starts at 0 (not paid anything yet)
			extraDollar = 0; 			// this is only for menu 3
			
			// menu 1) the minimum payment
			if(menu == 1) {
				while(balance > 0.0049) { 
					time = time + 1;
					monthly_amount = balance * 0.02;
					financeCharge = balance * (interest/12);
					
					balance = balance - monthly_amount + financeCharge;
					totalCharge = totalCharge + financeCharge;
				}
			}
			// menu 2) twice the minimum payment
			else if(menu == 2) {
				while(balance > 0.0049) {
					time = time + 1;
					monthly_amount = balance * 0.02 * 2;					
					financeCharge = balance * (interest/12);
					
					balance = balance - monthly_amount + financeCharge;
					totalCharge = totalCharge + financeCharge;
				}
			}
			// menu 3) the minimum + entered in dollar amount
			else if(menu == 3) {			
				System.out.println("\nPlease enter an extra dollar amount to pay each month : ");
				extraDollar = keyboard.nextInt();
				while(balance > 0.0049) {
					time = time + 1;
					monthly_amount = balance * 0.02  + extraDollar;
					financeCharge = balance * (interest/12);
					
					balance = balance - monthly_amount + financeCharge;
					totalCharge = totalCharge + financeCharge;
				}
			}
			
			//calculate years and months
			year = time / 12;
			month = time % 12;
			
			// display result
			System.out.println("\n\n********************************\n");
			if(menu == 1) System.out.println("If you pay the minimum:");
			else if(menu == 2) System.out.println("If you pay twice the minimum:");
			else if(menu == 3) System.out.printf("If you pay the minimum + $%d:\n", extraDollar);
			
			System.out.printf("Payoff time... %d years and %d months\n", year, month);
					
			System.out.printf("Total Finance Charges... $%.2f\n", totalCharge);
			System.out.println("\n********************************\n");
						
			// ask if the user wants to end or continues the program
			System.out.printf("If you want to exit this program, "
					+ "\nplease press 'q' (Otherwise -> continue) : ");
			execute = keyboard.next();
						
			// if the user inputs "q" or "Q", stop the program
			if(execute.compareTo("q")==0 || execute.compareTo("Q")==0) break;
		}
		
		// show the ending message
		System.out.println("\nEnd...");
	}	// end of main method 
}	// end of class