package Restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//class name 
public class Menu2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_14_1;
	private JLabel lblNewLabel_15 ;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_18;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_16;
	Error2 frame = new Error2();
	Payment frame1 = new Payment();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2();
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
	
	public Menu2() {
		
		setTitle("Menu");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 120, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(112, 112, 112), 6));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(172, 11, 61, 13);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				//calling the class menu
				Menu frame = new Menu();
				//make it visible
				frame.setVisible(true);
				//close this window.
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(101, 205, 84, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Food");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(21, 23, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prices");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(116, 23, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(316, 23, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(218, 23, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Lobster");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(21, 46, 85, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Chicken Teriyaki");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(21, 71, 85, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sushi");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(21, 146, 85, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Beef Soup");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(21, 121, 85, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Baked Apple");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(21, 171, 85, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chicken Biryani");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(21, 96, 85, 14);
		panel.add(lblNewLabel_10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				
				frame1.setVisible(true);
				dispose();
				
				
			}
		});
		btnContinue.setFont(new Font("Arial", Font.PLAIN, 11));
		btnContinue.setBounds(243, 205, 84, 23);
		panel.add(btnContinue);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u00A3 13.00");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_1.setBounds(116, 46, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_4 = new JLabel("\u00A3 11.00");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_4.setBounds(116, 71, 46, 14);
		panel.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_7 = new JLabel("\u00A3 7.50");
		lblNewLabel_5_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_7.setBounds(116, 145, 46, 14);
		panel.add(lblNewLabel_5_7);
		
		JLabel lblNewLabel_5_10 = new JLabel("\u00A3 9.50");
		lblNewLabel_5_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_10.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_10.setBounds(116, 121, 46, 14);
		panel.add(lblNewLabel_5_10);
		
		JLabel lblNewLabel_5_13 = new JLabel("\u00A3 6.00");
		lblNewLabel_5_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_13.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_13.setBounds(116, 171, 46, 14);
		panel.add(lblNewLabel_5_13);
		
		JLabel lblNewLabel_5_16 = new JLabel("\u00A3 11.00");
		lblNewLabel_5_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_16.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5_16.setBounds(116, 96, 46, 14);
		panel.add(lblNewLabel_5_16);
		
		lblNewLabel_12 = new JLabel("100");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(218, 46, 46, 14);
		panel.add(lblNewLabel_12);
		int lbl_12 = Integer.parseInt(lblNewLabel_12.getText());
		lblNewLabel_19 = new JLabel("100");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(218, 71, 46, 14);
		panel.add(lblNewLabel_19);
		
		lblNewLabel_22 = new JLabel("100");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(218, 96, 46, 14);
		panel.add(lblNewLabel_22);
		
		lblNewLabel_25 = new JLabel("100");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setBounds(218, 121, 46, 14);
		panel.add(lblNewLabel_25);
		
		lblNewLabel_28 = new JLabel("100");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setBounds(218, 145, 46, 14);
		panel.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("100");
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setBounds(218, 171, 46, 14);
		panel.add(lblNewLabel_29);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_11 =Integer.parseInt( lblNewLabel_11.getText());
				int lbl_12 = Integer.parseInt(lblNewLabel_12.getText());
				int a9,b9;
				
				if(lbl_11!= 0)
				{
				
				a9 = lbl_11 - 1;
				lblNewLabel_11.setText(Integer.toString(a9));
				}
				
				if(lbl_11 == 0)
				{
					lblNewLabel_12.setText(Integer.toString(100));
				}
				else
				{
				b9 = lbl_12+1;
				lblNewLabel_12.setText(Integer.toString(b9));
			}
			}
			
		});
		btnNewButton_3.setBounds(269, 42, 46, 23);
		panel.add(btnNewButton_3);
		
		lblNewLabel_11 = new JLabel("0");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(316, 46, 46, 14);
		panel.add(lblNewLabel_11);
		
		JButton btnNewButton_3_1 = new JButton("+");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_11 =Integer.parseInt( lblNewLabel_11.getText());
				int lbl_12 = Integer.parseInt(lblNewLabel_12.getText());
				int a9,b9;
			
				if(lbl_11 != 100)
				{
				
				a9 = lbl_11 + 1;
				lblNewLabel_11.setText(Integer.toString(a9));
				}
				if(lbl_11 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_12.setText(Integer.toString(0));
				}
				else
				{
				b9 = lbl_12-1;
				
				lblNewLabel_12.setText(Integer.toString(b9));
				}
				
			}
		});
		btnNewButton_3_1.setBounds(358, 42, 46, 23);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("-");
		btnNewButton_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_14 =Integer.parseInt( lblNewLabel_14.getText());
				int lbl_19 = Integer.parseInt(lblNewLabel_19.getText());
				int a10,b10;
				
				if(lbl_14!= 0)
				{
				
				a10 = lbl_14 - 1;
				lblNewLabel_14.setText(Integer.toString(a10));
				}
				
				if(lbl_14 == 0)
				{
					lblNewLabel_19.setText(Integer.toString(100));
				}
				else
				{
				b10 = lbl_19+1;
				lblNewLabel_19.setText(Integer.toString(b10));
			}
			}
			
		});
		btnNewButton_3_2.setBounds(269, 67, 46, 23);
		panel.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_1_1 = new JButton("+");
		btnNewButton_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_14 =Integer.parseInt( lblNewLabel_14.getText());
				int lbl_19 = Integer.parseInt(lblNewLabel_19.getText());
				int a10,b10;
				if(lbl_14 != 100)
				{
				
				a10 = lbl_14 + 1;
				lblNewLabel_14.setText(Integer.toString(a10));
				}
				if(lbl_14 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_19.setText(Integer.toString(0));
				}
				else
				{
				b10 = lbl_19-1;
				
				lblNewLabel_19.setText(Integer.toString(b10));
				}
			}
		});
		btnNewButton_3_1_1.setBounds(358, 67, 46, 23);
		panel.add(btnNewButton_3_1_1);
		
		lblNewLabel_14 = new JLabel("0");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(316, 71, 46, 14);
		panel.add(lblNewLabel_14);
		
		JButton btnNewButton_3_2_1 = new JButton("-");
		btnNewButton_3_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_14_1 =Integer.parseInt( lblNewLabel_14_1.getText());
				int lbl_22 = Integer.parseInt(lblNewLabel_22.getText());
				int a11,b11;
				
				if(lbl_14_1!= 0)
				{
				
				a11 = lbl_14_1- 1;
				lblNewLabel_14_1.setText(Integer.toString(a11));
				}
				
				if(lbl_14_1== 0)
				{
					lblNewLabel_22.setText(Integer.toString(100));
				}
				else
				{
				b11 = lbl_22 + 1;
				lblNewLabel_22.setText(Integer.toString(b11));
			}
			}
		});
		btnNewButton_3_2_1.setBounds(269, 92, 46, 23);
		panel.add(btnNewButton_3_2_1);
		
		lblNewLabel_14_1 = new JLabel("0");
		lblNewLabel_14_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14_1.setBounds(316, 96, 46, 14);
		panel.add(lblNewLabel_14_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("+");
		btnNewButton_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_14_1 =Integer.parseInt( lblNewLabel_14_1.getText());
				int lbl_22 = Integer.parseInt(lblNewLabel_22.getText());
				int a11,b11;
				if(lbl_14_1 != 100)
				{
				
				a11 = lbl_14_1 + 1;
				lblNewLabel_14_1.setText(Integer.toString(a11));
				}
				if(lbl_14_1 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_22.setText(Integer.toString(0));
				}
				else
				{
				b11 = lbl_22-1;
				
				lblNewLabel_22.setText(Integer.toString(b11));
				}
			
			}
		});
		btnNewButton_3_1_1_1.setBounds(358, 92, 46, 23);
		panel.add(btnNewButton_3_1_1_1);
		
		JButton btnNewButton_3_2_1_1 = new JButton("-");
		btnNewButton_3_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_15 =Integer.parseInt( lblNewLabel_15.getText());
				int lbl_25 = Integer.parseInt(lblNewLabel_25.getText());
				int a12,b12;
				
				if(lbl_15!= 0)
				{
				
				a12 = lbl_15- 1;
				lblNewLabel_15.setText(Integer.toString(a12));
				}
				
				if(lbl_15 == 0)
				{
					lblNewLabel_25.setText(Integer.toString(100));
				}
				else
				{
				b12 = lbl_25 + 1;
				lblNewLabel_25.setText(Integer.toString(b12));
			}
			}
		});
		btnNewButton_3_2_1_1.setBounds(269, 117, 46, 23);
		panel.add(btnNewButton_3_2_1_1);
		
		lblNewLabel_15 = new JLabel("0");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(316, 121, 46, 14);
		panel.add(lblNewLabel_15);
		
		JButton btnNewButton_3_1_1_1_1 = new JButton("+");
		btnNewButton_3_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_15 =Integer.parseInt( lblNewLabel_15.getText());
				int lbl_25 = Integer.parseInt(lblNewLabel_25.getText());
				int a12,b12;
				if(lbl_15 != 100)
				{
				
				a12 = lbl_15 + 1;
				lblNewLabel_15.setText(Integer.toString(a12));
				}
				if(lbl_15 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_22.setText(Integer.toString(0));
				}
				else
				{
				b12 = lbl_25-1;
				
				lblNewLabel_25.setText(Integer.toString(b12));
				}
			
			}
		});
		btnNewButton_3_1_1_1_1.setBounds(358, 117, 46, 23);
		panel.add(btnNewButton_3_1_1_1_1);
		
		JButton btnNewButton_3_2_1_1_1 = new JButton("-");
		btnNewButton_3_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_17 =Integer.parseInt( lblNewLabel_17.getText());
				int lbl_28 = Integer.parseInt(lblNewLabel_28.getText());
				int a13,b13;
				
				if(lbl_17!= 0)
				{
				
				a13 = lbl_17- 1;
				lblNewLabel_17.setText(Integer.toString(a13));
				}
				
				if(lbl_17 == 0)
				{
					lblNewLabel_28.setText(Integer.toString(100));
				}
				else
				{
				b13 = lbl_28 + 1;
				lblNewLabel_28.setText(Integer.toString(b13));
			}
			}
		});
		btnNewButton_3_2_1_1_1.setBounds(269, 141, 46, 23);
		panel.add(btnNewButton_3_2_1_1_1);
		
		JButton btnNewButton_3_1_1_1_1_1 = new JButton("+");
		btnNewButton_3_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_17 =Integer.parseInt( lblNewLabel_17.getText());
				int lbl_28 = Integer.parseInt(lblNewLabel_28.getText());
				int a13,b13;
				if(lbl_17 != 100)
				{
				
				a13 = lbl_17 + 1;
				lblNewLabel_17.setText(Integer.toString(a13));
				}
				if(lbl_17 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_28.setText(Integer.toString(0));
				}
				else
				{
				b13 = lbl_28-1;
				
				lblNewLabel_28.setText(Integer.toString(b13));
				}
			}
		});
		btnNewButton_3_1_1_1_1_1.setBounds(358, 141, 46, 23);
		panel.add(btnNewButton_3_1_1_1_1_1);
		
		lblNewLabel_17 = new JLabel("0");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(316, 145, 46, 14);
		panel.add(lblNewLabel_17);
		
		JButton btnNewButton_3_2_1_1_1_1 = new JButton("-");
		btnNewButton_3_2_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_18 =Integer.parseInt( lblNewLabel_18.getText());
				int lbl_29 = Integer.parseInt(lblNewLabel_29.getText());
				int a14,b14;
				
				if(lbl_18!= 0)
				{
				
				a14 = lbl_18- 1;
				lblNewLabel_18.setText(Integer.toString(a14));
				}
				
				if(lbl_18 == 0)
				{
					lblNewLabel_29.setText(Integer.toString(100));
				}
				else
				{
				b14 = lbl_29 + 1;
				lblNewLabel_29.setText(Integer.toString(b14));
			}
			}
		});
		btnNewButton_3_2_1_1_1_1.setBounds(269, 167, 46, 23);
		panel.add(btnNewButton_3_2_1_1_1_1);
		
		JButton btnNewButton_3_1_1_1_1_1_1 = new JButton("+");
		btnNewButton_3_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_18 =Integer.parseInt( lblNewLabel_18.getText());
				int lbl_29 = Integer.parseInt(lblNewLabel_29.getText());
				int a14,b14;
				if(lbl_18 != 100)
				{
				
				a14 = lbl_18 + 1;
				lblNewLabel_18.setText(Integer.toString(a14));
				}
				if(lbl_18 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_29.setText(Integer.toString(0));
				}
				else
				{
				b14 = lbl_29-1;
				
				lblNewLabel_29.setText(Integer.toString(b14));
				}
			}
			
		});
		btnNewButton_3_1_1_1_1_1_1.setBounds(358, 167, 46, 23);
		panel.add(btnNewButton_3_1_1_1_1_1_1);
		
		lblNewLabel_18 = new JLabel("0");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(316, 171, 46, 14);
		panel.add(lblNewLabel_18);
	}
}
