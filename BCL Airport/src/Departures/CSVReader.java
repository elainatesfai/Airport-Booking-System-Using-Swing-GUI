package Departures;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class CSVReader {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSVReader window = new CSVReader();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public CSVReader() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		File csvFile = new File("C:\\Users\\Kev\\Desktop\\Programming - Eclipse Work\\WindowBuilder\\src\\WindowBuilder\\Flights.csv");
		BufferedReader rd = new BufferedReader(new FileReader(csvFile));//reads the file
		String line = "";
		try {
			while((line = rd.readLine()) != null) {
				String[] count = line.split(",");
				System.out.println(count[1]+" "+ count[2]+" "+count[3]+" "+count[6]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);//counts which line to use
			}
		} catch(FileNotFoundException e) {
				e.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
	
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 434, 261);
		panel.add(lblNewLabel);
	}
}
