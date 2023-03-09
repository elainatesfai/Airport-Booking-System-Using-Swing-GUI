package Restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.border.LineBorder;

import Flights.bclAirport;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Flights.bclAirport;

public class Restaurant {
	
	private JFrame frmPassangerDetails;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	//Error1 is for the error handling message 
	Error1 frame1 = new Error1();
	
	//Menu has been called to call the next window (Jframe)
	Menu frame = new Menu();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant window = new Restaurant();
					window.frmPassangerDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Restaurant() {
		//Rommel is a name class
		Rommel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void Rommel() {
		frmPassangerDetails = new JFrame();
		frmPassangerDetails.setTitle("Passanger Details");
		frmPassangerDetails.getContentPane().setBackground(new Color(44, 120, 50));
		frmPassangerDetails.setBounds(100, 100, 450, 300);
		//frmPassangerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPassangerDetails.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(112, 112, 112), 6));
		panel.setBounds(31, 25, 369, 213);
		frmPassangerDetails.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name on passport");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(84, 68, 184, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(84, 48, 184, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastNameOn = new JLabel("Last name on passport");
		lblLastNameOn.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLastNameOn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastNameOn.setBounds(84, 113, 184, 14);
		panel.add(lblLastNameOn);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 93, 184, 20);
		panel.add(textField_1);
		
		JLabel lblPlan = new JLabel("Plane ticket number");
		lblPlan.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlan.setBounds(84, 159, 184, 14);
		panel.add(lblPlan);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 138, 184, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger Details");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 11, 145, 23);
		panel.add(lblNewLabel_1);
		
		 
          // Button for next window
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mousePressed(MouseEvent e)
			{
				//For this array I tried to use this but un-able to work it out so what I did is a simple logging in system that only apply indiviually.
				// ArrayList<String> passenger = new ArrayList();
				// String seat = "3A";

		        //  passenger.add(seat);

		       //   passenger.add("economy");

		       //   String fname = ("John");

		        //  passenger.add(fname);

		        //  passenger.add("Greenwood");

		        //  passenger.add("02/03/2022");

		        //  passenger.add("12345678");
		         

		        //  passenger.add("4");

		        //  passenger.add("30.99");
				
				// int x holding the value that Textfield has.
				int x = Integer.parseInt(textField_2.getText()) ;
				//Fname holds the value of textField.
				String Fname = textField.getText();
				//Lname holds the value of textField_1.
				String Lname = textField_1.getText();
				
	
				//this is the condition where the input of the user undergo and validated.
				if (Fname.equals("Rommel") && Lname.equals("Goce") && 	x == 2149193 )
					
				{
					//called the next window.
					frame.setVisible(true);
					//telling the program to close this window once they condition have met.
					frmPassangerDetails.dispose();
					
				
					
		    	}
				
				
				else
				{
					//calling the error handling message.
					frame1.setVisible(true);
		
				}
				
			}
		
			
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(269, 179, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			
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
		btnNewButton_1.setBounds(6, 237, 117, 29);
		frmPassangerDetails.getContentPane().add(btnNewButton_1);
	
		
		
		
		
	}
}

