package Main;

import java.util.Scanner;

public class keyboardInput {
	// Fields
	private Scanner keyb;
	
	// Constructor
	public keyboardInput()
	{
		keyb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine()
	{
		// TODO: Use the scanner object to acquire a String and return this String to the caller
		
		return keyb.nextLine();
		
	}
	
	public int getIntKeyBoard()
	{
		
		while(!keyb.hasNextInt())
		{
			System.out.println("Input is invalid. Please enter a valid integer.");
			keyb.next();
		}
		 int input = keyb.nextInt();
		 keyb.nextLine(); //to consume new line character
		 
		 return input;
	}
	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void close()
	{
		keyb.close();
	}


	

	
	
	
}
