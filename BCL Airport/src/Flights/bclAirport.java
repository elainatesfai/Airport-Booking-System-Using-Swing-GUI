package Flights;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Arrivals.Flight_Arrivals;
import Departures.Departures;
import Finances.Finances;
import Restaurant.Restaurant;


@SuppressWarnings("serial")
public class bclAirport extends JFrame {

	JPanel flightsFrame;
	
	/**
	 * Launch the application.
	 */
		static Random rand = new Random();
		
		public static void main(String[] args) throws IOException {
			importFlights();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						bclAirport frame = new bclAirport();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 * @throws ParseException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		public bclAirport() throws ParseException {
			
			//JCalender
			JCalendar calendar = new JCalendar();
			setBounds(100, 100, 850, 500);
			
			//content pane
			getContentPane().add(calendar);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for the calendars presented 
			setBounds(100, 100, 835, 504);
			JPanel flightsFrame = new JPanel();
			flightsFrame.setBorder(new LineBorder(Color.BLACK));
			setContentPane(flightsFrame);
			flightsFrame.setLayout(null);
			
			// panel:
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 850, 100);
			//46, 95, 212 - blue
			panel.setBackground(new Color(44, 120, 50));
			panel.setForeground(new Color(0, 0, 0));
			panel.setBorder(new LineBorder(Color.BLACK));
			flightsFrame.add(panel);
			panel.setLayout(null);
			
			// Title:
			JLabel title = new JLabel("Brunel City London Airport");
			title.setBounds(114, 0, 636, 98);
			title.setFont(new Font("Arial", Font.PLAIN, 50));
			title.setForeground(Color.WHITE);
			panel.add(title);
			
			// Departure City Title 
			Label departureCityTitle = new Label("Departure City");
			departureCityTitle.setFont(new Font("Arial", Font.PLAIN, 15));
			departureCityTitle.setBounds(25, 106, 127, 26);
			flightsFrame.add(departureCityTitle);

			// Arrival City Title 
			Label arrivalCityTitle = new Label("Arrival City");
			arrivalCityTitle.setForeground(Color.BLACK);
			arrivalCityTitle.setFont(new Font("Arial", Font.PLAIN, 15));
			arrivalCityTitle.setBounds(227, 106, 111, 26);
			flightsFrame.add(arrivalCityTitle);

			// Departure Date Title 
			Label departureDateTitle = new Label("Departure Date");
			departureDateTitle.setFont(new Font("Arial", Font.PLAIN, 15));
			departureDateTitle.setBounds(440, 106, 136, 26);
			flightsFrame.add(departureDateTitle);

			// Return Date Title 
			Label returnDateTitle = new Label("Return Date");
			returnDateTitle.setFont(new Font("Arial", Font.PLAIN, 15));
			returnDateTitle.setBounds(662, 106, 109, 26);
			flightsFrame.add(returnDateTitle);
			
			//J combo Boxes:
			
			DefaultComboBoxModel departureCities = new DefaultComboBoxModel(new String[] { "Amsterdam", "Athens", "Bangkok", "Cairo",
					"Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Lisbon", "London",
					"Madrid", "Marrakesh", "Mexico", "Moscow", "New York", "Paris", "Rome", "San Paulo", "Sweden", "Sydney",
					"Texas", "Tokyo", "Toronto" });
			
			DefaultComboBoxModel arrivalCities = new DefaultComboBoxModel(new String[] { "Amsterdam", "Athens", "Bangkok", "Cairo",
					"Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Lisbon", "London",
					"Madrid", "Marrakesh", "Mexico", "Moscow", "New York", "Paris", "Rome", "San Paulo", "Sweden", "Sydney",
					"Texas", "Tokyo", "Toronto" });
			
			JComboBox departureCityList = new JComboBox();
			departureCityList.setBounds(25, 138, 131, 27);
			departureCityList.setModel(departureCities);
			flightsFrame.add(departureCityList);
			
			JComboBox arrivalCityList = new JComboBox();
			arrivalCityList.setBounds(227, 138, 131, 27);
			arrivalCityList.setModel(arrivalCities);
			flightsFrame.add(arrivalCityList);
			
			//Buttons:
			JToggleButton selectRestaurantButton = new JToggleButton("Restaurant");
			selectRestaurantButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			selectRestaurantButton.setBackground(Color.WHITE);
			selectRestaurantButton.setForeground(new Color(44, 120, 50));
			selectRestaurantButton.setBounds(353, 244, 155, 60);
			flightsFrame.add(selectRestaurantButton);
			
			selectRestaurantButton.addActionListener(new ActionListener() 	{
				
				@SuppressWarnings("static-access")
				@Override
				public void actionPerformed(ActionEvent e) {
					
				Restaurant restaurant = new Restaurant();
				restaurant.main(null);
				
				}
			
			});
			
			
			// Departure Date Chooser 
			JDateChooser departureDateChooser = new JDateChooser();
			departureDateChooser.setBounds(450, 138, 144, 19);
			departureDateChooser.setDateFormatString("dd/MM/yyyy");
			JTextFieldDateEditor edit = (JTextFieldDateEditor) departureDateChooser.getDateEditor();
			edit.setEditable(false);
			String minimumDate = "01/08/2021";
			String maximumDate = "29/04/2022";
			Date minimum = new SimpleDateFormat("dd/MM/yyyy").parse(minimumDate);
			Date maximum = new SimpleDateFormat("dd/MM/yyyy").parse(maximumDate);
			departureDateChooser.setDate(minimum); // setting the first date to be shown to be 'minimum'
			departureDateChooser.setMinSelectableDate(minimum); // setting the minimum select date to be shown to be 'minimum'
			departureDateChooser.setMaxSelectableDate(maximum); // setting the maximum select date to be shown to be 'maximum' 
			flightsFrame.add(departureDateChooser);

			// Return Date Chooser 
			JDateChooser returnDateChooser = new JDateChooser();
			returnDateChooser.setBounds(672, 138, 144, 19);
			returnDateChooser.setDateFormatString("dd/MM/yyyy");
			JTextFieldDateEditor edit2 = (JTextFieldDateEditor) returnDateChooser.getDateEditor();
			edit2.setEditable(false);
			String minimumDate2 = "01/08/2021";
			String maximumDate2 = "29/04/2022";
			Date minimum2 = new SimpleDateFormat("dd/MM/yyyy").parse(minimumDate2); 
			Date maximum2 = new SimpleDateFormat("dd/MM/yyyy").parse(maximumDate2);
			returnDateChooser.setDate(minimum2); // setting the first date to be shown to be 'minimum1'
			returnDateChooser.setMinSelectableDate(minimum2); // setting the minimum date to 'minimum2'
			returnDateChooser.setMaxSelectableDate(maximum2); // setting the maximum date to 'minimum1'
			flightsFrame.add(returnDateChooser);
			
			JToggleButton selectFlightsButton = new JToggleButton("Select Flight");
			selectFlightsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			selectFlightsButton.setBackground(Color.WHITE);
			selectFlightsButton.setForeground(new Color(44, 120, 50));;
			selectFlightsButton.setBounds(35, 244, 155, 60);
			
			flightsFrame.add(selectFlightsButton);
			
			selectFlightsButton.addActionListener(new ActionListener() 	{
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					FilteredFlights filter = new FilteredFlights();
					filter.setVisible(true);
					filter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				}
			});
					
