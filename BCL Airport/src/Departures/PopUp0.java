package Departures;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JMenuBar;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.event.HyperlinkEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings({ "unused", "deprecation", "serial" })
public class PopUp0 extends JFrame  {

	
	private JPanel contentPane;
	private JLabel lblNewLabel;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSVReader0.mainin();
					PopUp0 frame = new PopUp0();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 **/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PopUp0() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1250, 0, 619, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 711);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 573, 689);
		panel.add(scrollPane);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);{ //creates the JList model 
			@SuppressWarnings("unused")
			String[]items = {""};
			
			for (int i = 0; i < CSVReader0.AMS.size(); i++) //returns the array list
			{
				model.add(i, CSVReader0.AMS.get(i));;//this prints all the flights from the destination
			}
//			
//			for (int i = 0; i < CSVReader0.ATH.size(); i++) 
//			{
//				model.add(i, CSVReader0.ATH.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.BKK.size(); i++) 
//			{
//				model.add(i, CSVReader0.BKK.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.CAI.size(); i++) 
//			{
//				model.add(i, CSVReader0.CAI.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.DEL.size(); i++) 
//			{
//				model.add(i, CSVReader0.DEL.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.DXB.size(); i++) 
//			{
//				model.add(i, CSVReader0.DXB.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.DUB.size(); i++) 
//			{
//				model.add(i, CSVReader0.DUB.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.HKG.size(); i++) 
//			{
//				model.add(i, CSVReader0.HKG.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.JNB.size(); i++) 
//			{
//				model.add(i, CSVReader0.JNB.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.LOS.size(); i++) 
//			{
//				model.add(i, CSVReader0.LOS.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.LVS.size(); i++) 
//			{
//				model.add(i, CSVReader0.LVS.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.LIS.size(); i++) 
//			{
//				model.add(i, CSVReader0.LIS.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.LDN.size(); i++)
//			{
//				model.add(i, CSVReader0.LDN.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.MAD.size(); i++) 
//			{
//				model.add(i, CSVReader0.MAD.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.RAK.size(); i++) 
//			{
//				model.add(i, CSVReader0.RAK.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.MEX.size(); i++) 
//			{
//				model.add(i, CSVReader0.MEX.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.SVO.size(); i++) 
//			{
//				model.add(i, CSVReader0.SVO.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.JFK.size(); i++) 
//			{
//				model.add(i, CSVReader0.JFK.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.CDG.size(); i++) 
//			{
//				model.add(i, CSVReader0.CDG.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.FCO.size(); i++) 
//			{
//				model.add(i, CSVReader0.FCO.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.GRU.size(); i++) 
//			{
//				model.add(i, CSVReader0.GRU.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.ARN.size(); i++) 
//			{
//				model.add(i, CSVReader0.ARN.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.SYD.size(); i++) 
//			{
//				model.add(i, CSVReader0.SYD.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.DFW.size(); i++) 
//			{
//				model.add(i, CSVReader0.DFW.get(i));
//			}
//
//			for (int i = 0; i < CSVReader0.HND.size(); i++) 
//			{
//				model.add(i, CSVReader0.HND.get(i));
//			}
//			
//			for (int i = 0; i < CSVReader0.YYZ.size(); i++) 
//			{
//				model.add(i, CSVReader0.YYZ.get(i));
//			}	
			
		}
		scrollPane.setViewportView(list);
	}
}


