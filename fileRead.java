package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename)
	{
		lines = new ArrayList<>();
		readFromFile(filename);
		
	}
	private void readFromFile(String filename)
	{
		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
		try 
		{ 
	     BufferedReader b = new BufferedReader(new FileReader(filename));
	     String l;
	     while((l = b.readLine()) != null) //reads the lines of the file (using b.readLine()) until end is reached so it returns null 
	    	 {
	    	 lines.add(l); //adds the line read from file to lines ArrayList
	    	 }
	     
		b.close();
		}catch(IOException e) 
		{
			System.out.println("An error occurred while reading the file: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	
	// Methods
	public int getNumberOfLines()
	{
		// TODO
		return lines.size();
	}
	
	public String getLine(int index)
	{
		if(index >= 0 && index < lines.size())
		{
			return lines.get(index);
		}else
		{
			return null;
		}
		
		
	}
}
