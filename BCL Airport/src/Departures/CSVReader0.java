package Departures;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class CSVReader0 {

public static ArrayList <String> flightdata = new ArrayList<String>();
public static ArrayList <String> DLY = new ArrayList<String>();
public static ArrayList <String> AMS = new ArrayList<String>();
public static ArrayList <String> ATH = new ArrayList<String>();
public static ArrayList <String> BKK = new ArrayList<String>();
public static ArrayList <String> CAI = new ArrayList<String>();
public static ArrayList <String> DEL = new ArrayList<String>();
public static ArrayList <String> DXB = new ArrayList<String>();
public static ArrayList <String> DUB = new ArrayList<String>();
public static ArrayList <String> HKG = new ArrayList<String>();
public static ArrayList <String> JNB = new ArrayList<String>();
public static ArrayList <String> LOS = new ArrayList<String>();
public static ArrayList <String> LVS = new ArrayList<String>();
public static ArrayList <String> LIS = new ArrayList<String>();
public static ArrayList <String> LDN = new ArrayList<String>();
public static ArrayList <String> MAD = new ArrayList<String>();
public static ArrayList <String> RAK = new ArrayList<String>();
public static ArrayList <String> MEX = new ArrayList<String>();
public static ArrayList <String> SVO = new ArrayList<String>();
public static ArrayList <String> JFK = new ArrayList<String>();
public static ArrayList <String> CDG = new ArrayList<String>();
public static ArrayList <String> FCO = new ArrayList<String>();
public static ArrayList <String> GRU = new ArrayList<String>();
public static ArrayList <String> ARN = new ArrayList<String>();
public static ArrayList <String> SYD = new ArrayList<String>();
public static ArrayList <String> DFW = new ArrayList<String>();
public static ArrayList <String> HND = new ArrayList<String>();
public static ArrayList <String> YYZ = new ArrayList<String>();
//these are all the different Arraylist that will be used


private static File csvFile;

public static void mainin() throws IOException, ParseException  {
			
			int i = 0;
			csvFile = new File("Resources/Flights.csv");
			BufferedReader rd = new BufferedReader(new FileReader(csvFile));//reads to file
			String line = "";
			try {
				while((line = rd.readLine()) != null) {
					String[] count = line.split(",");
					flightdata.add(count[0] + " " + count[1] + " " + count[2] + " " + count[3]+ " " + count[4]+ " " + count[5]+ " " + count[6]+" "+count[7]+" "+count[10]+ " " + count[11]);//all the counts are rows of coloums that need to be shown
				
					  
					String check = count [6];	
					String check1 = count [5];
	
					if(Integer.parseInt(check1) > 30)//if row 5 is more than 30 then it should display the following 
					{
						DLY.add(count[1]+" "+count[2]+" "+count[5]+" "+count[6]+" "+count[8]+" "+count[11]);
					}
					
					
					if (check.equals("AMS"))//if the check equals to BCL then the flights going from the destination should display.
					{
						AMS.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
					}
					

					
//					if (check.equals("ATH"))
//					{
//						ATH.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("BKK"))
//					{
//						BKK.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("CAI"))
//					{
//						CAI.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("DEL"))
//					{
//						DEL.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("DXB"))
//					{
//						DXB.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("DUB"))
//					{
//						DUB.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("HKG"))
//					{
//						HKG.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("JNB"))
//					{
//						JNB.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("LOS"))
//					{
//						LOS.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("LVS"))
//					{
//						LVS.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("LIS"))
//					{
//						LIS.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("BCL"))//if the check equals to BCL then the flights going from LDN should display.
//					{
//						LDN.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("MAD"))
//					{
//						MAD.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("RAK"))
//					{
//						RAK.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("MEX"))
//					{
//						MEX.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("SVO"))
//					{
//						SVO.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("JFK"))
//					{
//						JFK.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("CDG"))
//					{
//						CDG.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("FCO"))
//					{
//						FCO.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("GRU"))
//					{
//						GRU.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("ARN"))
//					{
//						ARN.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("SYD"))
//					{
//						SYD.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("DFW"))
//					{
//						DFW.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("HND"))
//					{
//						HND.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}
//					
//					if (check.equals("YYZ"))
//					{
//						YYZ.add(count[1]+" "+count[3]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]);
//					}

				}
			} 	catch(FileNotFoundException e) {
					e.printStackTrace();
		} 
	}
}





