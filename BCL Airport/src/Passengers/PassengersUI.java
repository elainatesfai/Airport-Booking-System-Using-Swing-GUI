package Passengers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PassengersUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField FnametextField;
	private JTextField LnametextField;
	private JTextField DOBtextField;
	private JTextField EmailtextField;
	private JTextField teltextField;
	private JTextField bagstextField;
	private JComboBox dSeatcomboBox;
	private JComboBox aSeatcomboBox;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					PassengersUI frame = new PassengersUI();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 
	}

	/**
	 * Create the frame.
	 */
	
	public PassengersUI() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) 
			{
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel nameLabel = new JLabel("First name on passport:");
		nameLabel.setBounds(10, 111, 146, 14);
		contentPane.add(nameLabel);
		
		JLabel lblNewLabel = new JLabel("Last name on passport:");
		lblNewLabel.setBounds(10, 144, 146, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passanger Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 61, 122, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Flight Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(280, 63, 102, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of birth:");
		lblNewLabel_3.setBounds(10, 175, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telephone number:");
		lblNewLabel_4.setBounds(10, 207, 146, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email address:");
		lblNewLabel_5.setBounds(10, 239, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Number of bags:");
		lblNewLabel_6.setBounds(298, 111, 93, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Departure seat number:");
		lblNewLabel_7.setBounds(298, 175, 170, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Arrival seat number:");
		lblNewLabel_8.setBounds(298, 207, 132, 14);
		contentPane.add(lblNewLabel_8);
		
		FnametextField = new JTextField();
		FnametextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		FnametextField.setBounds(156, 108, 102, 20);
		contentPane.add(FnametextField);
		FnametextField.setColumns(10);
		
		
		
		LnametextField = new JTextField();
		LnametextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LnametextField.setBounds(156, 141, 102, 20);
		contentPane.add(LnametextField);
		LnametextField.setColumns(10);
		
		DOBtextField = new JTextField();
		DOBtextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DOBtextField.setBounds(156, 172, 102, 20);
		contentPane.add(DOBtextField);
		DOBtextField.setColumns(10);
		
		EmailtextField = new JTextField();
		EmailtextField.setBounds(156, 236, 102, 20);
		contentPane.add(EmailtextField);
		EmailtextField.setColumns(10);
		
		teltextField = new JTextField();
		teltextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		teltextField.setBounds(156, 204, 102, 20);
		contentPane.add(teltextField);
		teltextField.setColumns(10);
		
		bagstextField = new JTextField();
		bagstextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bagstextField.setBounds(447, 108, 66, 20);
		contentPane.add(bagstextField);
		bagstextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 120, 50));
		panel.setBounds(0, 0, 576, 55);
		contentPane.add(panel);
		
		JLabel lblNewLabel_9 = new JLabel("Brunel London City Airport");
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBackground(new Color(0, 0, 255));
		
		JComboBox dSeatcomboBox = new JComboBox();
		dSeatcomboBox.setToolTipText("Select");
		dSeatcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dSeat=(String) dSeatcomboBox.getSelectedItem();
				
			}
		});
		dSeatcomboBox.setBounds(447, 171, 93, 22);
		contentPane.add(dSeatcomboBox);
		
		JComboBox aSeatcomboBox = new JComboBox();
		aSeatcomboBox.setToolTipText("Select");
		aSeatcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		aSeatcomboBox.setBounds(447, 203, 93, 22);
		contentPane.add(aSeatcomboBox);
		
		JButton SelectSeatButton = new JButton("Display Selected Seats");
		SelectSeatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Define ASeatArr with the values of the ASeatArrList ArrayList converted back into the array type
				String[] ASeatArr= Passengers.ASeatArrList.toArray(new String[Passengers.ASeatArrList.size()]);
				
				for(int i=0;i<=ASeatArr.length;i++) {
				DefaultComboBoxModel modA= new DefaultComboBoxModel(ASeatArr);
				aSeatcomboBox.setModel(modA);
				}
				// Define DSeatArr with the values of DSeatArrList ArrayList converted back into the array type
				String[] DSeatArr = Passengers.DSeatArrList.toArray(new String[Passengers.DSeatArrList.size()]);
				
				DefaultComboBoxModel modD= new DefaultComboBoxModel(DSeatArr);
				dSeatcomboBox.setModel(modD);
				String selectedDSeat=(String) dSeatcomboBox.getSelectedItem();
			//	if (selectedDSeat==null)
			//	{
			//		JOptionPane.showInputDialog("Please select a departure seat number");
			//	}
			//	String selectedASeat=(String) aSeatcomboBox.getSelectedItem();
			}
				
		});
		SelectSeatButton.setBounds(331, 144, 182, 23);
		contentPane.add(SelectSeatButton);
		
		JButton ContinueButton = new JButton("Continue");
		ContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int noticket=3;
				
			    //checking if first name is valid
				String fname=FnametextField.getText();  // getting input from user
				boolean fn= Passengers.getFname(fname); // calling the getFname method from the Passengers class
			
				
				//checking if last name is valid 
				String surname=LnametextField.getText();  //getting the input
				boolean ln=Passengers.getLname(surname);  //calling getLname method from Passengers class
			
				//checking if number of dob is valid
				String dob=DOBtextField.getText();  //getting the input
				boolean DOB=Passengers.getDOB(dob); //calling the getDOB method from the Passengers class
				
				
				// checking if tel is valid
			     if(teltextField.getText().equals("")) //checking if the textfield is empty
			     {
			    	 JOptionPane.showMessageDialog(contentPane, "Please enter a valid telephone number."); //it it is empty print message
			     }
			     else //if its not empty:
			     {
			    	 int tel= Integer.parseInt(teltextField.getText()); //get the input
				     boolean TEL= Passengers.getTel(tel); //call the getTel method from the Passengers class
			     }
			     
			 
				//checking if email address is valid
			    String email=EmailtextField.getText();//getting the input
			    boolean EMAIL= Passengers.getEmail(email);//calling the getEmail class from the Passengers class
			   
			   
				//checking if number of bags is valid
			    int bags=Integer.parseInt(bagstextField.getText());// getting input
				boolean BAGS=Passengers.getBags(bags); //calling the getBags class from the Passengers class
			    
				
				//generate random number if all fields are valid
				int tel= Integer.parseInt(teltextField.getText());//getting the input 
				boolean ticketno=Passengers.ticket(fname, surname, dob, tel, email, bags); //calling the method to display ticket number
				
				// After ticket number is displayed the current window will be set to not visible,
				// and a new window will be created if there are any more number of tickets remaining
				if(ticketno) {
				setVisible(false);
				

				// Get the string values of currently selected seats
				Passengers.selectedDSeat = (String) dSeatcomboBox.getSelectedItem();
				Passengers.selectedASeat = (String) aSeatcomboBox.getSelectedItem();
				
				// Remove those seats from their respective ArrayLists
				Passengers.DSeatArrList.remove(Passengers.selectedDSeat);
				Passengers.ASeatArrList.remove(Passengers.selectedASeat);
				}
				}
			
		});
		ContinueButton.setBounds(443, 275, 89, 23);
		contentPane.add(ContinueButton);
		// Set the frame visible after the PassengerUI method is called and all variables within it have been assigned
		setVisible(true);
		
	}
	}
	
	
	

