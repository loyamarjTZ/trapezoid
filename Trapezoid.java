/*
This program will display a trapezoid whose top and bottom lengths are determined by the user.
The user also chooses what symbol will be used to draw the trapezoid.
*/

//imports the Scanner class
import java.util.Scanner;

//Class definition
public class Trapezoid {
		
	//Static variables
	static int topLength;
	static int bottomLength;	
	static char fillerSymbol;
    	static boolean validInput;
	static Scanner scan = new Scanner(System.in);
	
	//Main function
	public static void main(String[] args) {  
		obtainTopLength();     //O(1)
		obtainBottomLength();  //O(1)
		obtainFillerSymbol();  //O(1)
       		displayTrapezoid();    //O(n^2)
	}        
      
	//Gets the top length of the trapezoid
	public static void obtainTopLength() {
		validInput = false;
		do{
            		//Prompts the user to enter the top length of the trapezoid.
            		System.out.println("Please enter an ODD integer in the range 1 - 15: ");
			topLength = scan.nextInt();
            		System.out.println("\nYou entered: " + topLength);
            
            		//Verifies if the topLength value is valid.
			if( (topLength>=1 && topLength<=15) && (topLength%2 != 0) ){
                		System.out.println("Your input of " + topLength + " is accepted.\n");
				validInput = true;  
			} else {
                		System.out.println("Your input of " + topLength + " is invalid.\n");
            		}
		}while(validInput == false);
	}
	
    //Gets the bottom length of the trapezoid
	public static void obtainBottomLength() {
		validInput = false;
        	do{
            		//Prompts the user to enter the bottom length of the trapezoid.
            		System.out.println("Please enter an ODD integer in the range 3 - 17 AND is greater than your previously accepted input: ");
            		bottomLength = scan.nextInt();
            		System.out.println("\nYou entered: " + bottomLength);

            		//Verifies if the bottomLength value is valid.
            		if( (bottomLength>=3 && bottomLength<=17) && (bottomLength%2 != 0) && (bottomLength>topLength)) {
                		System.out.println("Your input of " + bottomLength + " is accepted.\n");
                		validInput = true;
			} else {
                		System.out.println("Your input of " + bottomLength + " is invalid.\n");
            		}
        	}while(validInput == false);
	}
	
	public static void obtainFillerSymbol(){
		//Obtain the character of choice
		System.out.println("Please enter any character: ");
		String userInput = scan.next();
		fillerSymbol = userInput.charAt(0);
	}

    	//Displays the trapezoid to the user
	public static void displayTrapezoid() {
        	//Local variables
		int numberOfChars = topLength;
		int numberOfSpaces = (bottomLength-topLength)/2;
		
		System.out.println("\nBelow is your trapezoid:\n");

        	//Displays the trapezoid
		while(numberOfSpaces>=0) {
            		for (int i = numberOfSpaces; i > 0; i--)
             			System.out.print(" ");
            
            		for (int j = numberOfChars; j > 0; j--)
             			System.out.print(fillerSymbol);
            
        		System.out.println();
            		numberOfSpaces--;
            		numberOfChars+=2;
        	} 
		System.out.println();
    	}
}
