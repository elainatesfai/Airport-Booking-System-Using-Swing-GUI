package Passengers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Passengers 
{
	// Declare and define number of tickets before function is called (so that it doesn't reassign the same value of 3 every time ticket method is called)
	static int noticket=2;
	
	// Declare and define arrays for the available choice of seats to the current passenger
		static String[] ASeatArr = {"1A","6A","11A"};
		static String[] DSeatArr = {"1A","6A","11A"};
		
		// Convert the above arrays to ArrayList type (to make it possible to later use .remove() on the currently selected seats,
		// so that the same seats cannot be selected more than once for the next passengers)
		static ArrayList<String> ASeatArrList = new ArrayList<>(Arrays.asList(ASeatArr));
		static ArrayList<String> DSeatArrList = new ArrayList<>(Arrays.asList(DSeatArr));
		
		// Declare variables for currently selected seats in the currently displayed UI
		static String selectedDSeat;
		static String selectedASeat;
		
	public static void main(String[] args) throws IOException 
	{
		String fname;
		String surname;
		String dob;
		int tel;
		String email;
		int bags=2;
		double bagCosts;
		String selectedDSeat;
		String selectedASeat;
		double totalRestaurant;
		long therandom;
		int numberTickets=3;
		int noticket=2;
	}
	
//getFname
	public static boolean getFname(String fname) 
	{
		
		boolean validFname;
	
		if (fname.matches("[a-zA-Z]{3,20}")) //if fname matches capital and lower case letters
		{
			validFname= true; //then it is a valid name
		
		} 
	
		else 
		{
			validFname= false;
			JOptionPane.showMessageDialog(null, "Please input valid name"); //if it is not valid display this
		}
		return validFname;
	}
	
//getLname
	public static boolean getLname(String surname) 
	{
		boolean validLname;
	
		if (surname.matches("[a-zA-Z]{3,20}")) //if surname matches capital and lower case letters from a-z, minumum of 3 characters and maximum of 25
		{
			validLname= true;
		
		} 
		else 
		{
			validLname= false;
			JOptionPane.showMessageDialog(null, "Please input valid surname");//display message if false
			
		}
		return validLname;
	}
	
//getDOB
	public static boolean getDOB(String dob)
	{
		boolean validDOB;														//the method will accept:
		if (dob.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(\\d{4})")) //The regex
		{
			validDOB=true;
		}
		else
		{
			validDOB= false;
			JOptionPane.showMessageDialog(null,"Please input a valid date of bith, in the form dd/mm/yyyy.");// display message if false
		}
		return validDOB;
	}
		
//getEmail
	public static boolean getEmail(String email)
	{
		
		boolean validEmail;							  //the method will accept:
		String emailRegex= "[a-zA-Z0-9_+&*-]+(?:\\."+ //capital and lower case alphabet letters, numbers and _+&*-, followed by an optional full stop
                "[a-zA-Z0-9_+&*-]+)*@" + 			  //capital and lower case alphabet letters, numbers and _+&*-, followed by an @
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +         //capital and lower case alphabet letters, numbers, followed by a full stop
                "A-Z]{2,7}";						  //capital and lower case alphabet letters, numbers. These have a range of 2 to 7
		if (email.matches(emailRegex)&& !email.equals(null)) //if the above regex is met and the email is not null
		{
			validEmail= true;
		}
		else 
		{
			validEmail=false;
			JOptionPane.showMessageDialog(null, "Please input a valid email address.");
		}
		return validEmail;   
	}
	
//getTel
	public static boolean getTel(int tel) 
	{
		int length = String.valueOf(tel).length();
		boolean validT;
		if(length>=9 && length<=15) //length range
		{
			validT=true;
		}
		else 
		{
			validT=false;
			JOptionPane.showMessageDialog(null, "Please input a valid telephone number.");		
		}
		return validT;
	}
	
//getBags
	public static boolean getBags(int bags) 
	{
		boolean validbags;
		double bagCosts = 0;
		if(bags<=1 & bags>=0) 
		{
			validbags=true;
			
		}
		else if (bags>1)// if bags is more than one
		{ 
			validbags=true;
			bagCosts=bags*25-25;//it will add 25 for each extra bag
			JOptionPane.showMessageDialog(null, "There will be an extra charge of "+bagCosts+ " for the extra bag/s");
		}
		else if (bags!=(int)bags)//if input is not an int
		{
			validbags=false;
			bagCosts=0;
			JOptionPane.showMessageDialog(null, "Please input a valid number of bags");
		}
		else
		{
			validbags=false;
			JOptionPane.showMessageDialog(null, "Please input a valid number of bags");
		}
		
		return validbags;
	}
//getDepartureSeat
	
	/*public static boolean getDepartureSeat(String dSeat) 
	{
		//myLocalVar = myClass.getMyVarVal();
		boolean validDSeat;
		if(/*myLocalVar==dSeat)
		{
			validDSeat=true;
		}
		else
		{
			validDSeat=false;
			JOptionPane.showMessageDialog(null, "Please input a valid departure seat number, as previously selected");
		}
		return validDSeat;
	}*/
//getArrivalSeat
	/*public static boolean getArrivalSeat(String aSeat) 
	{
		boolean validASeat;
		if(/*myLocalVar==dSeat)
		{
			validASeat=true;
		}
		else
		{
			validASeat=false;
			JOptionPane.showMessageDialog(null, "Please input a valid arrival seat number, as previously selected");
		}
		return validASeat;
	}*/
//Random ticket number
	public static boolean ticket(String fname,String surname, 
			String dob, int tel, String email,int bags)
	{ 
		//noticket=3;
		boolean everythingvalid = false;
		long therandom=0;
		if(getFname(fname)==true & getLname(surname)==true &   //checking if following methods return true    
				getDOB(dob)==true & getTel(tel)==true & getEmail(email)==true& getBags(bags)==true)
		{
			everythingvalid=true;
			therandom = (long) (Math.random()*Math.pow(10,8)); //if methods return true generate random number
			JOptionPane.showMessageDialog(null, "This is your ticket number: "+therandom);//display random number
			noticket--;
			if(noticket>0) 
			{
				PassengersUI passengerWindow=new PassengersUI();
			//PassengerUI myFrame;
			//myFrame = new PassengerUI();
			}
			else 
			{
				System.exit(0);
			}
			
		}
		
		else
		{
			everythingvalid=false;//if there is at least one method that is false then it is false
		}
		
		return everythingvalid;
		
	}
	
	// writeInCSV if there was a csv
/*	public static void writeInCSV(String fname, String surname, String dob, 
			int tel, String email, int bags, long therandom) throws IOException 
	{
		//writing into the existing file ..
		FileWriter write = new FileWriter("c:\\Temp\\file.txt", true);
	    BufferedWriter bw = new BufferedWriter(write);
	    
	    	if(getFname(fname)==true && getLname(surname)==true && //checking if the above methods return true
					getDOB(dob)==true && getTel(tel)==true && getEmail(email)==true) 
	    	{
	    		//if they return true then their input can be stored 
	    		bw.write(fname + ", ");
	    		bw.write(surname+ ", ");
	    		bw.write(dob+ ", ");
	    		bw.write(tel+ ", ");
	    		bw.write(email+ ", ");
	    		bw.write(bags+ ", ");
	    		//bw.write(dSeat+", ");
	    		//bw.write(aSeat+ ", ");
	    		bw.write(therandom+ ", ");
			    bw.newLine();
	    	}
		  
		bw.close();
		write.close();
		
	}*/

		
	
	
}


