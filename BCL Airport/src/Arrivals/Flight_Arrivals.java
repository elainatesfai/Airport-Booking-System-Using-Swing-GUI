package Arrivals;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import Flights.bclAirport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Arrivals.*;

@SuppressWarnings("unused")
public class Flight_Arrivals {

	private JFrame frame;
	private JTextField txtDepTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSV.mainin();
					Flight_Arrivals window = new Flight_Arrivals();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Flight_Arrivals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1248, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("MEX");
		lblNewLabel_28.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) { //brings up the pop up tab tab when the mouse is hovered over 
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) { //when the mouse leaves the hover over zone, the pop up tab will automatically close 
				frame.setVisible(false);
			}
		});
		lblNewLabel_28.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_28.setBounds(109, 314, 25, 13);
		frame.getContentPane().add(lblNewLabel_28);
		
		JLabel lblNewLabel_27 = new JLabel("DFW");
		lblNewLabel_27.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_27.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_27.setBounds(131, 275, 32, 13);
		frame.getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_26 = new JLabel("LVS");
		lblNewLabel_26.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_26.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_26.setBounds(92, 263, 21, 13);
		frame.getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_25 = new JLabel("YYZ");
		lblNewLabel_25.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_25.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_25.setBounds(211, 231, 25, 13);
		frame.getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_24 = new JLabel("JFK");
		lblNewLabel_24.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_24.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_24.setBounds(195, 259, 24, 13);
		frame.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_23 = new JLabel("GRU");
		lblNewLabel_23.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_23.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_23.setBounds(269, 462, 23, 13);
		frame.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_22 = new JLabel("LOS");
		lblNewLabel_22.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_22.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_22.setBounds(437, 364, 32, 13);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_21 = new JLabel("JNB");
		lblNewLabel_21.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_21.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_21.setBounds(507, 481, 23, 13);
		frame.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_20 = new JLabel("CAI");
		lblNewLabel_20.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_20.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_20.setBounds(512, 296, 23, 13);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_19 = new JLabel("ATH");
		lblNewLabel_19.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_19.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_19.setBounds(490, 259, 32, 13);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_18 = new JLabel("FCO\r\n");
		lblNewLabel_18.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_18.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_18.setBounds(460, 250, 38, 13);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_17 = new JLabel("DUB");
		lblNewLabel_17.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_17.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_17.setBounds(396, 210, 23, 13);
		frame.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_16 = new JLabel("ARN");
		lblNewLabel_16.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_16.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_16.setBounds(470, 188, 23, 13);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_15 = new JLabel("SVO");
		lblNewLabel_15.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_15.setBounds(525, 199, 23, 13);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("AMS");
		lblNewLabel_14.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_14.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_14.setBounds(432, 220, 23, 13);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_13 = new JLabel("RAK");
		lblNewLabel_13.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_13.setBounds(396, 288, 23, 13);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("HND");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_12.setBounds(817, 270, 32, 13);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("DXB");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_11.setBounds(592, 307, 32, 13);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("CDG");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_10.setBounds(422, 232, 32, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("LIS");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_9.setBounds(397, 260, 23, 13);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("MAD");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_8.setBounds(413, 255, 32, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("SYD");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_7.setBounds(860, 501, 23, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("HKG");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_6.setBounds(765, 310, 23, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("BKK");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_5.setBounds(735, 331, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("DEL");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_4.setBounds(656, 300, 23, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(44, 120, 50)); //Specific Green background for the top panel 
		panel.setBounds(0, 0, 1232, 119);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Brunel City London Airport Arrivals"); //Main banner for the BCL page
		lblNewLabel_1.setBounds(376, 30, 485, 37);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 32));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Home"); //Home button is supposed to take the user back to the main page 
		btnNewButton.setBackground(new Color(46, 95, 212));
		btnNewButton.setBounds(10, 44, 89, 23);
		panel.add(btnNewButton);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("BCL");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {

			Popup frame = new Popup();
			public void mouseEntered(MouseEvent entered) {
				frame.setVisible(true);
			}
			public void mouseExited(MouseEvent exited) {
				frame.setVisible(false);
			}
		});
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(422, 210, 23, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblNewLabel.setBackground(new Color(44, 120, 50));
		lblNewLabel.setIcon(new ImageIcon("Resources/BCL Map.png")); //file for the map 
		lblNewLabel.setBounds(10, 55, 1147, 607);
		frame.getContentPane().add(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 69, 1127, -67);
		frame.getContentPane().add(desktopPane);
		
		JLabel lblNewLabel_2 = new JLabel("         Delays");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 32));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(959, 120, 263, 471);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(959, 181, 263, 411);
		frame.getContentPane().add(scrollPane);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model); //JList created to show all the flights in 
		for (int i = 0; i < CSV.delays.size(); i++) { 
		 model.add(i, CSV.delays.get(i)); //output for delays
	}
		scrollPane.setViewportView(list); 
		
		txtDepTime = new JTextField();
		txtDepTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDepTime.setText("Dep Time | Arr Time | Delay | Dep apt | Arr apt | Airline"); //information based on what each piece of data means on the delay tab 
		txtDepTime.setBounds(959, 161, 263, 20);
		frame.getContentPane().add(txtDepTime);
		txtDepTime.setColumns(10);
}	
 }
