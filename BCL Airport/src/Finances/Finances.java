package Finances;
import java.util.Random;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import Flights.bclAirport;


public class Finances extends JFrame {

	JTable table;
	JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	static Random rand = new Random();
	static JFrame financesFrame = new JFrame();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finances frame = new Finances();
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
	public Finances() {
		// Content pane:
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 850, 500);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(238, 238, 238));
				contentPane.setBorder(new LineBorder(Color.BLACK));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				// panel:
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 850, 100);
				panel.setBackground(new Color(44, 120, 50));
				panel.setForeground(new Color(0, 0, 0));
				panel.setBorder(new LineBorder(Color.BLACK));
				contentPane.add(panel);
				panel.setLayout(null);

				// Title:
				JLabel lblNewLabel = new JLabel("Brunel City London Airport");
				lblNewLabel.setBounds(114, 0, 636, 98);
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 50));
				lblNewLabel.setForeground(Color.WHITE);
				panel.add(lblNewLabel);

				// JTable
				String[] columns = { "First Name", "Surname", "Date of Birth", "Ticket Number", "Bag Costs", "Ticket Costs",
						"Food Costs", "Compensation", "Total" };

				String[][] data = getFinancialDetails();

				table = new JTable(data, columns);
				table.setEnabled(false);
				table.setBounds(6, 140, 838, 64);
				table.setBorder(new LineBorder(Color.BLACK));
				table.setShowGrid(true);
				table.setGridColor(Color.BLACK);

				contentPane.add(table);
				
				table.addMouseListener(new java.awt.event.MouseAdapter()
	            {
					public void mouseClicked(java.awt.event.MouseEvent e)

					{
						Error1 error1 = new Error1();
						error1.setVisible(true);
						error1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
	            });

				JLabel lblNewLabel_1 = new JLabel("Finances:");
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				lblNewLabel_1.setBounds(10, 112, 89, 16);
				contentPane.add(lblNewLabel_1);
				
				JButton btnNewButton = new JButton("Home");
				btnNewButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent e) {
						
						bclAirport home = null;
						
						try {
							home = new bclAirport();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							home.main(null);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
				});
				
				btnNewButton.setBounds(6, 437, 117, 29);
				contentPane.add(btnNewButton);
	}
	
	// algorithm 1:

	@SuppressWarnings("unused")
	public static String[][] getFinancialDetails() {
		// Data Structures
		String dFlight[] = { "08/03/2022", "06:20", "11:57", "05:37", "7021.04", "179", "HND", "Tokyo", "SYD", "Sydney",
				"TS4977", "Easyplane" };
		String rFlight[] = { "27/03/2022", "18:23", "03:44", "09:21", "11687.85", "10", "SYD", "Sydney", "", "Tokyo",
				"ST4138", "Eastair" };
		String passengers[][] = { { "Aaron", "Samuels", "83746578", "1A", "first-class" },
				{ "Regina", "George", "27475839", "6A", "business" },
				{ "Cady", "Heron", "95738494", "95738494", "economy" } };

		// inputed variables for methods

		double dDistance = Double.parseDouble(dFlight[4]);
		double rDistance = Double.parseDouble(rFlight[4]);
		int dDelayTime = Integer.parseInt(dFlight[5]);
		int rDelayTime = Integer.parseInt(rFlight[5]);

		String jTableData[][] = new String[4][9];

		jTableData[0][0] = "First Name";
		jTableData[0][1] = "Surname";
		jTableData[0][2] = "Date of Birth";
		jTableData[0][3] = "Ticket Number";
		jTableData[0][4] = "Bag Costs";
		jTableData[0][5] = "Ticket Costs";
		jTableData[0][6] = "Food Costs";
		jTableData[0][7] = "Compensation";
		jTableData[0][8] = "Total";

		for (int i = 1; i < 4; i++) {

			jTableData[i][0] = passengers[i - 1][0]; // first name
			jTableData[i][1] = passengers[i - 1][1]; // surname
			jTableData[i][2] = "null"; // date of birth
			jTableData[i][3] = passengers[i - 1][2]; // ticket

			double bagCosts = getBagCosts();
			double ticketCosts = getTicketCosts(passengers[i - 1][4], dDistance, rDistance);
			double foodCosts = getFoodCosts();
			double compensation = getFoodCosts();
			double overallCosts = getOverallCosts(bagCosts, ticketCosts, foodCosts, compensation);

			jTableData[i][4] = twoDP(bagCosts); // bag costs
			jTableData[i][5] = twoDP(ticketCosts); // ticket costs
			jTableData[i][6] = twoDP(foodCosts); // food costs
			jTableData[i][7] = twoDP(compensation); // compensation
			jTableData[i][8] = twoDP(overallCosts); // overall costs

		}
		return jTableData;
	}

	// algorithm 2:
	public static double getBagCosts() {
		int bags = rand.nextInt(10);

		if (bags > 1) {
			return ((bags - 1) * 25);
		}

		else {
			return 0;
		}
	}

	// algorithm 3:
	public static double getTicketCosts(String classCategory, double dDistance, double rDistance) {
		double ticketCost = 0;

		// Departure Ticket Costs:
		if (classCategory == "economy") {
			ticketCost = (rDistance * 0.5) + (dDistance * 0.5);

		}

		if (classCategory == "business") {
			ticketCost = (rDistance * 1) + (dDistance * 1);
		}

		if (classCategory == "first-class") {
			ticketCost = (rDistance * 1.5) + (dDistance * 1.5);
		}

		else {
			return (ticketCost);
		}

		return (ticketCost);

	}

	// algorithm 4:
	public static double getFoodCosts() {
		double totalPrice = rand.nextDouble(100);
		return totalPrice;

	}

	
	// algorithm 5:
	public static double getCompensationCosts(int dDelayTime, int rDelayTime) {
		double dCompensation = 0;
		double rCompensation = 0;

		// Departure Flight Compensation
		if (dDelayTime < 60) {
			dCompensation = 0;
		}
		if ((dDelayTime > 60) && (dDelayTime <= 120)) {
			dCompensation = 100;
		}

		if ((dDelayTime > 120) && (dDelayTime <= 180)) {
			dCompensation = 200;
		}

		if (dDelayTime > 180) {
			dCompensation = 300;
		}

		// Returning Flight Compensation
		if ((rDelayTime > 60) && (rDelayTime <= 120)) {
			rCompensation = 100;
		}

		if ((rDelayTime > 120) && (rDelayTime <= 180)) {
			rCompensation = 200;
		}

		if (rDelayTime > 180) {
			rCompensation = 300;
		}

		else {
			rCompensation = 0;
		}

		return (dCompensation + rCompensation);
	}
	
	// algorithm 6:
	public static double getOverallCosts(double bagCosts, double ticketCosts, double foodCosts, double compensation) {
		return ((bagCosts + ticketCosts + foodCosts) - compensation);

	}

	public static String twoDP(double number) {

		DecimalFormat numberFormat = new DecimalFormat("#.###");
		String formatted_string = numberFormat.format(number);
		formatted_string = String.format("%.2f", number);

		return formatted_string;
	}
}
