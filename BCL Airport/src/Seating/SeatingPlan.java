package Seating;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Flights.FilteredFlights;
import Seating.Flight;

@SuppressWarnings("unused")
public class SeatingPlan {
	
	// Variable objects storing the selected departure and return flights using the Flight class
	static Flight selectedDFlight = new Flight();
	static Flight selectedRFlight = new Flight();
	
	// Variable for storing the currently selected number of tickets
	
	
	static Integer numTickets = 3;
	
	// Selected seats for departure and return flights
	static ArrayList<String> selectedDSeats = new ArrayList<String>();
	static ArrayList<String> selectedRSeats = new ArrayList<String>();
	
	// Currently selected seats
	static ArrayList<String> selectedSeats = new ArrayList<String>();
	
	
	/**
	 *  Method for getting the selected flight for the specified booking.
	 */
	public static Flight getSelectedFlight(String bookingType) {
		Flight selectedFlight = null;
		
		if (bookingType.toLowerCase() == "departure" || bookingType.toLowerCase() == "d") {
			selectedDFlight.dateOfFlight = "08/03/2022";
			selectedDFlight.departureTime = "06:20";
			selectedDFlight.arrivalTime = "11:57";
			selectedDFlight.flightDuration = "05:37";
			selectedDFlight.distanceTravelled = 7021.04;
			selectedDFlight.delay = 179;
			selectedDFlight.departureAirport = "HND";
			selectedDFlight.departureCity = "Tokyo";
			selectedDFlight.arrivalAirport = "SYD";
			selectedDFlight.arrivalCity = "Sydney";
			selectedDFlight.flightNumber = "TS4977";
			selectedDFlight.airline = "Easyplane";
			selectedFlight = selectedDFlight;
			
		} else if (bookingType.toLowerCase() == "return" || bookingType.toLowerCase() == "r") {
			selectedRFlight.dateOfFlight = "27/03/2022";
			selectedRFlight.departureTime = "18:23";
			selectedRFlight.arrivalTime = "03:44";
			selectedRFlight.flightDuration = "09:21";
			selectedRFlight.distanceTravelled = 11687.85;
			selectedRFlight.delay = 10;
			selectedRFlight.departureAirport = "SYD";
			selectedRFlight.departureCity = "Sydney";
			selectedRFlight.arrivalAirport = "HND";
			selectedRFlight.arrivalCity = "Tokyo";
			selectedRFlight.flightNumber = "ST4138";
			selectedRFlight.airline = "Eastair";
			selectedFlight = selectedRFlight;
		}
		
		return selectedFlight;
	}
	
	
	/**
	 *  Method for converting a String HH:MM value to an Integer in minutes only.
	 */
	public static Integer convertToMin(String time) {
		String[] hourMins = time.split(":");
		Integer totalMins = (Integer.parseInt(hourMins[0]) * 60) + Integer.parseInt(hourMins[1]);
		return totalMins;
	}
	
	
	/**
	 *  Method for getting the model of the plane based on the selected flight's duration.
	 */
	public static String getPlaneModel(String flightDuration) {
		String planeModel;
		if (convertToMin(flightDuration) > 120) {
			planeModel = "Boeing 747";
		} else {
			planeModel = "Airbus A318";
		}
		return planeModel;
	}
	
	
	/**
	 * Method for getting selected seats for a specified booking type - departure/return.
	 */
	public ArrayList<String> getSelectedSeats(String bookingType) {
		ArrayList<String> seats = null;
		
		if (bookingType.toLowerCase() == "departure" || bookingType.toLowerCase() == "d") {
			seats = selectedDSeats;
		} else if (bookingType.toLowerCase() == "return" || bookingType.toLowerCase() == "r") {
			seats = selectedRSeats;
		}
		
		return seats;
	}
	
	
	/**
	 * Method for writing selected seats for a specified flightNumber to a data storage.
	 */
	public static void updateSeating() throws IOException {
		
		// Create a write handle and buffered writer for the CSV file
		FileWriter writehandle = new FileWriter("booked_seats.csv", true);
		BufferedWriter bw = new BufferedWriter(writehandle);
		
		// Loop through the array of selected seats and write their flight numbers, seat number and flight type into the file
		for (int i = 0; i < selectedDSeats.size(); ++i) {
			String line1 = selectedDFlight.flightNumber + "," + selectedDSeats.get(i) + ",Departure" + ",Hello World!";
			String line2 = selectedRFlight.flightNumber + "," + selectedRSeats.get(i) + ",Return" + ",Hello World!";
		    bw.write(line1);
		    bw.newLine();
		    bw.write(line2);
		    bw.newLine();
		}
		
		// Close the write handle and buffered writer
		bw.close();
		writehandle.close();
	}
	
	
	/** 
	 * Method for retrieving booked seats for a specified flightNumber.
	 */
	public static ArrayList<String> getSeating(String flightNumber) throws IOException {
		ArrayList<String> bookedSeats = new ArrayList<String>();
		
		// If the CSV file does not already exist, return the (empty) bookedSeats ArrayList
		File f = new File("booked_seats.csv");
		if (!f.exists()) return bookedSeats;
		
		// Create a read handle and buffered reader for the CSV file
		FileReader readhandle = new FileReader("booked_seats.csv");
		BufferedReader br = new BufferedReader(readhandle);
		
		// Loop through the file as long as the read line is not empty
		String line = null;
		while ((line = br.readLine()) != null) {
			
			// Create an array of values split at the line at a comma
			String[] column = line.split(",");
			
			// If the flight number passed through the method is equal to the flight number in the file at the current line,
			// add the value of the column to its right (seat number) into the bookedSeats ArrayList.
			if (flightNumber.equals(column[0])) {
				bookedSeats.add(column[1]);
				
			}
		}
		// Closed the read handle and buffered reader
		br.close();
		readhandle.close();
		
		// Return the booked seats
		return bookedSeats;
	}
	
	
	/**
	 * Method for calculating the maximum amount of tickets a user can select up to for both departure and return flight.
	 */
	public static Integer calculateMaxTickets() {
		
		// Get selected departure and return flights' information
		Flight selectedDFlight = getSelectedFlight("d");
		Flight selectedRFlight = getSelectedFlight("r");
		
		// Get plane models for departure and return flights
		String modelD = getPlaneModel(selectedDFlight.flightDuration);
		String modelR = getPlaneModel(selectedRFlight.flightDuration);
		
		// Initialise and assign variables containing maximum seat capacity value based on the plane model
		int dMaxSeats = (modelD == "Boeing 747") ? 84 : 64;
		int rMaxSeats = (modelR == "Boeing 747") ? 84 : 64;
		
		// Get number of occupied seats for each flight
		int numOccupiedDSeats = 0, numOccupiedRSeats = 0;
		try {
			numOccupiedDSeats = getSeating(selectedDFlight.flightNumber).size();
			numOccupiedRSeats = getSeating(selectedRFlight.flightNumber).size();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Calculate the available number of seats for each flight
		int availableD = dMaxSeats - numOccupiedDSeats;
		int availableR = rMaxSeats - numOccupiedRSeats;
		
		// Calculate which flight has the least seats and assign its value to the leastSeats variable
		int leastSeats = (availableD < availableR) ? availableD : availableR;
		
		// Return the value of leastSeats
		return leastSeats;
	}
	
}
