package Flights;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Arrivals.Flight_Arrivals;
import Departures.Departures;
import Finances.Finances;
import Passengers.PassengersUI;
import Seating.SeatingPlanUI;
import javax.swing.JButton;

public class FilteredFlights extends JFrame {

	private JPanel contentPane;
	private JTable dFilteredFlights;
	private JTable rFilteredFlights;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilteredFlights frame = new FilteredFlights();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("null")
	public FilteredFlights() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for the calendars presented 
		setBounds(100, 100, 835, 504);
		JPanel flightsFrame2 = new JPanel();
		flightsFrame2.setBorder(new LineBorder(Color.BLACK));
		setContentPane(flightsFrame2);
		flightsFrame2.setLayout(null);
		
		// panel:
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 850, 100);
		//46, 95, 212 - blue
		panel.setBackground(new Color(44, 120, 50));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(Color.BLACK));
		flightsFrame2.add(panel);
		panel.setLayout(null);
		
		// Title:
		JLabel title = new JLabel("Brunel City London Airport");
		title.setBounds(114, 0, 636, 98);
		title.setFont(new Font("Arial", Font.PLAIN, 50));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		// Flights Available Title  
		Label departAvailableTitle = new Label("Departure Flights Available");
		departAvailableTitle.setAlignment(Label.CENTER);
		departAvailableTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		departAvailableTitle.setBounds(10, 110, 190, 26);
		departAvailableTitle.setVisible(true);
		flightsFrame2.add(departAvailableTitle);
		
		// Flights Available Title  
		Label returnAvailableTitle = new Label("Return Flights Available");
		returnAvailableTitle.setAlignment(Label.CENTER);
		returnAvailableTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		returnAvailableTitle.setBounds(421, 110, 170, 26);
		returnAvailableTitle.setVisible(true);
		flightsFrame2.add(returnAvailableTitle);
		
		//Select Seats button
		JToggleButton selectSeatButton = new JToggleButton("Select Seats");
		selectSeatButton.setFont(new Font("Arial", Font.PLAIN, 15));
		selectSeatButton.setBounds(16, 436, 124, 21);
		selectSeatButton.setBackground(Color.WHITE);
		selectSeatButton.setForeground(new Color(44, 120, 50));
		flightsFrame2.add(selectSeatButton);
		
		selectSeatButton.addActionListener(new ActionListener() 	{
			
		@SuppressWarnings({ "unused", "static-access" })
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			SeatingPlanUI seats;
			try {
				seats = new SeatingPlanUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 v
			}
			*/
			SeatingPlanUI seats = null;
			try {
				seats = new SeatingPlanUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			seats.main(null);
			}
		});
		
	    //departure J table
	    
		String[] columns1 = {"dateOfFlight", "departureTime", "arrivalTime", "flightDuration", "distanceTravelled", "delay", "departureAirport", "departureCity", 
				"arrivalAirport", "arrivalCity", "flightNumber", "airline"};
		
		String[][] dFlightData = dFilteredFlights();
		
		dFilteredFlights = new JTable(dFlightData, columns1);
		dFilteredFlights.setEnabled(false);
		dFilteredFlights.setBounds(19, 154, 369, 259);
		dFilteredFlights.setBorder(new LineBorder(Color.BLACK));
		dFilteredFlights.setShowGrid(true);
		dFilteredFlights.setGridColor(Color.BLACK);
		
		flightsFrame2.add(dFilteredFlights);
		
	    //return J table
		
		String[] columns2 = {"dateOfFlight", "departureTime", "arrivalTime", "flightDuration", "distanceTravelled", "delay", "departureAirport", "departureCity", 
				"arrivalAirport", "arrivalCity", "flightNumber", "airline"};
		
		String[][] rFlightData = rFilteredFlights();
		
		rFilteredFlights = new JTable(rFlightData, columns2 );
		rFilteredFlights.setEnabled(false);
		rFilteredFlights.setBounds(421, 154, 396, 259);
		rFilteredFlights.setBorder(new LineBorder(Color.BLACK));
		rFilteredFlights.setShowGrid(true);
		rFilteredFlights.setGridColor(Color.BLACK);
		
		flightsFrame2.add(rFilteredFlights);
		
		
	}
	
	public static String[][] dFilteredFlights() {
		
		String[][] departureFlight  = {{"dateOfFlight", "departureTime", "arrivalTime", "flightDuration", "distanceTravelled", "delay", "departureAirport", "departureCity", 
			"arrivalAirport", "arrivalCity", "flightNumber", "airline"},
				{"08/03/2022", "06:20", "11:57", "05:37", "7021.04", "179", "HND",
			"Tokyo", "SYD", "Sydney", "TS4977", "Easyplane"}};
		
		return departureFlight;
	}
	
	public static String[][] rFilteredFlights() {
		
		String[][] returnFlight = {{"dateOfFlight", "departureTime", "arrivalTime", "flightDuration", "distanceTravelled", "delay", "departureAirport", "departureCity", 
			"arrivalAirport", "arrivalCity", "flightNumber", "airline"},
				{"27/03/2022", "18:23",
			"03:44", "09:21", "11687.85", "10", "SYD", "Sydney", "HND", "Tokyo", "ST4138", "Eastair"}};
		
		return returnFlight;
	}
}
