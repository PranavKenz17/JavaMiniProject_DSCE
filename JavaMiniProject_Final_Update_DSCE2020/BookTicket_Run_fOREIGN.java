package user_data;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookTicket_Run {

	public static void main(String[] args) {
		MovieTicket log = new MovieTicket();
		log.login();
		log.Initialdisplay();
	}
}
class MovieTicket {
	int userid;//make it string
	int password; 
	 @SuppressWarnings("resource")
	void login() {//make it public void
		 boolean flag = true;
		 while (flag) {
			 try
		  {
			 Scanner ssc = new Scanner(System.in);
		 System.out.println("Enter your USER ID");
		 userid=ssc.nextInt();//.nextLine
		 
		  if(userid==1234)  //userid==”admin” or any name
			 {
			  boolean flat=false;
			  while (!flat) {
			  try
			  {
				  Scanner scc = new Scanner(System.in);
				 System.out.println("Enter PASSWORD");
				 password=scc.nextInt();
					  if(password == 1234)
					{
						  
					 System.out.println("Login Succesfull\n");
					 System.out.println("Welcome to FilmBros \n");
					 flag = false;
					 flat=true;
					}
					  else 
					  {
						  System.out.println("Incorrect Password");
					  }
				  }
				  
				  catch(InputMismatchException e){
					  System.out.println("Incorrect Password  "+e);
				  }
			  }
				  
			 }
		  else
			  {
				  System.out.println("Incorrect USER ID ");
			  }
		 
		  } catch(InputMismatchException e){
			  System.out.println("Incorrect USER ID "+e);
		  }
		 
		 }
	 }

@SuppressWarnings("resource")
public void Initialdisplay() {
	
	 System.out.println("Select your choice :");
	 System.out.println("1.Book new ticket\n2.Modification of the booking\n3.Display bookings details\n"
	 		+ "4.Cancel a Booking\n 5: Exit\n");
	 boolean bool = false;
	 while(!bool) {
		 try
		  {
		 
	 Scanner sc = new Scanner(System.in);
	int ch1 =sc.nextInt();
	
	 switch(ch1) 
	 {
	 case 1:    Input input = new Input();
				input.Basic_input(); 
	         break;        
	 case 2: 	Update u = new Update();
				u.update(); 
				Initialdisplay();//recursion function.calls the initial display  
	        break;
	 case 3: int n;
	 		 System.out.println("Enter 1:Display All users \t2:Display According to movie");
	 		 n = sc.nextInt(); 
	 		 switch(n) {
	 		 case 1:Display d = new Display("SELECT * FROM java_project.bookings;");
	 		 		d.display();
	 		 		break;
	 		 case 2:System.out.println("Enter Movie Name");
	 		  		Scanner mov = new Scanner(System.in);
	 		  		String moviename = mov.nextLine();
	 			    
	 			    Display disp = new Display("SELECT * FROM java_project.bookings where `movie name`='" + moviename + "';");
					disp.display();
					Initialdisplay();
	 		 		break;
	 		 default : System.out.println("Invalid Input");
	 		 }
	         break;
	 case 4 : Delete de = new Delete();
			  de.delete();
	         break;
	 case 5 : System.exit(0);
		 	 break;
	 default :System.out.println("Invalid Input");
		  }
	 }
	catch(InputMismatchException e)
		 {
			 System.out.println("Invalid Input "+e);
		 }
	 }
	 }
}