			JToggleButton selectFinancesButton = new JToggleButton("Finances");
			selectFinancesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			selectFinancesButton.setBackground(Color.WHITE);
			selectFinancesButton.setForeground(new Color(44, 120, 50));
			selectFinancesButton.setBounds(636, 244, 155, 60);
			flightsFrame.add(selectFinancesButton);
			
			selectFinancesButton.addActionListener(new ActionListener() 	{
				
				@SuppressWarnings("static-access")
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Finances bclFinances = new Finances();
					bclFinances.main(null);
					
				}
				
		});
			
			JToggleButton selectDeparturesMap = new JToggleButton("Flight Departures Map");
			selectDeparturesMap.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			selectDeparturesMap.setBackground(Color.WHITE);
			selectDeparturesMap.setForeground(new Color(44, 120, 50));
			selectDeparturesMap.setBounds(130, 367, 243, 60);
			flightsFrame.add(selectDeparturesMap);
			
			selectDeparturesMap.addActionListener(new ActionListener() 	{
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Departures departures;
					try {
						departures = new Departures();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Departures.main(null);
					
					
					
				}
			});
			
			JToggleButton selectArrivalsMap = new JToggleButton("Flight Arrivals Map");
			selectArrivalsMap.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			selectArrivalsMap.setBackground(Color.WHITE);
			selectArrivalsMap.setForeground(new Color(44, 120, 50));
			selectArrivalsMap.setBounds(483, 367, 243, 60);
			flightsFrame.add(selectArrivalsMap);
			
			selectArrivalsMap.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					Flight_Arrivals arrivals;
					arrivals = new Flight_Arrivals();
					Flight_Arrivals.main(null);
				}
		});
			
			
		}
		
			//Algorithm 1:
			//Import Flight CSV
			//Importing CSV file:
		
			public static String[][] importFlights() throws IOException {
				String path = "Resources/Flights.csv";
				List<List<String>> list = new ArrayList <List<String>>();
				
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line = br.readLine();
				String[] headers = line.split(";");
				
				for(String header: headers) {
				    List<String> subList = new ArrayList<String>();
				    subList.add(header);
				    list.add(subList);
				}
				while((line = br.readLine()) != null) {
				    String[] elems = line.split(";");
				    for(int i = 0; i < elems.length; i++) {
				        list.get(i).add(elems[i]);
				    }
				}
				
				br.close();
				int rows = list.size();
				int cols = list.get(0).size();
				String[][] flights = new String[rows][cols];
				for(int row = 0; row < rows; row++) {
				    for(int col = 0; col < cols; col++) {
				        flights[row][col] = list.get(row).get(col);
				    }
				}
				return flights;
			}
	}

