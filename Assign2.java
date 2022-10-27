//Yewon Kim
//Assignment 2
//Completed on 9/16/2022

import java.util.*;

// The program got the students name, and also program got the major and status by 2 characters, then show the results 
public class Assign2 {
	// Main method
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int studentNum;					// the number of the students
		String studName;				// student name
		String majorAndStatus;			// major and status (Ex E3)
		char majorChar;					// major character (Ex M or E or C)
		char statusChar;				// status character (Ex 1~4)
		int whiteSpaceIndex;			// index of whitespace (-1 == there's no white space)
		char firstName;					// left side of whitespace, first name
		char lastName;					// right side of whitespace, last name
		int invalid;					// invalid==0(false) : valid | invalid==1(true) : invalid
		String status;					// status (Freshmen or Sophomore or Junior or Senior)
		String major;					// major (Mathematics or Computer Science or Engineering)
		String Engineering;				// Engineering types (Mechanical or Civil or Electrical)
		char EnginType;					// one character - Engineering types (M or C or E)
		
		// Assign studentNum (the number of students)
		System.out.println("Please input the number of students");
		studentNum = keyboard.nextInt();		
		
		// iteration for as many as the number of students
		for(int i=0; i<studentNum; i++) {
			invalid = 0;	// invalid false
			
			do {
				keyboard.nextLine();	// Remove enter
				
				// Show menu
				System.out.println("\n      [Menu]\n");
				System.out.println("-Major");
				System.out.println(" M: Mathematics ");
				System.out.println(" C: Computer Science ");
				System.out.println(" E: Engineering (could be Mechanical, Civil or Electrical) ");
				System.out.println("\n-Status");
				System.out.println(" 1: Freshman");
				System.out.println(" 2: Sophomore");
				System.out.println(" 3: Junior");
				System.out.println(" 4: Senior");
				
				// Assign the studName(student name)
				System.out.printf("\nPlease input the student name : ");
				studName = keyboard.nextLine();
				
				// Find the first name initial and the last name initial
				// then make them in upper case  
				whiteSpaceIndex = studName.indexOf(' ');	// find whitespace index (if whiteSpaceIndex==-1 -> there's no whitespace)
				firstName = studName.charAt(0);
				lastName = studName.charAt(whiteSpaceIndex+1);
				firstName = Character.toUpperCase(firstName);
				lastName = Character.toUpperCase(lastName);
				
				// User inputs the major and status in 2 characters
				System.out.printf("Please input your major and status in two characters : ");
				majorAndStatus = keyboard.next();
				
				// check majorAndStatus is only 2 characters
				// if not 2 characters, show error message and make invalid value to true(1) 
				if(majorAndStatus.length()!=2) {
					System.out.println("**error** You should input two characters (ex C3)\n");
					invalid = 1;	
					continue;
				}
				
				// Assign the student's major and status
				majorChar = majorAndStatus.charAt(0);
				statusChar = majorAndStatus.charAt(1);
				
				// If major is not character or if status is not digit
				if(!Character.isLetter(majorChar) || !Character.isDigit(statusChar)) {
					System.out.println("**error** You should input one character(M or C or E) and a number character(1~4)\n");
					invalid = 1;
					continue;
				}
				// Check major value is valid or not
				// If the major is not 'M' and 'C' and 'E' -> it is not in options
				if(majorChar != 'M' && majorChar != 'C' && majorChar != 'E') {
					System.out.println("**error** Your major should be one of these characters(M or C or E)\n");
					invalid = 1;
					continue;
				}
				// Check status value is valid or not
				// If the status is not between 1 and 4 (1~4)
				if(statusChar < '1' || statusChar > '4') {
					System.out.println("**error** Your status should be a number character between 1 and 4\n");
					invalid = 1;
					continue;
				}
				
				// Assign status and major to null
				status = null;
				major = null;
				
				// Assign status to corresponding value 
				if(statusChar == '1') status = "Freshmen";
				else if(statusChar == '2') status = "Sophomore";
				else if(statusChar == '3') status = "Junior";
				else if(statusChar == '4') status = "Senior";
				
				// Assign major to corresponding value
				if(majorChar == 'M') major = "Mathematics";
				else if(majorChar == 'C') major = "Computer Science";
				else if(majorChar == 'E') {
					major = "Engineering";
					
					System.out.println("\nIf the student is engineering student....\n");
					
					// Show all engineering types
					System.out.println("  [Engineering major]");
					System.out.println(" M : Mechanical");
					System.out.println(" C : Civil");
					System.out.println(" E : Electrical");
					
					// The user inputs the type of engineering
					System.out.println("\nWhat type of engineering major? ");
					Engineering = keyboard.next();	
					
					// Engineering.length() should be 1
					if(Engineering.length()!=1) {
						System.out.println("**error** Your Engineering major should be one of 'M' or 'C' or 'E' (one character)\n");
						invalid = 1;	// invalid
						continue;		// go back to the top of do-while loop
					}
					
					// Assign EnginType
					EnginType = Engineering.charAt(0);		
					
					// If the user does not enter any of the three types
					if(EnginType!='M' && EnginType!='C' && EnginType!='E') {
						System.out.println("**error** Your Engineering major should be one of 'M' or 'C' or 'E'\n");
						invalid = 1;	// invalid
						continue;		// go back to the top of do-while loop 
					}
					else {	// if user does enter valid type
						// Assign Engineering string
						if(EnginType=='M') Engineering = "Mechanical";
						else if(EnginType=='C') Engineering = "Civil";
						else if(EnginType=='E') Engineering = "Electrical";
						
						if(whiteSpaceIndex != -1) {	// there's whitespace. (user inputs first name and last name)
							System.out.printf("\n%c%c is a %s %s (%s) major\n", firstName, lastName, status, major, Engineering);
						}
						else {	// there's no whitespace (user inputs only first name or last name)
							System.out.printf("\n%c is a %s %s (%s) major\n", firstName, status, major, Engineering);
						}
						System.out.println("\n----------------------------------------");
						break;	// break the do-while loop
					}
				}
				
				invalid = 0;	// == all inputs are valid
				
				// display results
				if(whiteSpaceIndex != -1) {
					System.out.printf("\n%c%c is a %s %s major\n", firstName, lastName, status, major);
				}
				else {
					System.out.printf("\n%c is a %s %s major\n", firstName, status, major);
				}
				System.out.println("\n----------------------------------------");
			} while(invalid != 0);	// if invalid == 0(valid), stop the while loop. (stop - it means the user's inputs are all valid) 
		
		}
		// ending message
		System.out.println("\n\nProgram is End..... \n");
	}
}

