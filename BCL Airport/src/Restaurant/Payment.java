package Restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    JPanel panel_3;
   Menu menu = new Menu();
    JTextField textField_1;
    private JTextField textField_2;
    int answer, change;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		
		setTitle("Payment");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 120, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(112, 112, 112), 6));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 183, 217);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Receipt");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 11, 85, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BCL restaurant ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(35, 36, 115, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel : 02837467891");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(35, 48, 115, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Time: 00:00\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(56, 60, 62, 19);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date: DD/MM/YYYY");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(35, 75, 115, 19);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Order list");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 105, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Prices");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_1.setBounds(66, 105, 52, 14);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Quantity");
		lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_2.setBounds(127, 105, 46, 14);
		panel_1.add(lblNewLabel_5_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 120, 52, 86);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(65, 120, 53, 86);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(120, 120, 53, 86);
		panel_1.add(panel_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(221, 11, 183, 124);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Total Bill");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(70, 11, 49, 13);
		panel_2.add(lblNewLabel_6);
		
		
		panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(32, 24, 126, 32);
		panel_2.add(panel_3);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
	//	textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		// I tried to call the global variable of menu called ans. 
		textField_1.setText(String.valueOf(menu.ans));
		 
	
		
		JLabel lblNewLabel_6_1 = new JLabel("Payment");
		lblNewLabel_6_1.setToolTipText("");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6_1.setBounds(70, 55, 49, 13);
		panel_2.add(lblNewLabel_6_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(51, 68, 81, 25);
		panel_2.add(textField);
		textField.setColumns(10);
	//	change = Integer.parseInt(textField.getText());
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				answer = menu.ans - change;
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(94, 94, 79, 19);
		panel_2.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancel.setBounds(10, 94, 79, 19);
		panel_2.add(btnCancel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(221, 146, 183, 82);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Change");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(69, 11, 46, 14);
		panel_2_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Thank You! Have a nice day.");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(10, 57, 163, 14);
		panel_2_1.add(lblNewLabel_8);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setToolTipText("");
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(30, 24, 126, 32);
		panel_2_1.add(panel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setText(Integer.toString(answer));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		panel_3_1.add(textField_2);
	}
}
