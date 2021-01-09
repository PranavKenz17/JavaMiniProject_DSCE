package user_data;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;


@SuppressWarnings("unused")
public class BookTicket_Final {

	public static void main(String[] args) {
//		Input input = new Input();
//		input.Basic_input();
		
	}
}

class Input {
	@SuppressWarnings("unused")
	boolean numberOrNot(String input)//takes in the phone number as string and parse the input string into a long int.returns true or false.
	{								 //If all the elements in the string is an int it returns true.Else false.
	    try
	    {
	    	long l=Long.parseLong(input); 
	    }
	    catch(NumberFormatException ex)
	    {
	        return false;
	    }
	    return true;
	}
	
	@SuppressWarnings({ "unused", "resource" })
	public void Basic_input()
	{
		ResultSet rs1 = null;
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Name");
			String name = sc.nextLine();
			
			System.out.println("Enter Phone number");
			String number = sc.nextLine();
			boolean qwerty = false;//Checks the length of the entered phone number.If all are integer type and of length 10, the prog proceeds.
			while(!qwerty) {	   //Else it is stuck in a while loop till the proper input is given.
				if(numberOrNot(number) && (number.length() == 10))
				{break;}
				else
				{
				    System.out.println("Sorry! You have entered invalid mobile number. Try again...");
				    number = sc.nextLine();
				}
			}

			String movieis = null ;
			boolean doon = false;
			System.out.println("Select a Movie :");
			System.out.println("1) GOODFELLAS\t2) MAGNOLIA\t3) RESEVOIR DOGS ");
			System.out.println("4) DUNE\t5) GANGS OF WASSEYPUR\t6) EYES WIDE SHUT");
			System.out.println("7) DEPARTED\t8) THE FLORIDA PROJECT\t9) NIGHTCRAWLER ");
			System.out.println("10) DRIVE \t11) BLADERUNNER \t12) EX MACHINA ");
			while (!doon) {//A while loop to take in movie options. If the proper num is not entered, it loops until the input is valid
				try {	   //If an error is caught the block continues to execute in the while loop.
					Scanner zzz = new Scanner(System.in);

					int opt = zzz.nextInt();
					switch(opt) {
					  case 1:
						  movieis ="GOODFELLAS";
						  doon = true;
					    break;
					  case 2:
						  movieis ="MAGNOLIA";
						  doon = true;
					    break;
					  case 3:
						  movieis ="RESEVOIR DOGS";
						  doon = true;
						    break;
					  case 4:
						  movieis ="DUNE";
						  doon = true;
						    break;
					  case 5:
						  movieis ="GANGS OF WASSEYPUR";
						  doon = true;
						    break;
					  case 6:
						  movieis ="EYES WIDE SHUT";
						  doon = true;
						    break;
					  case 7:
						  movieis ="DEPARTED";
						  doon = true;
						    break;
					  case 8:
						  movieis ="THE FLORIDA PROJECT";
						  doon = true;
						    break;
					  case 9:
						  movieis ="NIGHTCRAWLER";
						  doon = true;
						    break;
					  case 10:
						  movieis ="DRIVE";
						  doon = true;
						    break;
					  case 11:
						  movieis ="BLADERUNNER";
						  doon = true;
						    break;
					  case 12:
						  movieis ="EX MACHINA";
						  doon = true;
						    break;
					  default:
						  System.out.println("Choose a valid option :");
					}
				}
				    catch(Exception e) {
			      System.out.println("Choose a valid number (between 1-12)");
			        }
			}
			
			
			String moviename = movieis;
			
			System.out.println("Select date of booking :");
			
			System.out.println("1) Choose a Month :(Enter a number between 1 and 12)");
			
			String monthis = null ;
			boolean don = false;
			while (!don) {//A while loop to take in the month. If the proper option is not entered, it loops until the input is valid i.e 1 to 12
				try {	  //If an error is caught the block continues to execute in the while loop.
					Scanner sss = new Scanner(System.in);
					int month = sss.nextInt();
					switch(month) {
					  case 1:
						  monthis ="January";
						  don = true;
					    break;
					  case 2:
						  monthis ="Febuary";
						  don = true;
					    break;
					  case 3:
						  monthis ="March";
						  don = true;
						    break;
					  case 4:
						  monthis ="April";
						  don = true;
						    break;
					  case 5:
						  monthis ="May";
						  don = true;
						    break;
					  case 6:
						  monthis ="June";
						  don = true;
						    break;
					  case 7:
						  monthis ="July";
						  don = true;
						    break;
					  case 8:
						  monthis ="August";
						  don = true;
						    break;
					  case 9:
						  monthis ="September";
						  don = true;
						    break;
					  case 10:
						  monthis ="October";
						  don = true;
						    break;
					  case 11:
						  monthis ="November";
						  don = true;
						    break;
					  case 12:
						  monthis ="December";
						  don = true;
						    break;
					  default:
						  System.out.println("Choose a valid option :");
					}
				}
				    catch(Exception e) {
			      System.out.println("Choose a valid number (between 1-12)");
			        }
			}
			
			System.out.println("\nEnter date");

			int dat=0;
			boolean doono = false;
			while (!doono) {// Date entered can be only in between 1 to 31. Stays in loop till input is valid
			try {
				Scanner qqq = new Scanner(System.in);
				dat = qqq.nextInt();
				if(dat >0 && dat<32){ doono=true; }
			else {
				System.out.println("Enter a valid date ");
			}
			}
			catch(Exception e) {
			      System.out.println("Enter valid date :");
			        }
			}
			String date = dat+"_"+monthis;
			String bookingdate = date;
			
			String filename = movieis +"_"+ date;//Used to make a custom file acc to moviename and date.
			boolean fileExist = false;
			 File myObject = new File("E:\\EclipseProjects\\JavaProject\\"+filename+".txt");//File class object to create new file
	  			String  fileAddress = "E:\\EclipseProjects\\JavaProject\\"+filename+".txt";
	  			
			      try {

			          // trying to create a file based on the object
			          boolean value = myObject.createNewFile();
			          if (value) { 
			            FileWriter myWriter = new FileWriter(fileAddress);
			            int i,j,k=1;
						
						int [][] arr = new int[6][6];
						
						for( i = 0;i<6;i++) 		//Stores a matrix of 6x6 in array a
							for( j =0; j<6;j++)
									arr[i][j]=k++;
								
						for( i = 0;i<6;i++) 
							{
							for( j =0; j<6;j++) {  //Writes the matrix of 6x6 in array a to the file
								myWriter.write("\t"+arr[i][j]);	
							}
								
							myWriter.write("\n");
							}
						 myWriter.close();
			          }
			          else {
			        	  fileExist = true;
			        	  String Cseats = movieis +"_"+ date+" Booked_Seats";//File stores the booked seats in a certain format
			        	  String  CfileAdd = "E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt";
			        	  File myOb = new File(CfileAdd);
			  			Scanner myRead = new Scanner(myOb);
			  				String data = myRead.nextLine();
			  				String[] items = data.split(" ");//the data in file is split where a space is found in between

			  				int[] results = new int[items.length];

			  				for (int i1 = 0; i1 < items.length; i1++) {
			  				    try {
			  				        results[i1] = Integer.parseInt(items[i1]);//the string is converted to int type and stores in results array
			  				    } catch (NumberFormatException nfe) {
			  				        //NOTE: write something here if you need to recover from formatting errors
			  				    };
			  				}
			  			FileWriter myWriter = new FileWriter(fileAddress);
			  			int i1,j,k=1;
			  			
			  			int [][] arr = new int[6][6];
			  			
			  			for( i1 = 0;i1<6;i1++) 
			  				for( j =0; j<6;j++)
			  						arr[i1][j]=k++;
			  					
			  			for( i1 = 0;i1<6;i1++) 
			  				{
			  				for( j =0; j<6;j++) {
			  					for (int element : results) { //checks the file and the array results and replaces the seat matrix with 0's if  
			  			            if (element == arr[i1][j]) { //the numbers math so as to show the seats already booked.
			  			            	arr[i1][j] = 0;
			  			            }
			  			        }
			  					myWriter.write("\t"+arr[i1][j]);//rewrites the entire array to the file	
			  				}
			  					
			  				myWriter.write("\n");
			  				}
			  			myWriter.close();
			            
			          }
			        }
			        catch(Exception e) {
			          e.getStackTrace();
			        }
			      
			      int seattype = 1;      
			System.out.println("Enter Seat Type\n1:Basic(Rs.200)  2:Silver(Rs.300)  3:Gold(Rs.450)");
			boolean bn = false;
			while(!bn) {
			try {
			for(int p=0;p>-1;p++) {//breaks out of the loop only if 1,2 or 3 is entered.
				Scanner sr = new Scanner(System.in);
			seattype = sr.nextInt();
			switch(seattype) {
			  case 1:
				  p=-10;//comes out of the for loop
				  bn = true;//comes out of while loop
			    break;
			  case 2:
				  p=-10;
				  bn = true;
			    break;
			  case 3:
				  p=-10;
				  bn = true;
				    break;
			  default:
				  System.out.println("Choose a valid option :");
			}
			}
			}
			 catch(Exception e) {
				 System.out.println("Choose a valid option :");
		          e.getStackTrace();
		        }
			}
			System.out.println("Enter Number of seats to be Booked");
			int numberofseat = 0;
			boolean bnn = false;
			while(!bnn) 
			{
				try {
			for(int p=0;p>-1;p++) {//checks to make sure only 6 seats are booked. Else asks to re-enter all seats
				Scanner srr = new Scanner(System.in);
				numberofseat = srr.nextInt();
				if(numberofseat <7 && numberofseat >0 )
				{p=-10;
				bnn = true;
				    break;
				    }
				else{System.out.println("You can book a maximum of 6 seats at one go.\nEnter Number of seats to be Booked");}
				}
			}
			catch(Exception e) {
				 System.out.println("Choose a valid option :");
		          e.getStackTrace();
		        }
			}
				
			
			File myObj = new File(fileAddress);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			
			System.out.println("Seat number 1-12 : Basic\nSeat number 13-24 : Silver\nSeat number 25-36 : Gold\n");
			System.out.println("Seats marked with ' 0 ' are not available");
			System.out.println("Enter Seat Numbers of your choice: ");
			
			int[] seatnumbers = new int[numberofseat];
			String Cseats = movieis +"_"+ date+" Booked_Seats";//custom files to store booked seats.Used to update seat matrix 
			
			File newObject = new File("E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt");
			
			String  CfileAdd = "E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt";
			boolean bln = false;
			while(!bln) {
				try {
			for(int i = 0; i < numberofseat; i++)
			{
				String typ;
				if (seattype==1) {
					typ = "Basic";
					Scanner rr = new Scanner(System.in);
					seatnumbers[i] = rr.nextInt();
					boolean zz = false;
					if(fileExist) {
					String Cseat = movieis +"_"+ date+" Booked_Seats";
		        	  String  CfileAd = "E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt";
		        	  File myOb = new File(CfileAd);
		  			Scanner myRead = new Scanner(myOb);
		  				String data = myRead.nextLine();
		  				String[] items = data.split(" ");
		  				int[] results = new int[items.length];

		  				for (int i1 = 0; i1 < items.length; i1++) {
		  				    try {
		  				        results[i1] = Integer.parseInt(items[i1]);
		  				    } catch (NumberFormatException nfe) {
		  				        //NOTE: write something here if you need to recover from formatting errors
		  				    };
		  				}
		  				for (int element : results) { 
	  			            if (element == seatnumbers[i]) { 
	  			            	zz = true;
	  			            }
	  			        }
		  			}
					// for loop to check booked tickets
					boolean qq = false;
					for (int p = 0; p < numberofseat; p++) {
			        for (int j = p + 1; j < numberofseat; j++) {//1231
			        	if (seatnumbers[j] == 0 ) {
			                //qq = true;
			            }
			        	else if (seatnumbers[p] == seatnumbers[j] ) {
			                qq = true;
			            }
			        }
			    }
					if (seatnumbers[i] <= 0||seatnumbers[i]>12) {
						System.out.println("You need to choose seats in the range (1-12) \nEnter your next seats :");
						i--;//decreases i by 1 to ensure all required seats  are selected
					}
					else if(qq || zz) {
						System.out.println("You need to select different seats :");
						i--;
					}
					else {
						 FileWriter fw = new FileWriter(CfileAdd,true); //the true will append the new data i.e the booked seats elements
					     fw.write(" "+seatnumbers[i]);//appends the string to the file
					     fw.close();
					     bln = true;
					}
					}
				else if(seattype==2) {
					typ = "Silver";
					Scanner rr = new Scanner(System.in);
					seatnumbers[i] = rr.nextInt();
					
					boolean zz = false;
					if(fileExist) {
					String Cseat = movieis +"_"+ date+" Booked_Seats";
		        	  String  CfileAd = "E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt";
		        	  File myOb = new File(CfileAd);
		  			Scanner myRead = new Scanner(myOb);
		  				String data = myRead.nextLine();
		  				String[] items = data.split(" ");
		  				int[] results = new int[items.length];

		  				for (int i1 = 0; i1 < items.length; i1++) {
		  				    try {
		  				        results[i1] = Integer.parseInt(items[i1]);
		  				    } catch (NumberFormatException nfe) {
		  				        //NOTE: write something here if you need to recover from formatting errors
		  				    };
		  				}
		  				for (int element : results) { 
	  			            if (element == seatnumbers[i]) { 
	  			            	zz = true;
	  			            }
	  			        }
		  			}
					boolean qq = false;
					for (int p = 0; p < numberofseat; p++) {
			        for (int j = p + 1; j < numberofseat; j++) {
			        	if (seatnumbers[j] == 0 ) {
			                //qq = true;
			            }
			        	else if (seatnumbers[p] == seatnumbers[j] ) {
			                qq = true;
			            }
			        }
			    }
					if (seatnumbers[i]<=12 || seatnumbers[i]>24) {
						System.out.println("You need to choose seats in the range (13-24) \nEnter your next seats :");
						i--;
					}
					else if(qq || zz) {
						System.out.println("You need to select different seats :");
						i--;
					}
					else {
						 FileWriter fw = new FileWriter(CfileAdd,true); //the true will append the new data
					     fw.write(" "+seatnumbers[i]);//appends the string to the file
					     fw.close();
					     bln = true;
					}
					}
				else {
					typ = "Gold";
					Scanner rr = new Scanner(System.in);
					seatnumbers[i] = rr.nextInt();
				
					boolean zz = false;
					if(fileExist) {
					String Cseat = movieis +"_"+ date+" Booked_Seats";
		        	  String  CfileAd = "E:\\EclipseProjects\\JavaProject\\"+Cseats+".txt";
		        	  File myOb = new File(CfileAd);
		  			Scanner myRead = new Scanner(myOb);
		  				String data = myRead.nextLine();
		  				String[] items = data.split(" ");
		  				int[] results = new int[items.length];

		  				for (int i1 = 0; i1 < items.length; i1++) {
		  				    try {
		  				        results[i1] = Integer.parseInt(items[i1]);
		  				    } catch (NumberFormatException nfe) {
		  				        //NOTE: write something here if you need to recover from formatting errors
		  				    };
		  				}
		  				for (int element : results) { 
	  			            if (element == seatnumbers[i]) { 
	  			            	zz = true;
	  			            }
	  			        }
		  			}
					boolean qq = false;
					for (int p = 0; p < numberofseat; p++) {
			        for (int j = p + 1; j < numberofseat; j++) {
			        	if (seatnumbers[j] == 0 ) {
			                //
			            }
			        	else if (seatnumbers[p] == seatnumbers[j] ) {
			                qq = true;
			            }
			        }
			    }
					if (seatnumbers[i]<=24||seatnumbers[i] > 36) {
						System.out.println("You need to choose seats in the range (25-36) \nEnter your next seats :");
						i--;
					}
					else if(qq || zz) {
						System.out.println("You need to select different seats :");
						i--;
					}
					else {
						 FileWriter fw = new FileWriter(CfileAdd,true); //the true will append the new data
					     fw.write(" "+seatnumbers[i]);//appends the string to the file
					     fw.close();
					     bln = true;
					     
					}
				}
			}
			}
			catch(Exception e) {
				 System.out.println("Invalid Input\n You need to enter your seats again.");
		          e.getStackTrace();
		          bln = false;
		        }
		}
			
			System.out.println("\nSummary:\n");			
			int amt;
			String type;
			if (seattype==1) {
				type = "Basic";
				System.out.println("You have selected "+type+" which costs 200 per seat.");
				amt = 200;}
			else if(seattype==2) {
				type = "Silver";
				System.out.println("You have selected "+type+" which costs 300 per seat.");
				amt = 300;}
			else {
				type = "Gold";
				System.out.println("You have selected "+type+" which costs 450 per seat.");
				amt = 450;}
			double amount_to_be_paid = numberofseat * amt ;
			System.out.println("Number of seats booked : "+numberofseat);
			System.out.println("\nTotal amount to be Paid: Rs." +amount_to_be_paid+"\n");
			System.out.println("Booked Seats: "+Arrays.toString(seatnumbers));

			File myOb = new File(CfileAdd);
			Scanner myRead = new Scanner(myOb);
				String data = myRead.nextLine();
				String[] items = data.split(" ");

				int[] results = new int[items.length];

				for (int i1 = 0; i1 < items.length; i1++) {
				    try {
				        results[i1] = Integer.parseInt(items[i1]);
				    } catch (NumberFormatException nfe) {
				        //NOTE: write something here if you need to recover from formatting errors
				    };
				}
			FileWriter myWriter = new FileWriter(fileAddress);
			int i1,j,k=1;
			
			int [][] arr = new int[6][6];
			
			for( i1 = 0;i1<6;i1++) 
				for( j =0; j<6;j++)
						arr[i1][j]=k++;
					
			for( i1 = 0;i1<6;i1++) 
				{
				for( j =0; j<6;j++) {
					for (int element : results) { 
			            if (element == arr[i1][j]) { 
			            	arr[i1][j] = 0;
			            }
			        }
					myWriter.write("\t"+arr[i1][j]);	
				}
				myWriter.write("\n");
				}
			myWriter.close();
			System.out.println("\nUpdated the available seats ");
			File myOj = new File(fileAddress);
			Scanner mRead = new Scanner(myOj);
			while (mRead.hasNextLine()) {
				String datt = mRead.nextLine();
				System.out.println(datt);
			}


			Class.forName("com.mysql.jdbc.Driver");//JDBC to MySQL
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?user=root&password=root");
            System.out.println("Connected to MySQL");
            Statement st = con.createStatement();
            //the string query to be used to execute the insert statement.Uses standard MySQL syntax.
           String query1 = " INSERT INTO `java_project`.`bookings`(`Name`,`Phone Number`,`BookingDate`,`Number of seats`,`Seat Numbers`,`Amount to be paid`,`Movie Name`,`Seat Type`) VALUES ('" + name  + "','" + number+ "','" + bookingdate + "'," +  numberofseat + ",'" +  Arrays.toString(seatnumbers) + "'," + amount_to_be_paid + ",'" + moviename + "','"+ type +"');";

            int userid=0;
            int rowsinserted = st.executeUpdate(query1,Statement.RETURN_GENERATED_KEYS);//executes the query and
            // Returns either the row count for SQL Data Manipulation Language statements or 0 for SQL statements that return nothing
            if(rowsinserted > 0)
            {
            	rs1 = st.getGeneratedKeys();
                if(rs1.next())
                    userid = rs1.getInt(1);
                
                System.out.print(userid);
            	System.out.println(" record inserted into database");
            }
            else
            {
            	System.out.println("No record was inserted");
            }
            
//            Display disp = new Display("SELECT * FROM java_project.bookings;");
//            disp.display();
                      
//            con.close();
//            sc.close();
            System.out.println("\nYour tickets have been booked. ");
            MovieTicket mt = new MovieTicket();
		    mt.Initialdisplay();//Calls the function to initiate the multiple options on inserting deleting and displaying the Bookings. 
     } 
     catch (Exception ex) {
            ex.printStackTrace();
     }
  }
}

