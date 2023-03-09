package Arrivals;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;


public class Popup 

extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popup frame = new Popup();
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
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public Popup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 421, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 401, 559);
		panel.add(scrollPane);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model); //shows arrival flights in a pop up list
		//System.out.println(CSV.flightdata.get(20));
		String[]items = { "0", "1", "2", "3" }; // shows items in a string 
		
		for (int i = 0; i < CSV.LDN.size(); i++) {
			model.add(i, CSV.LDN.get(i)); //output for BCL airport
		}
		for (int i = 0; i < CSV.DUB.size(); i++) {
			model.add(i, CSV.DUB.get(i)); //output for DUB Airport 
		}
		scrollPane.setViewportView(list); 
	}
}
