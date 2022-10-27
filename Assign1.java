//Yewon Kim
//Assignment 1
//Completed on 9/8/2022

import java.util.*;

// The program calculates the heat index based on the temperature and relative humidity entered by the user.
public class Assign1 {
	// Main method
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);	
		
		double mor_heatIndex, noon_heatIndex, after_heatIndex;		// heat index in the morning, noon, and afternoon 
		String cityname;											// city name
		int mor_temp, mor_hum;										// morning - temperature and relative humidity 
		int noon_temp, noon_hum;									// noon - temperature and relative humidity 
		int after_temp, after_hum;									// afternoon - temperature and relative humidity 
		
		// Initialize each variable to 0
		mor_temp = 0;
		mor_hum = 0;
		noon_temp = 0; 
		noon_hum = 0;
		after_temp = 0;
		after_hum = 0;
		
		// introduce the program & conditions for calculating
		System.out.println("** Hello This is a Heat Index Calculator **\n");		
		System.out.println("-----------------------------------------"); 
		System.out.println("	    <Condition>"); 
		System.out.println("Temperatures should be 80°F or higher\n" 
				+"Relative humidity should be 40% or more.");
		System.out.println("-----------------------------------------\n"); 
		
		// assign the cityname by the user input
		System.out.printf("Please input the name of the city: ");
		cityname = keyboard.next();
		
		// assign the temperature and relative humidity in the morning by the user input
		System.out.println("Please input the morning Temperature (°F)");
		try {
			mor_temp = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}
		
		System.out.println("Please input the morning Relative humidity (%)");
		try {
			mor_hum = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}
		
		// verify that the user's input value in morning can be calculated as a heat index
		if(mor_temp < 80 || mor_hum < 40) {		
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the morning are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the morning. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		// assign the temperature and relative humidity in the noon by the user input
		System.out.println("Please input the noon Temperature (°F)");
		try {
			noon_temp = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}
		
		System.out.println("Please input the noon Relative humidity (%)");
		try {
			noon_hum = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}		
		
		// verify that the user's input value in noon can be calculated as a heat index
		if(noon_temp < 80 || noon_hum < 40) {		
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the noon are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the noon. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		// assign the temperature and relative humidity in the afternoon by the user input
		System.out.println("Please input the afternoon Temperature (°F)");	
		try {
			after_temp = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}
		
		System.out.println("Please input the afternoon Relative humidity (%)");
		try {
			after_hum = keyboard.nextInt();
		} catch(InputMismatchException ime){	// If user does not input an integer variable -> exception
			System.out.println("\n**An exception occurred.**");
			System.out.println("You should input an integer variable.");
			System.exit(0);
		}
		
		// verify that the user's input value in afternoon can be calculated as a heat index
		if(after_temp < 80 || after_hum < 40) {	
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the afternoon are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the afternoon. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		// compute the heat index in the morning
		mor_heatIndex = 
				(-42.379) + 2.04901523*mor_temp + 10.14333127*mor_hum 
				+ (-0.22475541)*mor_temp*mor_hum + (-0.00683783)*Math.pow(mor_temp, 2) 
				+ (-0.05481717)*Math.pow(mor_hum, 2) + 0.00122874*Math.pow(mor_temp, 2)*mor_hum 
				+ 0.00085282*mor_temp*Math.pow(mor_hum, 2) + (-0.00000199)*Math.pow(mor_temp, 2)*Math.pow(mor_hum, 2);
		
		// compute the heat index in the noon
		noon_heatIndex = 
				(-42.379) + 2.04901523*noon_temp + 10.14333127*noon_hum 
				+ (-0.22475541)*noon_temp*noon_hum + (-0.00683783)*Math.pow(noon_temp, 2) 
				+ (-0.05481717)*Math.pow(noon_hum, 2) + 0.00122874*Math.pow(noon_temp, 2)*noon_hum 
				+ 0.00085282*noon_temp*Math.pow(noon_hum, 2) + (-0.00000199)*Math.pow(noon_temp, 2)*Math.pow(noon_hum, 2);
		
		// compute the heat index in the afternoon
		after_heatIndex = 
				(-42.379) + 2.04901523*after_temp + 10.14333127*after_hum 
				+ (-0.22475541)*after_temp*after_hum + (-0.00683783)*Math.pow(after_temp, 2) 
				+ (-0.05481717)*Math.pow(after_hum, 2) + 0.00122874*Math.pow(after_temp, 2)*after_hum 
				+ 0.00085282*after_temp*Math.pow(after_hum, 2) + (-0.00000199)*Math.pow(after_temp, 2)*Math.pow(after_hum, 2);
				
		// display results (table)
		System.out.println(" \n_________________________ " + cityname + " _________________________");
		System.out.println("|  Time of Day  |  Temperature  |  Humidity  |  Heat Index  |");
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|    Morning    |  %7d      |  %5d     |     %.1f    |\n", mor_temp, mor_hum, mor_heatIndex);		
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|     Noon      |  %7d      |  %5d     |     %.1f    |\n", noon_temp, noon_hum, noon_heatIndex);
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|   Afternoon   |  %7d      |  %5d     |     %.1f    |\n", after_temp, after_hum, after_heatIndex);
		System.out.println(" ___________________________________________________________");
		
		
	}	// end of main method
}	// end of class