class Display{
	
	private String _query;
	Display(String Query)
	{
		_query = Query;
	}
	
	public void display() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?user=root&password=root");
            System.out.println("Connected to MySQL");
            Statement st = con.createStatement();
            //Statement stmovie = con.createStatement();
            ResultSet rs = st.executeQuery(_query);//Executes the query passed through the constructor
            //Padding is used to get uniform table like display.
            System.out.println(rightPadding("Id",' ',5) +"  "+rightPadding("Name",' ',20) +"  "+rightPadding("Number",' ',15) +"  "+rightPadding("Date",' ',15)+"  "+rightPadding("Seats",' ',8) +"  "+rightPadding("SeatNo",' ',20) +"  "+rightPadding("Amount",' ',15)+ "  " + rightPadding("Moviename",' ',10)+"  " /*+ rightPadding("Hallname",' ',10)+"  "*/+ rightPadding("Type",' ',10)) ;

            while(rs.next())//the while loop iterates through all the elements in the row and stores them in the respective variables
            {				//the variables are then displayed in the print statement row by row
            	String Id = rs.getString("id");
            	String Name = rs.getString("Name");
            	String Number = rs.getString("Phone Number");
            	String Seats = rs.getString("Number of seats");
            	String Date = rs.getString("BookingDate");
            	String SeatNo = rs.getString("Seat Numbers");
            	String Moviename = rs.getString("Movie Name");
            	String Amount = rs.getString("Amount to be paid");
            	//String Hallname = "";
            	String Type = rs.getString("Seat type");
            //	ResultSet rsmovie = stmovie.executeQuery("SELECT * FROM java_project.moviemaster where MovieName='"+ Moviename + "';");
            	
//            	while(rsmovie.next())
//                {
//            		Hallname = rsmovie.getString("HallName");
//                }
            	System.out.println(rightPadding(Id,' ',5) +"  "+rightPadding(Name,' ',20) +"  "+rightPadding(Number,' ',15) +"  "+rightPadding(Date,' ',15)+"  "+rightPadding(Seats,' ',8) +"  "+rightPadding(SeatNo,' ',20) +"  "+rightPadding(Amount,' ',15)+ "  " + rightPadding(Moviename,' ',10)+"  " /*+ rightPadding(Hallname,' ',10)+"  "*/+ rightPadding(Type,' ',10)) ;
 //           	rsmovie.close();
            }
            
