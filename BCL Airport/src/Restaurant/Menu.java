package Restaurant;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;


import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_16;
	
	
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_19;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_22;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JLabel lblNewLabel_25;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JLabel lblNewLabel_28;
	
	
	
	//I am calling another class called Error2 this one is for the error handling message.
	Error2 frame = new Error2();
	//global variables 
	int ans,a,b,a2,b2,a3,b3,a4,b4;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		
		
		
		setTitle("Menu");
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
		
		lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(172, 11, 61, 13);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("Next\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//event handler
			public void mousePressed(MouseEvent e) 
			{
				
				
				//calling another class
				Menu2 frame = new Menu2();
				dispose();
			
				frame.setVisible(true);
				
			//dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(172, 205, 71, 23);
		panel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Food");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(21, 23, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prices");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(116, 23, 46, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Order");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(316, 23, 46, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(217, 23, 46, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Carbonara");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(21, 46, 85, 14);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Pizza");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(21, 71, 85, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Burger");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(21, 96, 85, 14);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("English Breakfast");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(21, 121, 85, 14);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Chicken Soup");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(21, 146, 85, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Salmon Teriyaki");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(21, 171, 85, 14);
		panel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("6.50");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_11.setBounds(116, 46, 46, 14);
		panel.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("100");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(217, 46, 46, 14);
		panel.add(lblNewLabel_12);
		
		
		lblNewLabel_13 = new JLabel("0");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(316, 71, 46, 14);
		panel.add(lblNewLabel_13);
	
		
		
		lblNewLabel_14 = new JLabel("\u00A3 8.50");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_14.setBounds(116, 71, 46, 14);
		panel.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("100");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_15.setBounds(217, 71, 46, 14);
		panel.add(lblNewLabel_15);
		
		
		lblNewLabel_16 = new JLabel("0");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(316, 48, 46, 14);
		panel.add(lblNewLabel_16);
		
		
		lblNewLabel_17 = new JLabel("\u00A3 7.00");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_17.setBounds(116, 96, 46, 14);
		panel.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("100");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_18.setBounds(217, 96, 46, 14);
		panel.add(lblNewLabel_18);
		
		
		lblNewLabel_19 = new JLabel("0");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(316, 96, 46, 14);
		panel.add(lblNewLabel_19);
		
		
		lblNewLabel_20 = new JLabel("\u00A3 10.00");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_20.setBounds(116, 121, 46, 14);
		panel.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("100");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_21.setBounds(217, 121, 46, 14);
		panel.add(lblNewLabel_21);
		
		
		lblNewLabel_22 = new JLabel("0");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(316, 121, 46, 14);
		panel.add(lblNewLabel_22);
		
		
		lblNewLabel_23 = new JLabel("\u00A3 7.50");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_23.setBounds(116, 146, 46, 14);
		panel.add(lblNewLabel_23);
		
		lblNewLabel_24 = new JLabel("100");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_24.setBounds(217, 146, 46, 14);
		panel.add(lblNewLabel_24);
		
		lblNewLabel_25 = new JLabel("0");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setBounds(316, 146, 46, 14);
		panel.add(lblNewLabel_25);
		
		lblNewLabel_26 = new JLabel("\u00A3 10.50");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_26.setBounds(116, 171, 46, 14);
		panel.add(lblNewLabel_26);
		
		lblNewLabel_27 = new JLabel("100");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_27.setBounds(217, 171, 46, 14);
		panel.add(lblNewLabel_27);
		
		lblNewLabel_28 = new JLabel("0");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setBounds(316, 171, 46, 14);
		panel.add(lblNewLabel_28);
		
		btnNewButton_1 = new JButton("-");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				//variables that getting the value of a each label.
				int lbl_16 =Integer.parseInt( lblNewLabel_16.getText());
				int lbl_12 = Integer.parseInt(lblNewLabel_12.getText());
				
				//condition where it says if the lbl_16 is not equal to 0 then decrement its value by 1. 
				if(lbl_16 != 0)
				{
				// variable a holding the answer of lbl_16 - 1.
				a = lbl_16 - 1;
				// assigning new value of lblNewlabel_16.
				lblNewLabel_16.setText(Integer.toString(a));
				
				}
				// condition where of the lbl_16 is equal to 0 the the lbl_12 will be 100.
				if(lbl_16 == 0)
				{
					lblNewLabel_12.setText(Integer.toString(100));
				}
				else
				{
					//variable b holding the answer of lbl_12 + 1.
				b = lbl_12+1;
				// assigning new variable of lblNewLabel_12.
				lblNewLabel_12.setText(Integer.toString(b));
				}
				
				
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_1.setBounds(273, 42, 46, 23);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("+");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{	
				//variables that getting the value of a each label.
				int lbl_16 =Integer.parseInt( lblNewLabel_16.getText());
				int lbl_12 = Integer.parseInt(lblNewLabel_12.getText());
				
				// condition where if lbl_16 is not equal to  100 then lbl_16 will increment by 1.
				if(lbl_16 != 100)
				{
				// variable a holding the answer of lbl_16 + 1.
				a = lbl_16 + 1;
				// assigning the new value of lblNewLabel_16
				lblNewLabel_16.setText(Integer.toString(a));
				}
				
				//condition where if lbl_16 is equal to 100 then error handling will pop up and telling the the customer can't order more.
				if(lbl_16 == 100)
				{	
					//another class
					frame.setVisible(true);
					//assigning 0 value on lblNewLabel_12.
					lblNewLabel_12.setText(Integer.toString(0));
				}
				else
				{
				// variable b holding the answer of lbl_12 - 1.
				b = lbl_12-1;
				//assigning new value of lblNewLabel_!2. 
				lblNewLabel_12.setText(Integer.toString(b));
				}
				
			}
			});
		
			
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_2.setBounds(358, 42, 46, 23);
		panel.add(btnNewButton_2);
		
			
		btnNewButton_3 = new JButton("-");
		btnNewButton_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				
				int lbl_13 =Integer.parseInt( lblNewLabel_13.getText());
				int lbl_15 = Integer.parseInt(lblNewLabel_15.getText());
				
				
				if(lbl_13 != 0)
				{
			
				a2=lbl_13-1;
			
				lblNewLabel_13.setText(Integer.toString(a2));
				}
				
				if(lbl_13 == 0)
				{
					lblNewLabel_15.setText(Integer.toString(100));
				}
				else
				{
				b2 = lbl_15+1;
				lblNewLabel_15.setText(Integer.toString(b2));
				
				
				}
			
				
			 }
			});
		
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_3.setBounds(273, 67, 46, 23);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("+");
		btnNewButton_4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
		{	
				//variables that getting the value of a each label.
				int lbl_13 =Integer.parseInt( lblNewLabel_13.getText());
				int lbl_15 = Integer.parseInt(lblNewLabel_15.getText());
			
				//condition where it says if the lbl_16 is not equal to 0 then decrement its value by 1.
				if(lbl_13 != 100)
				
			{
			
			a2 = lbl_13 + 1;
			
			
			lblNewLabel_13.setText(Integer.toString(a2));
			
			}
			if(lbl_13 == 100)
			{
				
				frame.setVisible(true);
				lblNewLabel_15.setText(Integer.toString(0));
			}
			else
			{
			b2 = lbl_15-1;
			
			lblNewLabel_15.setText(Integer.toString(b2));
			}
			
			}
			
		});
		
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_4.setBounds(358, 67, 46, 23);
		panel.add(btnNewButton_4);
		
		
		
		btnNewButton_5 = new JButton("-");
		btnNewButton_5.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_19 =Integer.parseInt( lblNewLabel_19.getText());
				int lbl_18 = Integer.parseInt(lblNewLabel_18.getText());
				if(lbl_19 != 0)
				{
				
				a3 = lbl_19 - 1;
				lblNewLabel_19.setText(Integer.toString(a3));
				}
				
				if(lbl_19 == 0)
				{
					lblNewLabel_18.setText(Integer.toString(100));
				}
				else
				{
				b3 = lbl_18+1;
				lblNewLabel_18.setText(Integer.toString(b3));
				}
				
			}
		});
		
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_5.setBounds(273, 92, 46, 23);
		panel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("+");
		btnNewButton_6.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_19 =Integer.parseInt( lblNewLabel_19.getText());
				int lbl_18 = Integer.parseInt(lblNewLabel_18.getText());
			if(lbl_19 != 100)
			{
			
			a3 = lbl_19 + 1;
			lblNewLabel_19.setText(Integer.toString(a3));
			}
			if(lbl_19 == 100)
			{
				
				frame.setVisible(true);
				lblNewLabel_18.setText(Integer.toString(0));
			}
			else
			{
			b3 = lbl_18-1;
			
			lblNewLabel_18.setText(Integer.toString(b3));
			}
		}
		
		});
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_6.setBounds(358, 92, 46, 23);
		panel.add(btnNewButton_6);
		
		
	
		
		btnNewButton_8 = new JButton("+");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_21 = Integer.parseInt(lblNewLabel_21.getText());
				int lbl_22 =Integer.parseInt( lblNewLabel_22.getText());
				if(lbl_22 != 100)
				{
				
				a4 = lbl_22 + 1;
				lblNewLabel_22.setText(Integer.toString(a4));
				}
				if(lbl_22 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_21.setText(Integer.toString(0));
				}
				else
				{
				b4 = lbl_21-1;
				
				lblNewLabel_21.setText(Integer.toString(b4));
				}
				
			}
		});
		btnNewButton_8.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_8.setBounds(358, 117, 46, 23);
		panel.add(btnNewButton_8);
		
	
		btnNewButton_9 = new JButton("-");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_25 =Integer.parseInt( lblNewLabel_25.getText());
				int lbl_24 = Integer.parseInt(lblNewLabel_24.getText());
				int a5,b5;
				
				if(lbl_25!= 0)
				{
				
				a5 = lbl_25 - 1;
				lblNewLabel_25.setText(Integer.toString(a5));
				}
				
				if(lbl_25 == 0)
				{
					lblNewLabel_24.setText(Integer.toString(100));
				}
				else
				{
				b5 = lbl_24+1;
				lblNewLabel_24.setText(Integer.toString(b5));
			}
			}
		});
		btnNewButton_9.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_9.setBounds(273, 142, 46, 23);
		panel.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("+");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_25 =Integer.parseInt( lblNewLabel_25.getText());
				int lbl_24 = Integer.parseInt(lblNewLabel_24.getText());
				int a5,b5;
				if(lbl_25 != 100)
				{
				
				a5 = lbl_25 + 1;
				lblNewLabel_25.setText(Integer.toString(a5));
				}
				if(lbl_25 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_24.setText(Integer.toString(0));
				}
				else
				{
				b5 = lbl_24-1;
				
				lblNewLabel_24.setText(Integer.toString(b5));
				}
			}
		});
		btnNewButton_10.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_10.setBounds(358, 142, 46, 23);
		panel.add(btnNewButton_10);
	
	
		
		btnNewButton_11 = new JButton("-");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_28 =Integer.parseInt( lblNewLabel_28.getText());
				int lbl_27 = Integer.parseInt(lblNewLabel_27.getText());
				int a6,b6;
				
				if(lbl_28!= 0)
				{
				
				a6 = lbl_28 - 1;
				lblNewLabel_28.setText(Integer.toString(a6));
				}
				
				if(lbl_28 == 0)
				{
					lblNewLabel_27.setText(Integer.toString(100));
				}
				else
				{
				b6 = lbl_27+1;
				lblNewLabel_27.setText(Integer.toString(b6));
			}
			}
		});
		btnNewButton_11.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_11.setBounds(273, 167, 46, 23);
		panel.add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("+");
		btnNewButton_12.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				int lbl_28 =Integer.parseInt( lblNewLabel_28.getText());
				int lbl_27 = Integer.parseInt(lblNewLabel_27.getText());
				int a6,b6;
				if(lbl_28 != 100)
				{
				
				a6 = lbl_28 + 1;
				lblNewLabel_28.setText(Integer.toString(a6));
				}
				if(lbl_28 == 100)
				{
					
					frame.setVisible(true);
					lblNewLabel_27.setText(Integer.toString(0));
				}
				else
				{
				b6 = lbl_27-1;
				
				lblNewLabel_27.setText(Integer.toString(b6));
				}
			}
		});
		btnNewButton_12.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_12.setBounds(358, 167, 46, 23);
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("-");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int lbl_21 = Integer.parseInt(lblNewLabel_21.getText());
				int lbl_22 =Integer.parseInt( lblNewLabel_22.getText());

				
				if(lbl_22!= 0)
				{
				
				a4 = lbl_22 - 1;
				lblNewLabel_22.setText(Integer.toString(a4));
				}
				
				if(lbl_22 == 0)
				{
					lblNewLabel_21.setText(Integer.toString(100));
				}
				else
				{
				b4 = lbl_21+1;
				lblNewLabel_21.setText(Integer.toString(b4));
			}
			}
		});
		btnNewButton_13.setBounds(273, 117, 46, 23);
		panel.add(btnNewButton_13);
		
		
	}
}
