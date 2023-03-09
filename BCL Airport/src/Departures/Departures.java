package Departures;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.Popup;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.SplashScreen;

import javax.swing.JFormattedTextField;
import java.awt.TextField;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JProgressBar;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Set;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Departures{
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//use of the CSVReader class
					CSVReader0.mainin();
					Departures window = new Departures();
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
	 * */
	public Departures() throws IOException {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 * @throws IOException 
	 * 
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() throws IOException  {
		//ADD COMMENT!!!!
		frame = new JFrame();
		frame.setBounds(944, 84, 1250, 600);
		
		JPanel ApplicationBox = new JPanel();
		frame.getContentPane().add(ApplicationBox, BorderLayout.CENTER);
		ApplicationBox.setLayout(null);
		
		JPanel panelDelay = new JPanel();
		panelDelay.setBackground(Color.WHITE);
		panelDelay.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDelay.setBounds(944, 84, 305, 467);
		ApplicationBox.add(panelDelay);
		panelDelay.setLayout(null);
		
		JLabel Title = new JLabel("Delays");
		Title.setFont(new Font("Tahoma", Font.BOLD, 15));
		Title.setBorder(new LineBorder(new Color(0, 0, 0)));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(0, 0, 305, 27);
		panelDelay.add(Title);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 28, 305, 439);
		panelDelay.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 305, 439);
		panel.add(scrollPane);
		
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		for (int i = 0; i < CSVReader0.DLY.size(); i++) //returns the array list
		{
			model.add(i, CSVReader0.DLY.get(i));//this prints all the flights from the destination
		}
		scrollPane.setViewportView(list);

		
		JPanel TitleBackground = new JPanel();
		TitleBackground.setBounds(0, 0, 1249, 83);
		TitleBackground.setBackground(new Color(44, 120, 50));
		ApplicationBox.add(TitleBackground);
		TitleBackground.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Brunel City Airport");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(521, 21, 194, 35);
		TitleBackground.add(lblNewLabel_3);
		
		JLabel City_1 = new JLabel("AMS");
		City_1.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_1.setBounds(433, 162, 37, 21);
		ApplicationBox.add(City_1);
		
		JLabel AMSButton = new JLabel("");
		AMSButton.setIcon(new ImageIcon("Resources/map.png"));
		AMSButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		AMSButton.setBounds(437, 176, 17, 14);
		ApplicationBox.add(AMSButton);
		
		
		JLabel City_2 = new JLabel("ATH");
		City_2.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_2.setBounds(480, 207, 24, 21);
		ApplicationBox.add(City_2);
		
		JLabel ATHButton = new JLabel("");
		ATHButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		ATHButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		ATHButton.setBounds(485, 220, 8, 14);
		ApplicationBox.add(ATHButton);

		
		JLabel City_3 = new JLabel("BKK");
		City_3.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_3.setBounds(725, 293, 37, 21);
		ApplicationBox.add(City_3);
		
		JLabel BKKButton = new JLabel("");
		BKKButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		BKKButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		BKKButton.setBounds(730, 305, 17, 14);
		ApplicationBox.add(BKKButton);
		
		
		
		JLabel City_4 = new JLabel("CAI");
		City_4.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_4.setBounds(507, 237, 37, 21);
		ApplicationBox.add(City_4);
		
		JLabel CAIButton = new JLabel("");
		CAIButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		CAIButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		CAIButton.setBounds(510, 250, 17, 14);
		ApplicationBox.add(CAIButton);
		
		
		JLabel City_5 = new JLabel("DEL");
		City_5.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_5.setBounds(654, 258, 24, 21);
		ApplicationBox.add(City_5);		
		
		JLabel DELButton = new JLabel("");
		DELButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		DELButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		DELButton.setBounds(659, 270, 8, 14);
		ApplicationBox.add(DELButton);
		
		
		JLabel City_6 = new JLabel("DXB");
		City_6.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_6.setBounds(580, 253, 24, 21);
		ApplicationBox.add(City_6);
		
		JLabel DXBButton = new JLabel("");
		DXBButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		DXBButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		DXBButton.setBounds(585, 265, 8, 14);
		ApplicationBox.add(DXBButton);
		
		
		JLabel City_7 = new JLabel("DUB");
		City_7.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_7.setBounds(390, 158, 33, 21);
		ApplicationBox.add(City_7);
		
		JLabel DUBButton = new JLabel("");
		DUBButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		DUBButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		DUBButton.setBounds(403, 170, 17, 14);
		ApplicationBox.add(DUBButton);
		
		
		JLabel City_8 = new JLabel("HKG");
		City_8.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_8.setBounds(760, 263, 24, 21);
		ApplicationBox.add(City_8);
		
		JLabel HKGButton = new JLabel("");
		HKGButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		HKGButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		HKGButton.setBounds(765, 275, 17, 14);
		ApplicationBox.add(HKGButton);
		

		JLabel City_9 = new JLabel("JNB");
		City_9.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_9.setBounds(500, 423, 24, 21);
		ApplicationBox.add(City_9);
		
		JLabel JNBButton = new JLabel("");
		JNBButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		JNBButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		JNBButton.setBounds(505, 435, 17, 14);
		ApplicationBox.add(JNBButton);
		
		JLabel City_10 = new JLabel("LOS");
		City_10.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_10.setBounds(420, 313, 24, 21);
		ApplicationBox.add(City_10);
		
		JLabel LOSButton = new JLabel("");
		LOSButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		LOSButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		LOSButton.setBounds(425, 325, 17, 14);
		ApplicationBox.add(LOSButton);
		
		
		JLabel City_11 = new JLabel("LVS");
		City_11.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_11.setBounds(85, 213, 24, 21);
		ApplicationBox.add(City_11);
		
		JLabel LVSButton = new JLabel("");
		LVSButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		LVSButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		LVSButton.setBounds(90, 225, 17, 14);
		ApplicationBox.add(LVSButton);
		
		
		JLabel City_12 = new JLabel("LIS");
		City_12.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_12.setBounds(381, 210, 17, 21);
		ApplicationBox.add(City_12);
		
		JLabel LISButton = new JLabel("");
		LISButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		LISButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		LISButton.setBounds(395, 213, 17, 14);
		ApplicationBox.add(LISButton);
		
		
		JLabel City_13 = new JLabel("BCL");
		City_13.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_13.setBounds(413, 165, 17, 21);
		ApplicationBox.add(City_13);
		
		JLabel BCLButton = new JLabel("");
		BCLButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		BCLButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		BCLButton.setBounds(420, 177, 17, 14);
		ApplicationBox.add(BCLButton);

		
		JLabel City_14 = new JLabel("MAD");
		City_14.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_14.setBounds(405, 201, 33, 21);
		ApplicationBox.add(City_14);
		
		JLabel MADButton = new JLabel("");
		MADButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		MADButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		MADButton.setBounds(410, 213, 17, 14);
		ApplicationBox.add(MADButton);
		
		
		JLabel City_15 = new JLabel("RAK");
		City_15.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_15.setBounds(385, 233, 33, 21);
		ApplicationBox.add(City_15);
		
		JLabel RAKButton = new JLabel("");
		RAKButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		RAKButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		RAKButton.setBounds(390, 245, 17, 14);
		ApplicationBox.add(RAKButton);
		
		
		JLabel City_16 = new JLabel("MEX");
		City_16.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_16.setBounds(100, 270, 33, 21);
		ApplicationBox.add(City_16);
		
		JLabel MEXButton = new JLabel("");
		MEXButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		MEXButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		MEXButton.setBounds(110, 285, 17, 14);
		ApplicationBox.add(MEXButton);
		
		
		JLabel City_17 = new JLabel("SVO");
		City_17.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_17.setBounds(520, 157, 33, 21);
		ApplicationBox.add(City_17);
	
		JLabel SVOButton = new JLabel("");
		//SVOButton.setIcon(new ImageIcon("src/Path 1.png"));
		SVOButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		SVOButton.setBounds(524, 170, 17, 14);
		ApplicationBox.add(SVOButton);
		
		
		JLabel City_18 = new JLabel("JFK");
		City_18.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_18.setBounds(187, 215, 33, 21);
		ApplicationBox.add(City_18);
		
		JLabel JFKButton = new JLabel("");
		//JFKButton.setIcon(new ImageIcon("src/Path 1.png"));
		JFKButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		JFKButton.setBounds(190, 227, 17, 14);
		ApplicationBox.add(JFKButton);
		
		
		JLabel City_19 = new JLabel("CDG");
		City_19.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_19.setBounds(419, 193, 24, 21);
		ApplicationBox.add(City_19);
		
		JLabel CDGButton = new JLabel("");
		//CDGButton.setIcon(new ImageIcon("src/Path 1.png"));
		CDGButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		CDGButton.setBounds(425, 189, 8, 14);
		ApplicationBox.add(CDGButton);
		
		
		JLabel City_20 = new JLabel("FCO");
		City_20.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_20.setBounds(450, 215, 24, 21);
		ApplicationBox.add(City_20);
		
		JLabel FCOButton = new JLabel("");
		//FCOButton.setIcon(new ImageIcon("src/Path 1.png"));
		FCOButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		FCOButton.setBounds(455, 210, 17, 14);
		ApplicationBox.add(FCOButton);
		
		
		JLabel City_21 = new JLabel("GRU");
		City_21.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_21.setBounds(280, 413, 24, 21);
		ApplicationBox.add(City_21);
		
		JLabel GRUButton = new JLabel("");
		GRUButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		GRUButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		GRUButton.setBounds(285, 425, 17, 14);
		ApplicationBox.add(GRUButton);
		
		
		JLabel City_22 = new JLabel("ARN");
		City_22.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_22.setBounds(460, 140, 24, 21);
		ApplicationBox.add(City_22);
		
		JLabel ARNButton = new JLabel("");
		ARNButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		ARNButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		ARNButton.setBounds(467, 153, 17, 14);
		ApplicationBox.add(ARNButton);
		
		
		JLabel City_23 = new JLabel("SYD");
		City_23.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_23.setBounds(865, 447, 24, 21);
		ApplicationBox.add(City_23);
		
		JLabel SYDButton = new JLabel("");
		SYDButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		SYDButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		SYDButton.setBounds(870, 460, 17, 14);
		ApplicationBox.add(SYDButton);
		
		
		JLabel City_24 = new JLabel("DFW");
		City_24.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_24.setBounds(130, 227, 24, 21);
		ApplicationBox.add(City_24);
		
		JLabel DFWButton = new JLabel("");
		DFWButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		DFWButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		DFWButton.setBounds(135, 240, 17, 14);
		ApplicationBox.add(DFWButton);
		
		
		JLabel City_25 = new JLabel("HND");
		City_25.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_25.setBounds(825, 213, 24, 21);
		ApplicationBox.add(City_25);
		
		JLabel HNDButton = new JLabel("");
		HNDButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		HNDButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		HNDButton.setBounds(830, 225, 17, 14);
		ApplicationBox.add(HNDButton);
		
		
		JLabel City_26 = new JLabel("YYZ");
		City_26.setFont(new Font("Segoe UI", Font.BOLD, 9));
		City_26.setBounds(197, 187, 24, 21);
		ApplicationBox.add(City_26);
		
		JLabel YYZButton = new JLabel("");
		YYZButton.setIcon(new ImageIcon("Resources/Path 1.png"));
		YYZButton.addMouseListener(new MouseAdapter() {
			//This line below declares the JFrame which is the Pop Up Departures so that it is able to be used by the event handler.
			PopUp0 frame = new PopUp0();
			public void mouseEntered(MouseEvent enter) {
				//The line below sets the JFrame to be visible when the mouse has entered the JLabel.
				frame.setVisible(true);
			}
			
			public void mouseExited(MouseEvent exit) {
				//The line below sets the JFrame to not be visible when the mouse has exited the JLabel. 
				frame.setVisible(false);
			}
		});
		YYZButton.setBounds(200, 200, 17, 14);
		ApplicationBox.add(YYZButton);
		
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("Resources/map.png"));
		Background.setBounds(0, 85, 1194, 467);
		ApplicationBox.add(Background);
	}

//	class SwingAction extends AbstractAction {
//		public SwingAction() {
////			putValue(NAME, "SwingAction");
////			putValue(SHORT_DESCRIPTION, "Some short description");
//		}
//		public void actionPerformed(ActionEvent e) {
//		}
//	}
	
//	private static void addPopup(Component component, final JPopupMenu popup) {
//	}
}