            con.close();

     } 
     catch (Exception ex) {
            ex.printStackTrace();
     }
	}
	
	private String rightPadding(String input, char ch, int L) //function to use rightpadding
	{ 

	    String result 
	        = String 
	              .format("%" + (-L) + "s", input) 
	              .replace(' ', ch); 

	    return result; 
	} 
}

class Update{
	@SuppressWarnings({ "unused", "resource" })
	void update() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?user=root&password=root");
            System.out.println("Connected to MySQL");
        Statement st = con.createStatement();
        
		Scanner u = new Scanner(System.in);
		Input ip = new Input();
		//First display table
		Display d = new Display("SELECT * FROM java_project.bookings;");//Displays entire table
		d.display();
		System.out.println("Enter id to Modify");// Option to modify according to unique id which is uto generated.
		int id = u.nextInt();//Allows only to change name and phone number
		
		//System.out.println("Enter Name1");
		String name1 = u.nextLine();
		
		System.out.println("\nEnter Name");
		String name = u.nextLine();
		System.out.println("Enter Phone number");
		String number = u.nextLine();
		boolean qwerty = false;
		while(!qwerty) {
			if(ip.numberOrNot(number) && (number.length() == 10))
			{
			    break;
			}
			else
			{
			    System.out.println("Sorry! You have entered invalid mobile number. Try again...");
			    number = u.nextLine();
			}
		}

		
		//Enter Primary key to modify. Id in this case.
		String query2 = "UPDATE `java_project`.`bookings` SET `Name` = '"+ name +"',`Phone Number` = '"+ number +"' WHERE id = "+ id +";";
		int rowsinserted = st.executeUpdate(query2,Statement.RETURN_GENERATED_KEYS);
		
