package Seating;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arrivals.Flight_Arrivals;
import Passengers.Passengers;
import Passengers.PassengersUI;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SeatingPlanUI extends JFrame {
	
	// Calculate up to how many tickets should the user be allowed to select
	Integer maxAllowedTickets = SeatingPlan.calculateMaxTickets();
	
	String bookingType = "departure";
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatingPlanUI frame = new SeatingPlanUI();
					SeatingPlanUI testframe = new SeatingPlanUI();
					testframe.setVisible(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public SeatingPlanUI() throws IOException {
		
		// Set window title and create a content pane with an absolute layout
		setTitle("Brunel City London Airport");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlightType = new JLabel("Departure Flight");
		lblFlightType.setForeground(new Color(112, 112, 112));
		lblFlightType.setFont(new Font("Arial", Font.PLAIN, 32));
		lblFlightType.setBounds(35, 130, 245, 37);
		contentPane.add(lblFlightType);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(44, 120, 50));
		panelHeader.setBounds(0, 0, 1008, 100);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(20, 14, 188, 71);
		panelHeader.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("Resources/logo.png"));
		
		JLabel lblTitle = new JLabel("Seating Plan");
		lblTitle.setBounds(386, 27, 268, 47);
		panelHeader.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 38));
		
		JLabel lblPlaneModel = new JLabel("");
		lblPlaneModel.setForeground(new Color(112, 112, 112));
		lblPlaneModel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPlaneModel.setBounds(69, 178, 168, 28);
		contentPane.add(lblPlaneModel);
		
		JLabel lblFlightTypeIconD = new JLabel("");
		lblFlightTypeIconD.setIcon(new ImageIcon("Resources/baseline_flight_takeoff_black_24dp.png"));
		lblFlightTypeIconD.setBounds(35, 178, 24, 24);
		contentPane.add(lblFlightTypeIconD);
		
		JLabel lblFlightTypeIconR = new JLabel("");
		lblFlightTypeIconR.setVisible(false);
		lblFlightTypeIconR.setIcon(new ImageIcon("Resources/baseline_keyboard_return_black_24dp.png"));
		lblFlightTypeIconR.setBounds(35, 178, 24, 24);
		contentPane.add(lblFlightTypeIconR);
		
		JLabel lblInfoIcon = new JLabel("");
		lblInfoIcon.setIcon(new ImageIcon("Resources/baseline_info_black_24dp.png"));
		lblInfoIcon.setBounds(724, 513, 24, 24);
		contentPane.add(lblInfoIcon);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(35, 218, 225, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 450, 227, 1);
		contentPane.add(separator_1);
		
		JLabel lblSelectedSeats = new JLabel("Selected seats:");
		lblSelectedSeats.setForeground(new Color(112, 112, 112));
		lblSelectedSeats.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSelectedSeats.setBounds(729, 130, 165, 28);
		contentPane.add(lblSelectedSeats);
		
		JLabel lblSelectedSeatsList = new JLabel("None");
		lblSelectedSeatsList.setVerticalAlignment(SwingConstants.TOP);
		lblSelectedSeatsList.setForeground(new Color(112, 112, 112));
		lblSelectedSeatsList.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSelectedSeatsList.setBounds(730, 162, 246, 292);
		contentPane.add(lblSelectedSeatsList);
		
		// Create a scrollPane for allowing the user to scroll vertically through the seating plan
		JScrollPane scrollPaneSeatSelection = new JScrollPane();
		scrollPaneSeatSelection.setBounds(309, 100, 390, 629);
		contentPane.add(scrollPaneSeatSelection);
		
		JLabel lblScrollPaneHeading = new JLabel("Select 1 seat(s) below:");
		lblScrollPaneHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrollPaneHeading.setForeground(new Color(112, 112, 112));
		lblScrollPaneHeading.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPaneSeatSelection.setColumnHeaderView(lblScrollPaneHeading);
		
		JLabel lblLegend = new JLabel("Legend:");
		lblLegend.setForeground(new Color(112, 112, 112));
		lblLegend.setFont(new Font("Arial", Font.PLAIN, 24));
		lblLegend.setBounds(35, 230, 88, 28);
		contentPane.add(lblLegend);
		
		JLabel lblInfoText = new JLabel("<html><center>To continue, select a<br> \r\nnumber of seats equal<br> \r\nto your selected<br> \r\nnumber of tickets.</center></html>");
		lblInfoText.setForeground(new Color(112, 112, 112));
		lblInfoText.setFont(new Font("Arial", Font.PLAIN, 20));
		lblInfoText.setBounds(758, 450, 195, 156);
		contentPane.add(lblInfoText);
		
		JPanel panelFirstClass = new JPanel();
		panelFirstClass.setBackground(new Color(241, 227, 137));
		panelFirstClass.setBounds(37, 267, 37, 37);
		contentPane.add(panelFirstClass);
		
		JPanel panelBusinessClass = new JPanel();
		panelBusinessClass.setBackground(new Color(160, 213, 172));
		panelBusinessClass.setBounds(37, 311, 37, 37);
		contentPane.add(panelBusinessClass);
		
		JPanel panelEconomy = new JPanel();
		panelEconomy.setBackground(new Color(149, 174, 233));
		panelEconomy.setBounds(37, 355, 37, 37);
		contentPane.add(panelEconomy);
		
		JPanel panelUnavailable = new JPanel();
		panelUnavailable.setBackground(new Color(192,192,192));
		panelUnavailable.setBounds(37, 399, 37, 37);
		contentPane.add(panelUnavailable);
		
		JLabel lblFirstClass = new JLabel("First Class");
		lblFirstClass.setForeground(new Color(112, 112, 112));
		lblFirstClass.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFirstClass.setBounds(88, 272, 94, 24);
		contentPane.add(lblFirstClass);
		
		JLabel lblBusinessClass = new JLabel("Business Class");
		lblBusinessClass.setForeground(new Color(112, 112, 112));
		lblBusinessClass.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBusinessClass.setBounds(88, 317, 133, 24);
		contentPane.add(lblBusinessClass);
		
		JLabel lblEconomy = new JLabel("Economy");
		lblEconomy.setForeground(new Color(112, 112, 112));
		lblEconomy.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEconomy.setBounds(88, 361, 81, 24);
		contentPane.add(lblEconomy);
		
		JLabel lblUnavailabe = new JLabel("Unavailabe");
		lblUnavailabe.setForeground(new Color(112, 112, 112));
		lblUnavailabe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUnavailabe.setBounds(88, 405, 95, 24);
		contentPane.add(lblUnavailabe);
		
		/**
		 * Create a button that *would* allow the user to continue to the next "Passengers" component of the software.
		 */
		JToggleButton btnContinueToPassengers = new JToggleButton("Continue");
		btnContinueToPassengers.setVisible(true);
		btnContinueToPassengers.setEnabled(true);
		btnContinueToPassengers.setForeground(Color.BLACK);
		btnContinueToPassengers.setFont(new Font("Arial", Font.PLAIN, 24));
		btnContinueToPassengers.setBounds(758, 640, 195, 57);
		contentPane.add(btnContinueToPassengers);
		
		btnContinueToPassengers.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				PassengersUI passenger;
				passenger = new PassengersUI();
				passenger.main(null);
			}
		
		});
		
		/**
		 * Create a button to allow the user to continue to seat selection for their return flight.
		 */
		JButton btnContinueToRFlight = new JButton("Continue");
		btnContinueToRFlight.setEnabled(false);
		btnContinueToRFlight.setBackground(new Color(46, 95, 212));
		btnContinueToRFlight.setForeground(new Color(255, 255, 255));
		btnContinueToRFlight.setFont(new Font("Arial", Font.PLAIN, 24));
		btnContinueToRFlight.setBounds(758, 640, 195, 57);
		
		/**
		 * Create an action listener for seat button toggle.
		 */
		ActionListener seatBtnToggled = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  
				  // Get the toggled button from the ActionEvent e
				  JToggleButton tglbtn = (JToggleButton) e.getSource();
				  
				  // If selected (toggled), add to selectedSeats ArrayList, else remove from it
				  if (tglbtn.isSelected()) {
						SeatingPlan.selectedSeats.add(tglbtn.getText());
					} else {
						SeatingPlan.selectedSeats.remove(tglbtn.getText());
					}
				  if (SeatingPlan.selectedSeats.size() == 0) lblSelectedSeatsList.setText("None");
				  else lblSelectedSeatsList.setText("<html>" + String.join(", ", SeatingPlan.selectedSeats) + "</html>");
				  
				  // If the number of selected seats is equal to the selected number of tickets,
				  // enable the shown continue button and disable the info tooltip above it,
				  // otherwise disable the continue button and enable the info tooltip.
				  if (SeatingPlan.selectedSeats.size() == SeatingPlan.numTickets) {
					  if (btnContinueToRFlight.isVisible()) btnContinueToRFlight.setEnabled(true);
					  if (btnContinueToPassengers.isVisible()) btnContinueToPassengers.setEnabled(true);
					  lblInfoText.setVisible(false);
					  lblInfoIcon.setVisible(false);
				  } else {
					  if (btnContinueToRFlight.isVisible()) btnContinueToRFlight.setEnabled(false);
					  if (btnContinueToPassengers.isVisible()) btnContinueToPassengers.setEnabled(false);
					  lblInfoText.setVisible(true);
					  lblInfoIcon.setVisible(true);
				  }
			  }
		};
		
		JLabel lblSelectNumTickets = new JLabel("Select number of tickets:");
		lblSelectNumTickets.setForeground(new Color(112, 112, 112));
		lblSelectNumTickets.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSelectNumTickets.setBounds(36, 470, 218, 24);
		contentPane.add(lblSelectNumTickets);
		
		// Create a comboBox for allowing the user to select the amount tickets
		JComboBox comboBoxNumTickets = new JComboBox();
		
		// Add an action listener to the continue (to 'return flight seating plan') button
		btnContinueToRFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookingType = "return";
				
				// Assign selectedDSeats ArrayList values to those within the selectedSeats ArrayList
				SeatingPlan.selectedDSeats.addAll(SeatingPlan.selectedSeats);
				SeatingPlan.selectedSeats.clear(); // Clear the selectedSeats ArrayList
				
				// Get the selected return flight information
				Flight selectedRFlight = SeatingPlan.getSelectedFlight("return");
				lblFlightType.setText("Return Flight");
				
				// Get model of the plane based on selected return flight's duration
				String planeModel = SeatingPlan.getPlaneModel(selectedRFlight.flightDuration);
				lblPlaneModel.setText(planeModel);
				
				// Get the respective plane model's seating layout
				try {
					if (planeModel == "Boeing 747") {
						getPanelBoeing(scrollPaneSeatSelection, seatBtnToggled);
					} else if (planeModel == "Airbus A318") {
						getPanelAirbus(scrollPaneSeatSelection, seatBtnToggled);
	
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// Set text to "None" in the selected seats list label
				lblSelectedSeatsList.setText("None");
				
				// Make the info tooltip visible
				lblInfoText.setVisible(true);
				lblInfoIcon.setVisible(true);
				
				// Change the departing flight icon to a return flight icon
				lblFlightTypeIconD.setVisible(false);
				lblFlightTypeIconR.setVisible(true);
				
				// Prevent the user from changing the number of tickets again for the return flight
				lblSelectNumTickets.setVisible(false);
				comboBoxNumTickets.setVisible(false);
				
				// Switch "continue to return flight" button for "continue to passengers" button
				btnContinueToRFlight.setVisible(false);
				btnContinueToRFlight.setEnabled(false);
				btnContinueToPassengers.setVisible(true);
			}
		});
		contentPane.add(btnContinueToRFlight);
		
		
		/**
		 * Create a comboBox to allow the user to select a number of tickets.
		 */
		comboBoxNumTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatingPlan.numTickets = (Integer) comboBoxNumTickets.getSelectedItem();
				lblScrollPaneHeading.setText("Select " + SeatingPlan.numTickets + " seat(s) below:");
				
				// If the selected number of tickets is equal to the selected number of seats,
				// Enable the currently visible continue button and make the info tooltip invisible.
				// Otherwise disable the continue button and make the tooltip visible.
				if (SeatingPlan.selectedSeats.size() == SeatingPlan.numTickets) {
					if (btnContinueToRFlight.isVisible()) {
						btnContinueToRFlight.setEnabled(true);
					} else {
						btnContinueToPassengers.setEnabled(true);
					}
					lblInfoText.setVisible(false);
					lblInfoIcon.setVisible(false);
				} else {
					if (btnContinueToRFlight.isVisible()) {
						btnContinueToRFlight.setEnabled(false);
					} else {
						btnContinueToPassengers.setEnabled(false);
					}
					lblInfoText.setVisible(true);
					lblInfoIcon.setVisible(true);
				}
			}
		});
		comboBoxNumTickets.setBounds(37, 503, 88, 24);
		
		// Get the selected departure flight information and change the appropriate labels
		Flight selectedDFlight = SeatingPlan.getSelectedFlight("departure");
		lblFlightType.setText("Departure Flight");
		String planeModel = SeatingPlan.getPlaneModel(selectedDFlight.flightDuration);
		lblPlaneModel.setText(planeModel);
		
		// Based on the plane model, get the seating selection for it
		if (planeModel == "Boeing 747") {
			getPanelBoeing(scrollPaneSeatSelection, seatBtnToggled);
		} else if (planeModel == "Airbus A318") {
			getPanelAirbus(scrollPaneSeatSelection, seatBtnToggled);
		}
		
		// Add all selectable ticket numbers to the comboBox as items
		for (Integer i = 1; i <= maxAllowedTickets; i++) {
			comboBoxNumTickets.addItem(i);
		}
		contentPane.add(comboBoxNumTickets);
	}
	
	public void getPanelBoeing(JScrollPane scrollPane, ActionListener seatBtnToggled) throws IOException {
		
		/**
		 * Assign Boeing panel to the scrollPane and initialise the seating plan layout.
		 */
		JPanel panelSeatingBoeing = new JPanel();
		scrollPane.setViewportView(panelSeatingBoeing);
		GridBagLayout gbl_panelSeatingBoeing = new GridBagLayout();
		gbl_panelSeatingBoeing.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSeatingBoeing.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSeatingBoeing.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSeatingBoeing.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSeatingBoeing.setLayout(gbl_panelSeatingBoeing);
		
		/**
		 * Define and add toggleable buttons to panelSeatingPlan.
		 */
		JToggleButton tglbtn_1A = new JToggleButton("1A");
		tglbtn_1A.addActionListener(seatBtnToggled);
		tglbtn_1A.setBackground(new Color(241, 227, 137));
		tglbtn_1A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_1A = new GridBagConstraints();
		gbc_tglbtn_1A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_1A.gridx = 0;
		gbc_tglbtn_1A.gridy = 0;
		panelSeatingBoeing.add(tglbtn_1A, gbc_tglbtn_1A);
		
		// Add a horizontal strut in the middle to create empty space separating the seats
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 0;
		panelSeatingBoeing.add(horizontalStrut, gbc_horizontalStrut);
		
		JToggleButton tglbtn_1B = new JToggleButton("1B");
		tglbtn_1B.addActionListener(seatBtnToggled);
		tglbtn_1B.setBackground(new Color(241, 227, 137));
		tglbtn_1B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_1B = new GridBagConstraints();
		gbc_tglbtn_1B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_1B.gridx = 6;
		gbc_tglbtn_1B.gridy = 0;
		panelSeatingBoeing.add(tglbtn_1B, gbc_tglbtn_1B);
		
		JToggleButton tglbtn_2A = new JToggleButton("2A");
		tglbtn_2A.addActionListener(seatBtnToggled);
		tglbtn_2A.setBackground(new Color(241, 227, 137));
		tglbtn_2A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_2A = new GridBagConstraints();
		gbc_tglbtn_2A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_2A.gridx = 0;
		gbc_tglbtn_2A.gridy = 1;
		panelSeatingBoeing.add(tglbtn_2A, gbc_tglbtn_2A);
		
		JToggleButton tglbtn_2B = new JToggleButton("2B");
		tglbtn_2B.addActionListener(seatBtnToggled);
		tglbtn_2B.setBackground(new Color(241, 227, 137));
		tglbtn_2B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_2B = new GridBagConstraints();
		gbc_tglbtn_2B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_2B.gridx = 6;
		gbc_tglbtn_2B.gridy = 1;
		panelSeatingBoeing.add(tglbtn_2B, gbc_tglbtn_2B);
		
		JToggleButton tglbtn_3A = new JToggleButton("3A");
		tglbtn_3A.addActionListener(seatBtnToggled);
		tglbtn_3A.setBackground(new Color(241, 227, 137));
		tglbtn_3A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_3A = new GridBagConstraints();
		gbc_tglbtn_3A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_3A.gridx = 0;
		gbc_tglbtn_3A.gridy = 2;
		panelSeatingBoeing.add(tglbtn_3A, gbc_tglbtn_3A);
		
		JToggleButton tglbtn_3B = new JToggleButton("3B");
		tglbtn_3B.addActionListener(seatBtnToggled);
		tglbtn_3B.setBackground(new Color(241, 227, 137));
		tglbtn_3B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_3B = new GridBagConstraints();
		gbc_tglbtn_3B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_3B.gridx = 6;
		gbc_tglbtn_3B.gridy = 2;
		panelSeatingBoeing.add(tglbtn_3B, gbc_tglbtn_3B);
		
		JToggleButton tglbtn_4A = new JToggleButton("4A");
		tglbtn_4A.addActionListener(seatBtnToggled);
		tglbtn_4A.setBackground(new Color(241, 227, 137));
		tglbtn_4A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_4A = new GridBagConstraints();
		gbc_tglbtn_4A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_4A.gridx = 0;
		gbc_tglbtn_4A.gridy = 3;
		panelSeatingBoeing.add(tglbtn_4A, gbc_tglbtn_4A);
		
		JToggleButton tglbtn_4B = new JToggleButton("4B");
		tglbtn_4B.addActionListener(seatBtnToggled);
		tglbtn_4B.setBackground(new Color(241, 227, 137));
		tglbtn_4B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_4B = new GridBagConstraints();
		gbc_tglbtn_4B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_4B.gridx = 6;
		gbc_tglbtn_4B.gridy = 3;
		panelSeatingBoeing.add(tglbtn_4B, gbc_tglbtn_4B);
		
		JToggleButton tglbtn_5A = new JToggleButton("5A");
		tglbtn_5A.addActionListener(seatBtnToggled);
		tglbtn_5A.setBackground(new Color(241, 227, 137));
		tglbtn_5A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_5A = new GridBagConstraints();
		gbc_tglbtn_5A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_5A.gridx = 0;
		gbc_tglbtn_5A.gridy = 4;
		panelSeatingBoeing.add(tglbtn_5A, gbc_tglbtn_5A);
		
		JToggleButton tglbtn_5B = new JToggleButton("5B");
		tglbtn_5B.addActionListener(seatBtnToggled);
		tglbtn_5B.setBackground(new Color(241, 227, 137));
		tglbtn_5B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_5B = new GridBagConstraints();
		gbc_tglbtn_5B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_5B.gridx = 6;
		gbc_tglbtn_5B.gridy = 4;
		panelSeatingBoeing.add(tglbtn_5B, gbc_tglbtn_5B);
		
		// Add a vertical strut to create empty space separating the seats
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridwidth = 7;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 5;
		panelSeatingBoeing.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JToggleButton tglbtn_6A = new JToggleButton("6A");
		tglbtn_6A.addActionListener(seatBtnToggled);
		tglbtn_6A.setBackground(new Color(160, 213, 172));
		tglbtn_6A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_6A = new GridBagConstraints();
		gbc_tglbtn_6A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6A.gridx = 0;
		gbc_tglbtn_6A.gridy = 6;
		panelSeatingBoeing.add(tglbtn_6A, gbc_tglbtn_6A);
		
		JToggleButton tglbtn_6B = new JToggleButton("6B");
		tglbtn_6B.addActionListener(seatBtnToggled);
		tglbtn_6B.setBackground(new Color(160, 213, 172));
		tglbtn_6B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_6B = new GridBagConstraints();
		gbc_tglbtn_6B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6B.gridx = 2;
		gbc_tglbtn_6B.gridy = 6;
		panelSeatingBoeing.add(tglbtn_6B, gbc_tglbtn_6B);
		
		JToggleButton tglbtn_6C = new JToggleButton("6C");
		tglbtn_6C.addActionListener(seatBtnToggled);
		tglbtn_6C.setBackground(new Color(160, 213, 172));
		tglbtn_6C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_6C = new GridBagConstraints();
		gbc_tglbtn_6C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6C.gridx = 4;
		gbc_tglbtn_6C.gridy = 6;
		panelSeatingBoeing.add(tglbtn_6C, gbc_tglbtn_6C);
		
		JToggleButton tglbtn_6D = new JToggleButton("6D");
		tglbtn_6D.addActionListener(seatBtnToggled);
		tglbtn_6D.setBackground(new Color(160, 213, 172));
		tglbtn_6D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_6D = new GridBagConstraints();
		gbc_tglbtn_6D.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_6D.gridx = 6;
		gbc_tglbtn_6D.gridy = 6;
		panelSeatingBoeing.add(tglbtn_6D, gbc_tglbtn_6D);
		
		JToggleButton tglbtn_7A = new JToggleButton("7A");
		tglbtn_7A.addActionListener(seatBtnToggled);
		tglbtn_7A.setBackground(new Color(160, 213, 172));
		tglbtn_7A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_7A = new GridBagConstraints();
		gbc_tglbtn_7A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7A.gridx = 0;
		gbc_tglbtn_7A.gridy = 7;
		panelSeatingBoeing.add(tglbtn_7A, gbc_tglbtn_7A);
		
		JToggleButton tglbtn_7B = new JToggleButton("7B");
		tglbtn_7B.addActionListener(seatBtnToggled);
		tglbtn_7B.setBackground(new Color(160, 213, 172));
		tglbtn_7B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_7B = new GridBagConstraints();
		gbc_tglbtn_7B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7B.gridx = 2;
		gbc_tglbtn_7B.gridy = 7;
		panelSeatingBoeing.add(tglbtn_7B, gbc_tglbtn_7B);
		
		JToggleButton tglbtn_7C = new JToggleButton("7C");
		tglbtn_7C.addActionListener(seatBtnToggled);
		tglbtn_7C.setBackground(new Color(160, 213, 172));
		tglbtn_7C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_7C = new GridBagConstraints();
		gbc_tglbtn_7C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7C.gridx = 4;
		gbc_tglbtn_7C.gridy = 7;
		panelSeatingBoeing.add(tglbtn_7C, gbc_tglbtn_7C);
		
		JToggleButton tglbtn_7D = new JToggleButton("7D");
		tglbtn_7D.addActionListener(seatBtnToggled);
		tglbtn_7D.setBackground(new Color(160, 213, 172));
		tglbtn_7D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_7D = new GridBagConstraints();
		gbc_tglbtn_7D.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_7D.gridx = 6;
		gbc_tglbtn_7D.gridy = 7;
		panelSeatingBoeing.add(tglbtn_7D, gbc_tglbtn_7D);
		
		JToggleButton tglbtn_8A = new JToggleButton("8A");
		tglbtn_8A.addActionListener(seatBtnToggled);
		tglbtn_8A.setBackground(new Color(160, 213, 172));
		tglbtn_8A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_8A = new GridBagConstraints();
		gbc_tglbtn_8A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8A.gridx = 0;
		gbc_tglbtn_8A.gridy = 8;
		panelSeatingBoeing.add(tglbtn_8A, gbc_tglbtn_8A);
		
		JToggleButton tglbtn_8B = new JToggleButton("8B");
		tglbtn_8B.addActionListener(seatBtnToggled);
		tglbtn_8B.setBackground(new Color(160, 213, 172));
		tglbtn_8B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_8B = new GridBagConstraints();
		gbc_tglbtn_8B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8B.gridx = 2;
		gbc_tglbtn_8B.gridy = 8;
		panelSeatingBoeing.add(tglbtn_8B, gbc_tglbtn_8B);
		
		JToggleButton tglbtn_8C = new JToggleButton("8C");
		tglbtn_8C.addActionListener(seatBtnToggled);
		tglbtn_8C.setBackground(new Color(160, 213, 172));
		tglbtn_8C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_8C = new GridBagConstraints();
		gbc_tglbtn_8C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8C.gridx = 4;
		gbc_tglbtn_8C.gridy = 8;
		panelSeatingBoeing.add(tglbtn_8C, gbc_tglbtn_8C);
		
		JToggleButton tglbtn_8D = new JToggleButton("8D");
		tglbtn_8D.addActionListener(seatBtnToggled);
		tglbtn_8D.setBackground(new Color(160, 213, 172));
		tglbtn_8D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_8D = new GridBagConstraints();
		gbc_tglbtn_8D.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_8D.gridx = 6;
		gbc_tglbtn_8D.gridy = 8;
		panelSeatingBoeing.add(tglbtn_8D, gbc_tglbtn_8D);
		
		JToggleButton tglbtn_9A = new JToggleButton("9A");
		tglbtn_9A.addActionListener(seatBtnToggled);
		tglbtn_9A.setBackground(new Color(160, 213, 172));
		tglbtn_9A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_9A = new GridBagConstraints();
		gbc_tglbtn_9A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9A.gridx = 0;
		gbc_tglbtn_9A.gridy = 9;
		panelSeatingBoeing.add(tglbtn_9A, gbc_tglbtn_9A);
		
		JToggleButton tglbtn_9B = new JToggleButton("9B");
		tglbtn_9B.addActionListener(seatBtnToggled);
		tglbtn_9B.setBackground(new Color(160, 213, 172));
		tglbtn_9B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_9B = new GridBagConstraints();
		gbc_tglbtn_9B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9B.gridx = 2;
		gbc_tglbtn_9B.gridy = 9;
		panelSeatingBoeing.add(tglbtn_9B, gbc_tglbtn_9B);
		
		JToggleButton tglbtn_9C = new JToggleButton("9C");
		tglbtn_9C.addActionListener(seatBtnToggled);
		tglbtn_9C.setBackground(new Color(160, 213, 172));
		tglbtn_9C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_9C = new GridBagConstraints();
		gbc_tglbtn_9C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9C.gridx = 4;
		gbc_tglbtn_9C.gridy = 9;
		panelSeatingBoeing.add(tglbtn_9C, gbc_tglbtn_9C);
		
		JToggleButton tglbtn_9D = new JToggleButton("9D");
		tglbtn_9D.addActionListener(seatBtnToggled);
		tglbtn_9D.setBackground(new Color(160, 213, 172));
		tglbtn_9D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_9D = new GridBagConstraints();
		gbc_tglbtn_9D.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_9D.gridx = 6;
		gbc_tglbtn_9D.gridy = 9;
		panelSeatingBoeing.add(tglbtn_9D, gbc_tglbtn_9D);
		
		JToggleButton tglbtn_10A = new JToggleButton("10A");
		tglbtn_10A.addActionListener(seatBtnToggled);
		tglbtn_10A.setBackground(new Color(160, 213, 172));
		tglbtn_10A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_10A = new GridBagConstraints();
		gbc_tglbtn_10A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10A.gridx = 0;
		gbc_tglbtn_10A.gridy = 10;
		panelSeatingBoeing.add(tglbtn_10A, gbc_tglbtn_10A);
		
		JToggleButton tglbtn_10B = new JToggleButton("10B");
		tglbtn_10B.addActionListener(seatBtnToggled);
		tglbtn_10B.setBackground(new Color(160, 213, 172));
		tglbtn_10B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_10B = new GridBagConstraints();
		gbc_tglbtn_10B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10B.gridx = 2;
		gbc_tglbtn_10B.gridy = 10;
		panelSeatingBoeing.add(tglbtn_10B, gbc_tglbtn_10B);
		
		JToggleButton tglbtn_10C = new JToggleButton("10C");
		tglbtn_10C.addActionListener(seatBtnToggled);
		tglbtn_10C.setBackground(new Color(160, 213, 172));
		tglbtn_10C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_10C = new GridBagConstraints();
		gbc_tglbtn_10C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10C.gridx = 4;
		gbc_tglbtn_10C.gridy = 10;
		panelSeatingBoeing.add(tglbtn_10C, gbc_tglbtn_10C);
		
		JToggleButton tglbtn_10D = new JToggleButton("10D");
		tglbtn_10D.addActionListener(seatBtnToggled);
		tglbtn_10D.setBackground(new Color(160, 213, 172));
		tglbtn_10D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_10D = new GridBagConstraints();
		gbc_tglbtn_10D.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_10D.gridx = 6;
		gbc_tglbtn_10D.gridy = 10;
		panelSeatingBoeing.add(tglbtn_10D, gbc_tglbtn_10D);
		
		// Add a vertical strut to create empty space separating the seats
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridwidth = 7;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 11;
		panelSeatingBoeing.add(verticalStrut, gbc_verticalStrut);
		
		JToggleButton tglbtn_11A = new JToggleButton("11A");
		tglbtn_11A.addActionListener(seatBtnToggled);
		tglbtn_11A.setBackground(new Color(149, 174, 233));
		tglbtn_11A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11A = new GridBagConstraints();
		gbc_tglbtn_11A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11A.gridx = 0;
		gbc_tglbtn_11A.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11A, gbc_tglbtn_11A);
		
		JToggleButton tglbtn_11B = new JToggleButton("11B");
		tglbtn_11B.addActionListener(seatBtnToggled);
		tglbtn_11B.setBackground(new Color(149, 174, 233));
		tglbtn_11B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11B = new GridBagConstraints();
		gbc_tglbtn_11B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11B.gridx = 1;
		gbc_tglbtn_11B.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11B, gbc_tglbtn_11B);
		
		JToggleButton tglbtn_11C = new JToggleButton("11C");
		tglbtn_11C.addActionListener(seatBtnToggled);
		tglbtn_11C.setBackground(new Color(149, 174, 233));
		tglbtn_11C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11C = new GridBagConstraints();
		gbc_tglbtn_11C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11C.gridx = 2;
		gbc_tglbtn_11C.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11C, gbc_tglbtn_11C);
		
		JToggleButton tglbtn_11D = new JToggleButton("11D");
		tglbtn_11D.addActionListener(seatBtnToggled);
		tglbtn_11D.setBackground(new Color(149, 174, 233));
		tglbtn_11D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11D = new GridBagConstraints();
		gbc_tglbtn_11D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11D.gridx = 4;
		gbc_tglbtn_11D.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11D, gbc_tglbtn_11D);
		
		JToggleButton tglbtn_11E = new JToggleButton("11E");
		tglbtn_11E.addActionListener(seatBtnToggled);
		tglbtn_11E.setBackground(new Color(149, 174, 233));
		tglbtn_11E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11E = new GridBagConstraints();
		gbc_tglbtn_11E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11E.gridx = 5;
		gbc_tglbtn_11E.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11E, gbc_tglbtn_11E);
		
		JToggleButton tglbtn_11F = new JToggleButton("11F");
		tglbtn_11F.addActionListener(seatBtnToggled);
		tglbtn_11F.setBackground(new Color(149, 174, 233));
		tglbtn_11F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_11F = new GridBagConstraints();
		gbc_tglbtn_11F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_11F.gridx = 6;
		gbc_tglbtn_11F.gridy = 12;
		panelSeatingBoeing.add(tglbtn_11F, gbc_tglbtn_11F);
		
		JToggleButton tglbtn_12A = new JToggleButton("12A");
		tglbtn_12A.addActionListener(seatBtnToggled);
		tglbtn_12A.setBackground(new Color(149, 174, 233));
		tglbtn_12A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12A = new GridBagConstraints();
		gbc_tglbtn_12A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12A.gridx = 0;
		gbc_tglbtn_12A.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12A, gbc_tglbtn_12A);
		
		JToggleButton tglbtn_12B = new JToggleButton("12B");
		tglbtn_12B.addActionListener(seatBtnToggled);
		tglbtn_12B.setBackground(new Color(149, 174, 233));
		tglbtn_12B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12B = new GridBagConstraints();
		gbc_tglbtn_12B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12B.gridx = 1;
		gbc_tglbtn_12B.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12B, gbc_tglbtn_12B);
		
		JToggleButton tglbtn_12C = new JToggleButton("12C");
		tglbtn_12C.addActionListener(seatBtnToggled);
		tglbtn_12C.setBackground(new Color(149, 174, 233));
		tglbtn_12C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12C = new GridBagConstraints();
		gbc_tglbtn_12C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12C.gridx = 2;
		gbc_tglbtn_12C.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12C, gbc_tglbtn_12C);
		
		JToggleButton tglbtn_12D = new JToggleButton("12D");
		tglbtn_12D.addActionListener(seatBtnToggled);
		tglbtn_12D.setBackground(new Color(149, 174, 233));
		tglbtn_12D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12D = new GridBagConstraints();
		gbc_tglbtn_12D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12D.gridx = 4;
		gbc_tglbtn_12D.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12D, gbc_tglbtn_12D);
		
		JToggleButton tglbtn_12E = new JToggleButton("12E");
		tglbtn_12E.addActionListener(seatBtnToggled);
		tglbtn_12E.setBackground(new Color(149, 174, 233));
		tglbtn_12E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12E = new GridBagConstraints();
		gbc_tglbtn_12E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12E.gridx = 5;
		gbc_tglbtn_12E.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12E, gbc_tglbtn_12E);
		
		JToggleButton tglbtn_12F = new JToggleButton("12F");
		tglbtn_12F.addActionListener(seatBtnToggled);
		tglbtn_12F.setBackground(new Color(149, 174, 233));
		tglbtn_12F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_12F = new GridBagConstraints();
		gbc_tglbtn_12F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_12F.gridx = 6;
		gbc_tglbtn_12F.gridy = 13;
		panelSeatingBoeing.add(tglbtn_12F, gbc_tglbtn_12F);
		
		JToggleButton tglbtn_13A = new JToggleButton("13A");
		tglbtn_13A.addActionListener(seatBtnToggled);
		tglbtn_13A.setBackground(new Color(149, 174, 233));
		tglbtn_13A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13A = new GridBagConstraints();
		gbc_tglbtn_13A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13A.gridx = 0;
		gbc_tglbtn_13A.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13A, gbc_tglbtn_13A);
		
		JToggleButton tglbtn_13B = new JToggleButton("13B");
		tglbtn_13B.addActionListener(seatBtnToggled);
		tglbtn_13B.setBackground(new Color(149, 174, 233));
		tglbtn_13B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13B = new GridBagConstraints();
		gbc_tglbtn_13B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13B.gridx = 1;
		gbc_tglbtn_13B.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13B, gbc_tglbtn_13B);
		
		JToggleButton tglbtn_13C = new JToggleButton("13C");
		tglbtn_13C.addActionListener(seatBtnToggled);
		tglbtn_13C.setBackground(new Color(149, 174, 233));
		tglbtn_13C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13C = new GridBagConstraints();
		gbc_tglbtn_13C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13C.gridx = 2;
		gbc_tglbtn_13C.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13C, gbc_tglbtn_13C);
		
		JToggleButton tglbtn_13D = new JToggleButton("13D");
		tglbtn_13D.addActionListener(seatBtnToggled);
		tglbtn_13D.setBackground(new Color(149, 174, 233));
		tglbtn_13D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13D = new GridBagConstraints();
		gbc_tglbtn_13D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13D.gridx = 4;
		gbc_tglbtn_13D.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13D, gbc_tglbtn_13D);
		
		JToggleButton tglbtn_13E = new JToggleButton("13E");
		tglbtn_13E.addActionListener(seatBtnToggled);
		tglbtn_13E.setBackground(new Color(149, 174, 233));
		tglbtn_13E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13E = new GridBagConstraints();
		gbc_tglbtn_13E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13E.gridx = 5;
		gbc_tglbtn_13E.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13E, gbc_tglbtn_13E);
		
		JToggleButton tglbtn_13F = new JToggleButton("13F");
		tglbtn_13F.addActionListener(seatBtnToggled);
		tglbtn_13F.setBackground(new Color(149, 174, 233));
		tglbtn_13F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_13F = new GridBagConstraints();
		gbc_tglbtn_13F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_13F.gridx = 6;
		gbc_tglbtn_13F.gridy = 14;
		panelSeatingBoeing.add(tglbtn_13F, gbc_tglbtn_13F);
		
		JToggleButton tglbtn_14A = new JToggleButton("14A");
		tglbtn_14A.addActionListener(seatBtnToggled);
		tglbtn_14A.setBackground(new Color(149, 174, 233));
		tglbtn_14A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14A = new GridBagConstraints();
		gbc_tglbtn_14A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_14A.gridx = 0;
		gbc_tglbtn_14A.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14A, gbc_tglbtn_14A);
		
		JToggleButton tglbtn_14B = new JToggleButton("14B");
		tglbtn_14B.addActionListener(seatBtnToggled);
		tglbtn_14B.setBackground(new Color(149, 174, 233));
		tglbtn_14B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14B = new GridBagConstraints();
		gbc_tglbtn_14B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_14B.gridx = 1;
		gbc_tglbtn_14B.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14B, gbc_tglbtn_14B);
		
		JToggleButton tglbtn_14C = new JToggleButton("14C");
		tglbtn_14C.addActionListener(seatBtnToggled);
		tglbtn_14C.setBackground(new Color(149, 174, 233));
		tglbtn_14C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14C = new GridBagConstraints();
		gbc_tglbtn_14C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_14C.gridx = 2;
		gbc_tglbtn_14C.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14C, gbc_tglbtn_14C);
		
		JToggleButton tglbtn_14D = new JToggleButton("14D");
		tglbtn_14D.addActionListener(seatBtnToggled);
		tglbtn_14D.setBackground(new Color(149, 174, 233));
		tglbtn_14D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14D = new GridBagConstraints();
		gbc_tglbtn_14D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_14D.gridx = 4;
		gbc_tglbtn_14D.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14D, gbc_tglbtn_14D);
		
		JToggleButton tglbtn_14E = new JToggleButton("14E");
		tglbtn_14E.addActionListener(seatBtnToggled);
		tglbtn_14E.setBackground(new Color(149, 174, 233));
		tglbtn_14E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14E = new GridBagConstraints();
		gbc_tglbtn_14E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_14E.gridx = 5;
		gbc_tglbtn_14E.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14E, gbc_tglbtn_14E);
		
		JToggleButton tglbtn_14F = new JToggleButton("14F");
		tglbtn_14F.addActionListener(seatBtnToggled);
		tglbtn_14F.setBackground(new Color(149, 174, 233));
		tglbtn_14F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_14F = new GridBagConstraints();
		gbc_tglbtn_14F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_14F.gridx = 6;
		gbc_tglbtn_14F.gridy = 15;
		panelSeatingBoeing.add(tglbtn_14F, gbc_tglbtn_14F);
		
		JToggleButton tglbtn_15A = new JToggleButton("15A");
		tglbtn_15A.addActionListener(seatBtnToggled);
		tglbtn_15A.setBackground(new Color(149, 174, 233));
		tglbtn_15A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15A = new GridBagConstraints();
		gbc_tglbtn_15A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_15A.gridx = 0;
		gbc_tglbtn_15A.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15A, gbc_tglbtn_15A);
		
		JToggleButton tglbtn_15B = new JToggleButton("15B");
		tglbtn_15B.addActionListener(seatBtnToggled);
		tglbtn_15B.setBackground(new Color(149, 174, 233));
		tglbtn_15B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15B = new GridBagConstraints();
		gbc_tglbtn_15B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_15B.gridx = 1;
		gbc_tglbtn_15B.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15B, gbc_tglbtn_15B);
		
		JToggleButton tglbtn_15C = new JToggleButton("15C");
		tglbtn_15C.addActionListener(seatBtnToggled);
		tglbtn_15C.setBackground(new Color(149, 174, 233));
		tglbtn_15C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15C = new GridBagConstraints();
		gbc_tglbtn_15C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_15C.gridx = 2;
		gbc_tglbtn_15C.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15C, gbc_tglbtn_15C);
		
		JToggleButton tglbtn_15D = new JToggleButton("15D");
		tglbtn_15D.addActionListener(seatBtnToggled);
		tglbtn_15D.setBackground(new Color(149, 174, 233));
		tglbtn_15D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15D = new GridBagConstraints();
		gbc_tglbtn_15D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_15D.gridx = 4;
		gbc_tglbtn_15D.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15D, gbc_tglbtn_15D);
		
		JToggleButton tglbtn_15E = new JToggleButton("15E");
		tglbtn_15E.addActionListener(seatBtnToggled);
		tglbtn_15E.setBackground(new Color(149, 174, 233));
		tglbtn_15E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15E = new GridBagConstraints();
		gbc_tglbtn_15E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_15E.gridx = 5;
		gbc_tglbtn_15E.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15E, gbc_tglbtn_15E);
		
		JToggleButton tglbtn_15F = new JToggleButton("15F");
		tglbtn_15F.addActionListener(seatBtnToggled);
		tglbtn_15F.setBackground(new Color(149, 174, 233));
		tglbtn_15F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_15F = new GridBagConstraints();
		gbc_tglbtn_15F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_15F.gridx = 6;
		gbc_tglbtn_15F.gridy = 16;
		panelSeatingBoeing.add(tglbtn_15F, gbc_tglbtn_15F);
		
		JToggleButton tglbtn_16A = new JToggleButton("16A");
		tglbtn_16A.addActionListener(seatBtnToggled);
		tglbtn_16A.setBackground(new Color(149, 174, 233));
		tglbtn_16A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16A = new GridBagConstraints();
		gbc_tglbtn_16A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_16A.gridx = 0;
		gbc_tglbtn_16A.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16A, gbc_tglbtn_16A);
		
		JToggleButton tglbtn_16B = new JToggleButton("16B");
		tglbtn_16B.addActionListener(seatBtnToggled);
		tglbtn_16B.setBackground(new Color(149, 174, 233));
		tglbtn_16B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16B = new GridBagConstraints();
		gbc_tglbtn_16B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_16B.gridx = 1;
		gbc_tglbtn_16B.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16B, gbc_tglbtn_16B);
		
		JToggleButton tglbtn_16C = new JToggleButton("16C");
		tglbtn_16C.addActionListener(seatBtnToggled);
		tglbtn_16C.setBackground(new Color(149, 174, 233));
		tglbtn_16C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16C = new GridBagConstraints();
		gbc_tglbtn_16C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_16C.gridx = 2;
		gbc_tglbtn_16C.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16C, gbc_tglbtn_16C);
		
		JToggleButton tglbtn_16D = new JToggleButton("16D");
		tglbtn_16D.addActionListener(seatBtnToggled);
		tglbtn_16D.setBackground(new Color(149, 174, 233));
		tglbtn_16D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16D = new GridBagConstraints();
		gbc_tglbtn_16D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_16D.gridx = 4;
		gbc_tglbtn_16D.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16D, gbc_tglbtn_16D);
		
		JToggleButton tglbtn_16E = new JToggleButton("16E");
		tglbtn_16E.addActionListener(seatBtnToggled);
		tglbtn_16E.setBackground(new Color(149, 174, 233));
		tglbtn_16E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16E = new GridBagConstraints();
		gbc_tglbtn_16E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_16E.gridx = 5;
		gbc_tglbtn_16E.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16E, gbc_tglbtn_16E);
		
		JToggleButton tglbtn_16F = new JToggleButton("16F");
		tglbtn_16F.addActionListener(seatBtnToggled);
		tglbtn_16F.setBackground(new Color(149, 174, 233));
		tglbtn_16F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_16F = new GridBagConstraints();
		gbc_tglbtn_16F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_16F.gridx = 6;
		gbc_tglbtn_16F.gridy = 17;
		panelSeatingBoeing.add(tglbtn_16F, gbc_tglbtn_16F);
		
		JToggleButton tglbtn_17A = new JToggleButton("17A");
		tglbtn_17A.addActionListener(seatBtnToggled);
		tglbtn_17A.setBackground(new Color(149, 174, 233));
		tglbtn_17A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17A = new GridBagConstraints();
		gbc_tglbtn_17A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_17A.gridx = 0;
		gbc_tglbtn_17A.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17A, gbc_tglbtn_17A);
		
		JToggleButton tglbtn_17B = new JToggleButton("17B");
		tglbtn_17B.addActionListener(seatBtnToggled);
		tglbtn_17B.setBackground(new Color(149, 174, 233));
		tglbtn_17B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17B = new GridBagConstraints();
		gbc_tglbtn_17B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_17B.gridx = 1;
		gbc_tglbtn_17B.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17B, gbc_tglbtn_17B);
		
		JToggleButton tglbtn_17C = new JToggleButton("17C");
		tglbtn_17C.addActionListener(seatBtnToggled);
		tglbtn_17C.setBackground(new Color(149, 174, 233));
		tglbtn_17C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17C = new GridBagConstraints();
		gbc_tglbtn_17C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_17C.gridx = 2;
		gbc_tglbtn_17C.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17C, gbc_tglbtn_17C);
		
		JToggleButton tglbtn_17D = new JToggleButton("17D");
		tglbtn_17D.addActionListener(seatBtnToggled);
		tglbtn_17D.setBackground(new Color(149, 174, 233));
		tglbtn_17D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17D = new GridBagConstraints();
		gbc_tglbtn_17D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_17D.gridx = 4;
		gbc_tglbtn_17D.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17D, gbc_tglbtn_17D);
		
		JToggleButton tglbtn_17E = new JToggleButton("17E");
		tglbtn_17E.addActionListener(seatBtnToggled);
		tglbtn_17E.setBackground(new Color(149, 174, 233));
		tglbtn_17E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17E = new GridBagConstraints();
		gbc_tglbtn_17E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_17E.gridx = 5;
		gbc_tglbtn_17E.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17E, gbc_tglbtn_17E);
		
		JToggleButton tglbtn_17F = new JToggleButton("17F");
		tglbtn_17F.addActionListener(seatBtnToggled);
		tglbtn_17F.setBackground(new Color(149, 174, 233));
		tglbtn_17F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_17F = new GridBagConstraints();
		gbc_tglbtn_17F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_17F.gridx = 6;
		gbc_tglbtn_17F.gridy = 18;
		panelSeatingBoeing.add(tglbtn_17F, gbc_tglbtn_17F);
		
		JToggleButton tglbtn_18A = new JToggleButton("18A");
		tglbtn_18A.addActionListener(seatBtnToggled);
		tglbtn_18A.setBackground(new Color(149, 174, 233));
		tglbtn_18A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18A = new GridBagConstraints();
		gbc_tglbtn_18A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_18A.gridx = 0;
		gbc_tglbtn_18A.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18A, gbc_tglbtn_18A);
		
		JToggleButton tglbtn_18B = new JToggleButton("18B");
		tglbtn_18B.addActionListener(seatBtnToggled);
		tglbtn_18B.setBackground(new Color(149, 174, 233));
		tglbtn_18B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18B = new GridBagConstraints();
		gbc_tglbtn_18B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_18B.gridx = 1;
		gbc_tglbtn_18B.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18B, gbc_tglbtn_18B);
		
		JToggleButton tglbtn_18C = new JToggleButton("18C");
		tglbtn_18C.addActionListener(seatBtnToggled);
		tglbtn_18C.setBackground(new Color(149, 174, 233));
		tglbtn_18C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18C = new GridBagConstraints();
		gbc_tglbtn_18C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_18C.gridx = 2;
		gbc_tglbtn_18C.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18C, gbc_tglbtn_18C);
		
		JToggleButton tglbtn_18D = new JToggleButton("18D");
		tglbtn_18D.addActionListener(seatBtnToggled);
		tglbtn_18D.setBackground(new Color(149, 174, 233));
		tglbtn_18D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18D = new GridBagConstraints();
		gbc_tglbtn_18D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_18D.gridx = 4;
		gbc_tglbtn_18D.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18D, gbc_tglbtn_18D);
		
		JToggleButton tglbtn_18E = new JToggleButton("18E");
		tglbtn_18E.addActionListener(seatBtnToggled);
		tglbtn_18E.setBackground(new Color(149, 174, 233));
		tglbtn_18E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18E = new GridBagConstraints();
		gbc_tglbtn_18E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_18E.gridx = 5;
		gbc_tglbtn_18E.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18E, gbc_tglbtn_18E);
		
		JToggleButton tglbtn_18F = new JToggleButton("18F");
		tglbtn_18F.addActionListener(seatBtnToggled);
		tglbtn_18F.setBackground(new Color(149, 174, 233));
		tglbtn_18F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_18F = new GridBagConstraints();
		gbc_tglbtn_18F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_18F.gridx = 6;
		gbc_tglbtn_18F.gridy = 19;
		panelSeatingBoeing.add(tglbtn_18F, gbc_tglbtn_18F);
		
		JToggleButton tglbtn_19A = new JToggleButton("19A");
		tglbtn_19A.addActionListener(seatBtnToggled);
		tglbtn_19A.setBackground(new Color(149, 174, 233));
		tglbtn_19A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19A = new GridBagConstraints();
		gbc_tglbtn_19A.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_19A.gridx = 0;
		gbc_tglbtn_19A.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19A, gbc_tglbtn_19A);
		
		JToggleButton tglbtn_19B = new JToggleButton("19B");
		tglbtn_19B.addActionListener(seatBtnToggled);
		tglbtn_19B.setBackground(new Color(149, 174, 233));
		tglbtn_19B.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19B = new GridBagConstraints();
		gbc_tglbtn_19B.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_19B.gridx = 1;
		gbc_tglbtn_19B.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19B, gbc_tglbtn_19B);
		
		JToggleButton tglbtn_19C = new JToggleButton("19C");
		tglbtn_19C.addActionListener(seatBtnToggled);
		tglbtn_19C.setBackground(new Color(149, 174, 233));
		tglbtn_19C.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19C = new GridBagConstraints();
		gbc_tglbtn_19C.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_19C.gridx = 2;
		gbc_tglbtn_19C.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19C, gbc_tglbtn_19C);
		
		JToggleButton tglbtn_19D = new JToggleButton("19D");
		tglbtn_19D.addActionListener(seatBtnToggled);
		tglbtn_19D.setBackground(new Color(149, 174, 233));
		tglbtn_19D.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19D = new GridBagConstraints();
		gbc_tglbtn_19D.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_19D.gridx = 4;
		gbc_tglbtn_19D.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19D, gbc_tglbtn_19D);
		
		JToggleButton tglbtn_19E = new JToggleButton("19E");
		tglbtn_19E.addActionListener(seatBtnToggled);
		tglbtn_19E.setBackground(new Color(149, 174, 233));
		tglbtn_19E.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19E = new GridBagConstraints();
		gbc_tglbtn_19E.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_19E.gridx = 5;
		gbc_tglbtn_19E.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19E, gbc_tglbtn_19E);
		
		JToggleButton tglbtn_19F = new JToggleButton("19F");
		tglbtn_19F.addActionListener(seatBtnToggled);
		tglbtn_19F.setBackground(new Color(149, 174, 233));
		tglbtn_19F.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_19F = new GridBagConstraints();
		gbc_tglbtn_19F.gridx = 6;
		gbc_tglbtn_19F.gridy = 20;
		panelSeatingBoeing.add(tglbtn_19F, gbc_tglbtn_19F);

		disableOccupiedSeats(panelSeatingBoeing);
	}
	
	public void getPanelAirbus(JScrollPane scrollPane, ActionListener seatBtnToggled) throws IOException {
		/**
		 * Assign Airbus panel to the scrollpane and initialise the seating plan layout.
		 */
		JPanel panelSeatingAirbus = new JPanel();
		scrollPane.setViewportView(panelSeatingAirbus);
		GridBagLayout gbl_panelSeatingAirbus = new GridBagLayout();
		gbl_panelSeatingAirbus.columnWidths = new int[]{41, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSeatingAirbus.rowHeights = new int[]{43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSeatingAirbus.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSeatingAirbus.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSeatingAirbus.setLayout(gbl_panelSeatingAirbus);
		
		JToggleButton tglbtn_1A = new JToggleButton("1A");
		tglbtn_1A.addActionListener(seatBtnToggled);
		tglbtn_1A.setBackground(new Color(153, 204, 153));
		tglbtn_1A.setMargin(new Insets(12, 12, 12, 12));
		GridBagConstraints gbc_tglbtn_1A = new GridBagConstraints();
		gbc_tglbtn_1A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_1A.gridx = 0;
		gbc_tglbtn_1A.gridy = 0;
		panelSeatingAirbus.add(tglbtn_1A, gbc_tglbtn_1A);
		
		// Create a horizontal strut to create empty space in the middle between seats
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 0;
		panelSeatingAirbus.add(horizontalStrut, gbc_horizontalStrut);
		
		JToggleButton tglbtn_1B = new JToggleButton("1B");
		tglbtn_1B.addActionListener(seatBtnToggled);
		tglbtn_1B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_1B.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_1B = new GridBagConstraints();
		gbc_tglbtn_1B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_1B.gridx = 6;
		gbc_tglbtn_1B.gridy = 0;
		panelSeatingAirbus.add(tglbtn_1B, gbc_tglbtn_1B);
		
		JToggleButton tglbtn_2A = new JToggleButton("2A");
		tglbtn_2A.addActionListener(seatBtnToggled);
		tglbtn_2A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_2A.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_2A = new GridBagConstraints();
		gbc_tglbtn_2A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_2A.gridx = 0;
		gbc_tglbtn_2A.gridy = 1;
		panelSeatingAirbus.add(tglbtn_2A, gbc_tglbtn_2A);
		
		JToggleButton tglbtn_2B = new JToggleButton("2B");
		tglbtn_2B.addActionListener(seatBtnToggled);
		tglbtn_2B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_2B.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_2B = new GridBagConstraints();
		gbc_tglbtn_2B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_2B.gridx = 6;
		gbc_tglbtn_2B.gridy = 1;
		panelSeatingAirbus.add(tglbtn_2B, gbc_tglbtn_2B);
		
		JToggleButton tglbtn_3A = new JToggleButton("3A");
		tglbtn_3A.addActionListener(seatBtnToggled);
		tglbtn_3A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_3A.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_3A = new GridBagConstraints();
		gbc_tglbtn_3A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_3A.gridx = 0;
		gbc_tglbtn_3A.gridy = 2;
		panelSeatingAirbus.add(tglbtn_3A, gbc_tglbtn_3A);
		
		JToggleButton tglbtn_3B = new JToggleButton("3B");
		tglbtn_3B.addActionListener(seatBtnToggled);
		tglbtn_3B.setActionCommand("2C");
		tglbtn_3B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_3B.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_3B = new GridBagConstraints();
		gbc_tglbtn_3B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_3B.gridx = 6;
		gbc_tglbtn_3B.gridy = 2;
		panelSeatingAirbus.add(tglbtn_3B, gbc_tglbtn_3B);
		
		JToggleButton tglbtn_4A = new JToggleButton("4A");
		tglbtn_4A.addActionListener(seatBtnToggled);
		tglbtn_4A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_4A.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_4A = new GridBagConstraints();
		gbc_tglbtn_4A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_4A.gridx = 0;
		gbc_tglbtn_4A.gridy = 3;
		panelSeatingAirbus.add(tglbtn_4A, gbc_tglbtn_4A);
		
		JToggleButton tglbtn_4B = new JToggleButton("4B");
		tglbtn_4B.addActionListener(seatBtnToggled);
		tglbtn_4B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_4B.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_4B = new GridBagConstraints();
		gbc_tglbtn_4B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_4B.gridx = 6;
		gbc_tglbtn_4B.gridy = 3;
		panelSeatingAirbus.add(tglbtn_4B, gbc_tglbtn_4B);
		
		JToggleButton tglbtn_5A = new JToggleButton("5A");
		tglbtn_5A.addActionListener(seatBtnToggled);
		tglbtn_5A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_5A.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_5A = new GridBagConstraints();
		gbc_tglbtn_5A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_5A.gridx = 0;
		gbc_tglbtn_5A.gridy = 4;
		panelSeatingAirbus.add(tglbtn_5A, gbc_tglbtn_5A);
		
		JToggleButton tglbtn_5B = new JToggleButton("5B");
		tglbtn_5B.addActionListener(seatBtnToggled);
		tglbtn_5B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_5B.setBackground(new Color(153, 204, 153));
		GridBagConstraints gbc_tglbtn_5B = new GridBagConstraints();
		gbc_tglbtn_5B.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_5B.gridx = 6;
		gbc_tglbtn_5B.gridy = 4;
		panelSeatingAirbus.add(tglbtn_5B, gbc_tglbtn_5B);
		
		// Create a vertical strut to create empty space between rows of seats
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridwidth = 7;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 5;
		panelSeatingAirbus.add(verticalStrut, gbc_verticalStrut);
		
		JToggleButton tglbtn_6A = new JToggleButton("6A");
		tglbtn_6A.addActionListener(seatBtnToggled);
		tglbtn_6A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6A = new GridBagConstraints();
		gbc_tglbtn_6A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6A.gridx = 0;
		gbc_tglbtn_6A.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6A, gbc_tglbtn_6A);
		
		JToggleButton tglbtn_6B = new JToggleButton("6B");
		tglbtn_6B.addActionListener(seatBtnToggled);
		tglbtn_6B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6B = new GridBagConstraints();
		gbc_tglbtn_6B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6B.gridx = 1;
		gbc_tglbtn_6B.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6B, gbc_tglbtn_6B);
		
		JToggleButton tglbtn_6C = new JToggleButton("6C");
		tglbtn_6C.addActionListener(seatBtnToggled);
		tglbtn_6C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6C = new GridBagConstraints();
		gbc_tglbtn_6C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6C.gridx = 2;
		gbc_tglbtn_6C.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6C, gbc_tglbtn_6C);
		
		JToggleButton tglbtn_6D = new JToggleButton("6D");
		tglbtn_6D.addActionListener(seatBtnToggled);
		tglbtn_6D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6D = new GridBagConstraints();
		gbc_tglbtn_6D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6D.gridx = 4;
		gbc_tglbtn_6D.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6D, gbc_tglbtn_6D);
		
		JToggleButton tglbtn_6E = new JToggleButton("6E");
		tglbtn_6E.addActionListener(seatBtnToggled);
		tglbtn_6E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6E = new GridBagConstraints();
		gbc_tglbtn_6E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_6E.gridx = 5;
		gbc_tglbtn_6E.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6E, gbc_tglbtn_6E);
		
		JToggleButton tglbtn_6F = new JToggleButton("6F");
		tglbtn_6F.addActionListener(seatBtnToggled);
		tglbtn_6F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_6F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_6F = new GridBagConstraints();
		gbc_tglbtn_6F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_6F.gridx = 6;
		gbc_tglbtn_6F.gridy = 6;
		panelSeatingAirbus.add(tglbtn_6F, gbc_tglbtn_6F);
		
		JToggleButton tglbtn_7A = new JToggleButton("7A");
		tglbtn_7A.addActionListener(seatBtnToggled);
		tglbtn_7A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7A = new GridBagConstraints();
		gbc_tglbtn_7A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7A.gridx = 0;
		gbc_tglbtn_7A.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7A, gbc_tglbtn_7A);
		
		JToggleButton tglbtn_7B = new JToggleButton("7B");
		tglbtn_7B.addActionListener(seatBtnToggled);
		tglbtn_7B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7B = new GridBagConstraints();
		gbc_tglbtn_7B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7B.gridx = 1;
		gbc_tglbtn_7B.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7B, gbc_tglbtn_7B);
		
		JToggleButton tglbtn_7C = new JToggleButton("7C");
		tglbtn_7C.addActionListener(seatBtnToggled);
		tglbtn_7C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7C = new GridBagConstraints();
		gbc_tglbtn_7C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7C.gridx = 2;
		gbc_tglbtn_7C.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7C, gbc_tglbtn_7C);
		
		JToggleButton tglbtn_7D = new JToggleButton("7D");
		tglbtn_7D.addActionListener(seatBtnToggled);
		tglbtn_7D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7D = new GridBagConstraints();
		gbc_tglbtn_7D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7D.gridx = 4;
		gbc_tglbtn_7D.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7D, gbc_tglbtn_7D);
		
		JToggleButton tglbtn_7E = new JToggleButton("7E");
		tglbtn_7E.addActionListener(seatBtnToggled);
		tglbtn_7E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7E = new GridBagConstraints();
		gbc_tglbtn_7E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_7E.gridx = 5;
		gbc_tglbtn_7E.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7E, gbc_tglbtn_7E);
		
		JToggleButton tglbtn_7F = new JToggleButton("7F");
		tglbtn_7F.addActionListener(seatBtnToggled);
		tglbtn_7F.setActionCommand("7F");
		tglbtn_7F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_7F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_7F = new GridBagConstraints();
		gbc_tglbtn_7F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_7F.gridx = 6;
		gbc_tglbtn_7F.gridy = 7;
		panelSeatingAirbus.add(tglbtn_7F, gbc_tglbtn_7F);
		
		JToggleButton tglbtn_8A = new JToggleButton("8A");
		tglbtn_8A.addActionListener(seatBtnToggled);
		tglbtn_8A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8A = new GridBagConstraints();
		gbc_tglbtn_8A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8A.gridx = 0;
		gbc_tglbtn_8A.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8A, gbc_tglbtn_8A);
		
		JToggleButton tglbtn_8B = new JToggleButton("8B");
		tglbtn_8B.addActionListener(seatBtnToggled);
		tglbtn_8B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8B = new GridBagConstraints();
		gbc_tglbtn_8B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8B.gridx = 1;
		gbc_tglbtn_8B.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8B, gbc_tglbtn_8B);
		
		JToggleButton tglbtn_8C = new JToggleButton("8C");
		tglbtn_8C.addActionListener(seatBtnToggled);
		tglbtn_8C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8C = new GridBagConstraints();
		gbc_tglbtn_8C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8C.gridx = 2;
		gbc_tglbtn_8C.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8C, gbc_tglbtn_8C);
		
		JToggleButton tglbtn_8D = new JToggleButton("8D");
		tglbtn_8D.addActionListener(seatBtnToggled);
		tglbtn_8D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8D = new GridBagConstraints();
		gbc_tglbtn_8D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8D.gridx = 4;
		gbc_tglbtn_8D.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8D, gbc_tglbtn_8D);
		
		JToggleButton tglbtn_8E = new JToggleButton("8E");
		tglbtn_8E.addActionListener(seatBtnToggled);
		tglbtn_8E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8E = new GridBagConstraints();
		gbc_tglbtn_8E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_8E.gridx = 5;
		gbc_tglbtn_8E.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8E, gbc_tglbtn_8E);
		
		JToggleButton tglbtn_8F = new JToggleButton("8F");
		tglbtn_8F.addActionListener(seatBtnToggled);
		tglbtn_8F.setActionCommand("8F");
		tglbtn_8F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_8F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_8F = new GridBagConstraints();
		gbc_tglbtn_8F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_8F.gridx = 6;
		gbc_tglbtn_8F.gridy = 8;
		panelSeatingAirbus.add(tglbtn_8F, gbc_tglbtn_8F);
		
		JToggleButton tglbtn_9A = new JToggleButton("9A");
		tglbtn_9A.addActionListener(seatBtnToggled);
		tglbtn_9A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9A = new GridBagConstraints();
		gbc_tglbtn_9A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9A.gridx = 0;
		gbc_tglbtn_9A.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9A, gbc_tglbtn_9A);
		
		JToggleButton tglbtn_9B = new JToggleButton("9B");
		tglbtn_9B.addActionListener(seatBtnToggled);
		tglbtn_9B.setActionCommand("9B");
		tglbtn_9B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9B = new GridBagConstraints();
		gbc_tglbtn_9B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9B.gridx = 1;
		gbc_tglbtn_9B.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9B, gbc_tglbtn_9B);
		
		JToggleButton tglbtn_9C = new JToggleButton("9C");
		tglbtn_9C.addActionListener(seatBtnToggled);
		tglbtn_9C.setActionCommand("9C");
		tglbtn_9C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9C = new GridBagConstraints();
		gbc_tglbtn_9C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9C.gridx = 2;
		gbc_tglbtn_9C.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9C, gbc_tglbtn_9C);
		
		JToggleButton tglbtn_9D = new JToggleButton("9D");
		tglbtn_9D.addActionListener(seatBtnToggled);
		tglbtn_9D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9D = new GridBagConstraints();
		gbc_tglbtn_9D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9D.gridx = 4;
		gbc_tglbtn_9D.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9D, gbc_tglbtn_9D);
		
		JToggleButton tglbtn_9E = new JToggleButton("9E");
		tglbtn_9E.addActionListener(seatBtnToggled);
		tglbtn_9E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9E = new GridBagConstraints();
		gbc_tglbtn_9E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_9E.gridx = 5;
		gbc_tglbtn_9E.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9E, gbc_tglbtn_9E);
		
		JToggleButton tglbtn_9F = new JToggleButton("9F");
		tglbtn_9F.addActionListener(seatBtnToggled);
		tglbtn_9F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_9F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_9F = new GridBagConstraints();
		gbc_tglbtn_9F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_9F.gridx = 6;
		gbc_tglbtn_9F.gridy = 9;
		panelSeatingAirbus.add(tglbtn_9F, gbc_tglbtn_9F);
		
		JToggleButton tglbtn_10A = new JToggleButton("10A");
		tglbtn_10A.addActionListener(seatBtnToggled);
		tglbtn_10A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10A = new GridBagConstraints();
		gbc_tglbtn_10A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10A.gridx = 0;
		gbc_tglbtn_10A.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10A, gbc_tglbtn_10A);
		
		JToggleButton tglbtn_10B = new JToggleButton("10B");
		tglbtn_10B.addActionListener(seatBtnToggled);
		tglbtn_10B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10B = new GridBagConstraints();
		gbc_tglbtn_10B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10B.gridx = 1;
		gbc_tglbtn_10B.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10B, gbc_tglbtn_10B);
		
		JToggleButton tglbtn_10C = new JToggleButton("10C");
		tglbtn_10C.addActionListener(seatBtnToggled);
		tglbtn_10C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10C = new GridBagConstraints();
		gbc_tglbtn_10C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10C.gridx = 2;
		gbc_tglbtn_10C.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10C, gbc_tglbtn_10C);
		
		JToggleButton tglbtn_10D = new JToggleButton("10D");
		tglbtn_10D.addActionListener(seatBtnToggled);
		tglbtn_10D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10D = new GridBagConstraints();
		gbc_tglbtn_10D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10D.gridx = 4;
		gbc_tglbtn_10D.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10D, gbc_tglbtn_10D);
		
		JToggleButton tglbtn_10E = new JToggleButton("10E");
		tglbtn_10E.addActionListener(seatBtnToggled);
		tglbtn_10E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10E = new GridBagConstraints();
		gbc_tglbtn_10E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_10E.gridx = 5;
		gbc_tglbtn_10E.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10E, gbc_tglbtn_10E);
		
		JToggleButton tglbtn_10F = new JToggleButton("10F");
		tglbtn_10F.addActionListener(seatBtnToggled);
		tglbtn_10F.setActionCommand("10F");
		tglbtn_10F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_10F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_10F = new GridBagConstraints();
		gbc_tglbtn_10F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_10F.gridx = 6;
		gbc_tglbtn_10F.gridy = 10;
		panelSeatingAirbus.add(tglbtn_10F, gbc_tglbtn_10F);
		
		JToggleButton tglbtn_11A = new JToggleButton("11A");
		tglbtn_11A.addActionListener(seatBtnToggled);
		tglbtn_11A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11A = new GridBagConstraints();
		gbc_tglbtn_11A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11A.gridx = 0;
		gbc_tglbtn_11A.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11A, gbc_tglbtn_11A);
		
		JToggleButton tglbtn_11B = new JToggleButton("11B");
		tglbtn_11B.addActionListener(seatBtnToggled);
		tglbtn_11B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11B = new GridBagConstraints();
		gbc_tglbtn_11B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11B.gridx = 1;
		gbc_tglbtn_11B.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11B, gbc_tglbtn_11B);
		
		JToggleButton tglbtn_11C = new JToggleButton("11C");
		tglbtn_11C.addActionListener(seatBtnToggled);
		tglbtn_11C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11C = new GridBagConstraints();
		gbc_tglbtn_11C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11C.gridx = 2;
		gbc_tglbtn_11C.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11C, gbc_tglbtn_11C);
		
		JToggleButton tglbtn_11D = new JToggleButton("11D");
		tglbtn_11D.addActionListener(seatBtnToggled);
		tglbtn_11D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11D = new GridBagConstraints();
		gbc_tglbtn_11D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11D.gridx = 4;
		gbc_tglbtn_11D.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11D, gbc_tglbtn_11D);
		
		JToggleButton tglbtn_11E = new JToggleButton("11E");
		tglbtn_11E.addActionListener(seatBtnToggled);
		tglbtn_11E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11E = new GridBagConstraints();
		gbc_tglbtn_11E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_11E.gridx = 5;
		gbc_tglbtn_11E.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11E, gbc_tglbtn_11E);
		
		JToggleButton tglbtn_11F = new JToggleButton("11F");
		tglbtn_11F.addActionListener(seatBtnToggled);
		tglbtn_11F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_11F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_11F = new GridBagConstraints();
		gbc_tglbtn_11F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_11F.gridx = 6;
		gbc_tglbtn_11F.gridy = 11;
		panelSeatingAirbus.add(tglbtn_11F, gbc_tglbtn_11F);
		
		JToggleButton tglbtn_12A = new JToggleButton("12A");
		tglbtn_12A.addActionListener(seatBtnToggled);
		tglbtn_12A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12A = new GridBagConstraints();
		gbc_tglbtn_12A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12A.gridx = 0;
		gbc_tglbtn_12A.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12A, gbc_tglbtn_12A);
		
		JToggleButton tglbtn_12B = new JToggleButton("12B");
		tglbtn_12B.addActionListener(seatBtnToggled);
		tglbtn_12B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12B = new GridBagConstraints();
		gbc_tglbtn_12B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12B.gridx = 1;
		gbc_tglbtn_12B.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12B, gbc_tglbtn_12B);
		
		JToggleButton tglbtn_12C = new JToggleButton("12C");
		tglbtn_12C.addActionListener(seatBtnToggled);
		tglbtn_12C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12C = new GridBagConstraints();
		gbc_tglbtn_12C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12C.gridx = 2;
		gbc_tglbtn_12C.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12C, gbc_tglbtn_12C);
		
		JToggleButton tglbtn_12D = new JToggleButton("12D");
		tglbtn_12D.addActionListener(seatBtnToggled);
		tglbtn_12D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12D = new GridBagConstraints();
		gbc_tglbtn_12D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12D.gridx = 4;
		gbc_tglbtn_12D.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12D, gbc_tglbtn_12D);
		
		JToggleButton tglbtn_12E = new JToggleButton("12E");
		tglbtn_12E.addActionListener(seatBtnToggled);
		tglbtn_12E.setActionCommand("12E");
		tglbtn_12E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12E = new GridBagConstraints();
		gbc_tglbtn_12E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_12E.gridx = 5;
		gbc_tglbtn_12E.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12E, gbc_tglbtn_12E);
		
		JToggleButton tglbtn_12F = new JToggleButton("12F");
		tglbtn_12F.addActionListener(seatBtnToggled);
		tglbtn_12F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_12F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_12F = new GridBagConstraints();
		gbc_tglbtn_12F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_12F.gridx = 6;
		gbc_tglbtn_12F.gridy = 12;
		panelSeatingAirbus.add(tglbtn_12F, gbc_tglbtn_12F);
		
		JToggleButton tglbtn_13A = new JToggleButton("13A");
		tglbtn_13A.addActionListener(seatBtnToggled);
		tglbtn_13A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13A = new GridBagConstraints();
		gbc_tglbtn_13A.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13A.gridx = 0;
		gbc_tglbtn_13A.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13A, gbc_tglbtn_13A);
		
		JToggleButton tglbtn_13B = new JToggleButton("13B");
		tglbtn_13B.addActionListener(seatBtnToggled);
		tglbtn_13B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13B = new GridBagConstraints();
		gbc_tglbtn_13B.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13B.gridx = 1;
		gbc_tglbtn_13B.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13B, gbc_tglbtn_13B);
		
		JToggleButton tglbtn_13C = new JToggleButton("13C");
		tglbtn_13C.addActionListener(seatBtnToggled);
		tglbtn_13C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13C = new GridBagConstraints();
		gbc_tglbtn_13C.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13C.gridx = 2;
		gbc_tglbtn_13C.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13C, gbc_tglbtn_13C);
		
		JToggleButton tglbtn_13D = new JToggleButton("13D");
		tglbtn_13D.addActionListener(seatBtnToggled);
		tglbtn_13D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13D = new GridBagConstraints();
		gbc_tglbtn_13D.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13D.gridx = 4;
		gbc_tglbtn_13D.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13D, gbc_tglbtn_13D);
		
		JToggleButton tglbtn_13E = new JToggleButton("13E");
		tglbtn_13E.addActionListener(seatBtnToggled);
		tglbtn_13E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13E = new GridBagConstraints();
		gbc_tglbtn_13E.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtn_13E.gridx = 5;
		gbc_tglbtn_13E.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13E, gbc_tglbtn_13E);
		
		JToggleButton tglbtn_13F = new JToggleButton("13F");
		tglbtn_13F.addActionListener(seatBtnToggled);
		tglbtn_13F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_13F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_13F = new GridBagConstraints();
		gbc_tglbtn_13F.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtn_13F.gridx = 6;
		gbc_tglbtn_13F.gridy = 13;
		panelSeatingAirbus.add(tglbtn_13F, gbc_tglbtn_13F);
		
		JToggleButton tglbtn_14A = new JToggleButton("14A");
		tglbtn_14A.addActionListener(seatBtnToggled);
		tglbtn_14A.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14A.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14A = new GridBagConstraints();
		gbc_tglbtn_14A.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_14A.gridx = 0;
		gbc_tglbtn_14A.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14A, gbc_tglbtn_14A);
		
		JToggleButton tglbtn_14B = new JToggleButton("14B");
		tglbtn_14B.addActionListener(seatBtnToggled);
		tglbtn_14B.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14B.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14B = new GridBagConstraints();
		gbc_tglbtn_14B.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_14B.gridx = 1;
		gbc_tglbtn_14B.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14B, gbc_tglbtn_14B);
		
		JToggleButton tglbtn_14C = new JToggleButton("14C");
		tglbtn_14C.addActionListener(seatBtnToggled);
		tglbtn_14C.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14C.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14C = new GridBagConstraints();
		gbc_tglbtn_14C.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_14C.gridx = 2;
		gbc_tglbtn_14C.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14C, gbc_tglbtn_14C);
		
		JToggleButton tglbtn_14D = new JToggleButton("14D");
		tglbtn_14D.addActionListener(seatBtnToggled);
		tglbtn_14D.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14D.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14D = new GridBagConstraints();
		gbc_tglbtn_14D.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_14D.gridx = 4;
		gbc_tglbtn_14D.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14D, gbc_tglbtn_14D);
		
		JToggleButton tglbtn_14E = new JToggleButton("14E");
		tglbtn_14E.addActionListener(seatBtnToggled);
		tglbtn_14E.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14E.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14E = new GridBagConstraints();
		gbc_tglbtn_14E.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtn_14E.gridx = 5;
		gbc_tglbtn_14E.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14E, gbc_tglbtn_14E);
		
		JToggleButton tglbtn_14F = new JToggleButton("14F");
		tglbtn_14F.addActionListener(seatBtnToggled);
		tglbtn_14F.setMargin(new Insets(12, 12, 12, 12));
		tglbtn_14F.setBackground(new Color(149, 174, 233));
		GridBagConstraints gbc_tglbtn_14F = new GridBagConstraints();
		gbc_tglbtn_14F.gridx = 6;
		gbc_tglbtn_14F.gridy = 14;
		panelSeatingAirbus.add(tglbtn_14F, gbc_tglbtn_14F);

		disableOccupiedSeats(panelSeatingAirbus);
	}
	
	// Method for making any seats already occupied by other passengers for the same flight not toggleable
	public void disableOccupiedSeats(JPanel panelSeating) throws IOException {
		String flightNumber;
		
		// Get the flight number for the currently viewed seating plan
		if (bookingType == "departure") {
			flightNumber = SeatingPlan.selectedDFlight.flightNumber;
		} else {
			flightNumber = SeatingPlan.selectedRFlight.flightNumber;
		}
		
		// Get the occupied seats for the currently viewed seating plan (if any)
		ArrayList<String> occupiedSeats = (SeatingPlan.getSeating(flightNumber));
		
		// Get all components from the seating panel
		Component[] allComponents = panelSeating.getComponents();
		
		// Loop through the components and check which of them are of class JToggleButton..
		for (Integer i = 0; i < allComponents.length; i++) {
			Object compClass = allComponents[i].getClass();
			if (compClass ==  JToggleButton.class) {
				JToggleButton currentButton = (JToggleButton) panelSeating.getComponents()[i];
				String textOfButton = currentButton.getText();
				// ..check if the currently looped button is in the occupiedSeats ArrayList,
				// and if so, disable that button and make it gray.
				if (occupiedSeats.contains(textOfButton)) {
					currentButton.setEnabled(false);
					currentButton.setBackground(new Color(192,192,192));
				}
			}
		}
	}
}
