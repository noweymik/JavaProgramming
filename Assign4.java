//Yewon Kim
//Assignment 4
//Completed on 9/28/2022

import java.util.*;

// The program calculates the heat index based on the temperature and relative humidity entered by the user.
public class Assign4 {
	
	// Main method
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);	
		 
		// city name
		String cityname;	
		
		// 'morning' 	temperature : tempAndNum[0][0], humidity : tempAndNum[0][1]
		// 'noon' 		temperature : tempAndNum[1][0], humidity : tempAndNum[1][1]
		// 'afternoon'  temperature : tempAndNum[2][0], humidity : tempAndNum[2][1]
		int[][] tempAndHum = new int[3][2];		
		
		// heat index in the morning, noon, and afternoon
		double[] heatIndex = new double[3];							
		
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
		tempAndHum[0][0] = keyboard.nextInt();
		
		System.out.println("Please input the morning Relative humidity (%)");
		tempAndHum[0][1] = keyboard.nextInt();
		
		// verify that the user's input value in morning can be calculated as a heat index
		if(tempAndHum[0][0] < 80 || tempAndHum[0][1] < 40) {		
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the morning are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the morning. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		// assign the temperature and relative humidity in the noon by the user input
		System.out.println("Please input the noon Temperature (°F)");
		tempAndHum[1][0] = keyboard.nextInt();
				
		System.out.println("Please input the noon Relative humidity (%)");
		tempAndHum[1][1] = keyboard.nextInt();		
		
		
		// verify that the user's input value in noon can be calculated as a heat index
		if(tempAndHum[1][0] < 80 || tempAndHum[1][1] < 40) {		
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the noon are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the noon. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		// assign the temperature and relative humidity in the afternoon by the user input
		System.out.println("Please input the afternoon Temperature (°F)");	
		tempAndHum[2][0] = keyboard.nextInt();
				
		System.out.println("Please input the afternoon Relative humidity (%)");
		tempAndHum[2][1] = keyboard.nextInt();
		
		
		// verify that the user's input value in afternoon can be calculated as a heat index
		if(tempAndHum[2][0] < 80 || tempAndHum[2][1] < 40) {	
			// display the message that the user did not input computable temperature and relative humidity.
			System.out.println("\nTemperature and Relative humidity in the afternoon are not satisfied the conditions.\n" +
					"So we can not calculate the heat index in the afternoon. :(");
			System.out.println("** Good bye! **");
			System.exit(0);
		}
		
		
		// compute the heat index in the morning
		heatIndex[0] = calHeatIndex(tempAndHum[0][0], tempAndHum[0][1]);
		
		// compute the heat index in the noon 
		heatIndex[1] = calHeatIndex(tempAndHum[1][0], tempAndHum[1][1]);
				
		// compute the heat index in the afternoon  
		heatIndex[2] = calHeatIndex(tempAndHum[2][0], tempAndHum[2][1]);
				
		// display results (table)
		System.out.println(" \n_________________________ " + cityname + " _________________________");
		System.out.println("|  Time of Day  |  Temperature  |  Humidity  |  Heat Index  |");
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|    Morning    |  %7d      |  %5d     |     %.1f    |\n", tempAndHum[0][0], tempAndHum[0][1], heatIndex[0]);		
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|     Noon      |  %7d      |  %5d     |     %.1f    |\n", tempAndHum[1][0], tempAndHum[1][1], heatIndex[1]);
		System.out.println(" ___________________________________________________________");
		
		System.out.printf("|   Afternoon   |  %7d      |  %5d     |     %.1f    |\n", tempAndHum[2][0], tempAndHum[2][1], heatIndex[2]);
		System.out.println(" ___________________________________________________________");
		
		
	}	// end of main method
	
	// Calculate heat index method
	public static double calHeatIndex(int temp, int hum) {
		double heatIndex;
		heatIndex = 
				(-42.379) + 2.04901523*temp + 10.14333127*hum 
				+ (-0.22475541)*temp*hum + (-0.00683783)*Math.pow(temp, 2) 
				+ (-0.05481717)*Math.pow(hum, 2) + 0.00122874*Math.pow(temp, 2)*hum
				+ 0.00085282*temp*Math.pow(hum, 2) + (-0.00000199)*Math.pow(temp, 2)*Math.pow(hum, 2);
		
		return heatIndex;		
	} // end of calHeatIndex method
}	// end of class