		d.display();
		System.out.println("\nUPDATED\n Your changes have been saved.");

		MovieTicket mt = new MovieTicket();
	    mt.Initialdisplay();
		
        } 
		   catch (Exception ex) {
           ex.printStackTrace();
       }
		
	}
}

class Delete{
	@SuppressWarnings("unused")
	public static String fileToString(String filePath) throws Exception{
	      String input = null;
	      Scanner sc = new Scanner(new File(filePath));
	      StringBuffer sb = new StringBuffer();
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	         sb.append(input);
	      }
	      return sb.toString();
	   }
	@SuppressWarnings({ "resource", "unused" })
	void delete() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_project?user=root&password=root");
            System.out.println("Connected to MySQL");
	        Statement st1 = con.createStatement();
	        
			Scanner de = new Scanner(System.in);
			Display d = new Display("SELECT * FROM java_project.bookings;");//Initially displays entire table
			d.display();
			
			System.out.println("Enter id to Delete");
			int id = de.nextInt();
			String query_ = "SELECT * FROM java_project.bookings WHERE id = '"+ id +"';";

			String Date, SeatNo = "", Moviename;

			
			ResultSet rs1 = st1.executeQuery(query_);
			String filepath1 = "";
			if(rs1.next()){
				Date = rs1.getString("BookingDate");
	        	SeatNo = rs1.getString("Seat Numbers");
	        	 System.out.println("Seat No :  "+SeatNo);
	        	Moviename = rs1.getString("Movie Name");
	        	filepath1 = Moviename+"_"+Date+" Booked_Seats";
				}
			String[] it = SeatNo.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");//Gets the seat numbers from DB
				int[] res = new int[it.length];				//splits and gets only seat numbers which is stored as an array

				for (int i = 0; i < it.length; i++) {
				    try {//stores the integers in string form in integer form using parseInt
				        res[i] = Integer.parseInt(it[i]);
				    } catch (NumberFormatException nfe) {
				        //NOTE: write something here if you need to recover from formatting errors
				    };
				}
			
			  String filePath = "E:\\EclipseProjects\\JavaProject\\"+filepath1+".txt"; // this should be 'booked seats' of the id entered above
		      String result = fileToString(filePath);
		      
		      File myOb = new File(filePath);
	  			Scanner myRead = new Scanner(myOb);
	  				String data = myRead.nextLine();
	  				String[] items = data.split(" ");//stores the booked seats as string in items array
	  				int[] results = new int[items.length];

	  				for (int i1 = 0; i1 < items.length; i1++) {
	  				    try {//stores the booked seats as integer in results array
	  				        results[i1] = Integer.parseInt(items[i1]);
	  				    } catch (NumberFormatException nfe) {
	  				    	//
	  				    };
	  				  
	  				}
	  				
	  				for (int i1 = 0; i1 < res.length; i1++) { 
	  					for (int element =0 ; element < results.length; element++) {
	  						if (results[element] == res[i1]) { 
	  							results[element] =0;//if the file with booked seats contains the element to be deleted, it stores 0 in place of that element.
	  							 //results now contains array of only booked seats i.e without the seats to be deleted.
			            }
			        }
	  				}
	  				PrintWriter writer = new PrintWriter(new File(filePath));
	  		      for (int i = 0; i < results.length; i++) {
	  		    	  String newS = " "+results[i];//Rewrites the new array to file without the elements entered to be deleted.
	  		    	writer.append(newS);
	  		        writer.flush();
	  		      }
		      
			String query3 = "DELETE FROM `java_project`.`bookings` WHERE id = '"+id+"';";
			//deletes row of the entered id from DB
			int rowsinserted = st1.executeUpdate(query3,Statement.RETURN_GENERATED_KEYS);
			
