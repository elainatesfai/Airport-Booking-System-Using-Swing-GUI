package Arrivals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {

	public static ArrayList <String> flightdata = new ArrayList<String>(); //creates an array list for for all fight data taken from the flights.csv file
	public static ArrayList <String> delays = new ArrayList<String>(); // creates an array list for all delays
	public static ArrayList <String> LDN = new ArrayList<String>(); //creates an array list for all arrivals to BCL airport
	public static ArrayList <String> DUB = new ArrayList<String>(); 
	public static ArrayList <String> AMS = new ArrayList<String>();
	public static ArrayList <String> CDG = new ArrayList<String>(); 
	private static File csvFile;

	public static void mainin() throws IOException {
		
		csvFile = new File("Resources/Flights.csv"); //csv file path location
		BufferedReader br = new BufferedReader(new FileReader(csvFile)); //passes file to the buffered reader 
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				String[] count = line.split(",");
				flightdata.add(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[10]+" "+count[11]); //prints the columns that I need 
				String check= count[6];
				String check1 = count [5];
			
			if(Integer.parseInt(check1) > 30) {
				
				delays.add(count[1]+" "+count[2]+" "+count[5]+" "+count[6]+" "+count[8]+" "+count[11]); } //the delays tab will show Departure time, arrival time, delay (minutes), departure airport, arrival airport and airline 
			
				
				if (check.equals("BCL")) {
					LDN.add(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[10]+" "+count[11]); // the arrival airport info will show date of flight, departure time, arrival time, flight distance, distance travelled, delay (minutes), departure airport, Departue City, flight number and airline.
				}
				if (check.equals("DUB")) {
					DUB.add(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[10]+" "+count[11]);
				}
				if (check.equals("AMS")) {
					DUB.add(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[10]+" "+count[11]);
				}
				if (check.equals("CDG")) {
					DUB.add(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[10]+" "+count[11]); 
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	} }
	
	
	