//			d.display();
			System.out.println("\nUPDATED\nYour booking are cancelled.\n");

			MovieTicket mt = new MovieTicket();
		    mt.Initialdisplay();
		    rs1.close();
			
		}
		
		 catch (Exception ex) {
	           ex.printStackTrace();
	       }
	}

}

/*class MovieUsers{
	//Displays users of the entered movie name
	 public void Display_movie() {
		
		 System.out.println("Enter Movie Name");
		 boolean somebool = false;
		 while(!somebool) 
		 {
			 try 
			 {
		    Scanner dm = new Scanner(System.in);
			String moviename = dm.nextLine();
			Display disp = new Display("SELECT * FROM java_project.bookings where `movie name`='" + moviename + "';");
			disp.display(); //Display statement to display details according to entered movie name.The statement is passed to constructor of Display class
			dm.close();
			somebool = true;
			MovieTicket mt = new MovieTicket();
		    mt.Initialdisplay();
			 }
		    catch (Exception ex) {
		    	System.out.println("\n-No such movie available-\n");
		    	
		       }
		 }	
	 }
	
}

class FileHandling{
	//Displays users of the entered movie name
	 public void WriteFile() {
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Lenovo\\Desktop\\Unity\\FilesJavaMiniProject\\TestFile.txt");
			int i,j,k=1;
			
			Integer[] ava = {1, 2};
			int [][] arr = new int[6][6];
			
			for( i = 0;i<6;i++) 
				for( j =0; j<6;j++)
						arr[i][j]=k++;
					
			for( i = 0;i<6;i++) 
				{
				for( j =0; j<6;j++) {
					for (int element : ava) { 
			            if (element == arr[i][j]) { 
			            	arr[i][j] = 0;
			            }
			            
			        }
					myWriter.write("\t"+arr[i][j]);	
				}
					
				myWriter.write("\n");
				}
			myWriter.close();
			System.out.println("Success");
		} catch(IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	 }

	
}*/
