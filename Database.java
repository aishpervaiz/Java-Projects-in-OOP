//Name: Aishah Pervaiz 

package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Database 
{
	// Fields
	private ArrayList<Movie> movies;
	private String filename;
	
	// Constructor
			
	public Database(String filename) 
	{
		this.filename = filename;
		movies = new ArrayList<>();
	   fileRead fr = new fileRead(filename);
		int n = fr.getNumberOfLines();
   
		for(int i = 0; i < n; i++)
        {
		String l = 	fr.getLine(i);
		// TODO: Parse using the StringTokenizer here and place into movies as single entries...
		StringTokenizer t = new StringTokenizer(l, ",");
		try 
		{
		String title = t.nextToken();
		String actor1 = t.nextToken();
		String actor2 = t.nextToken();
		String director = t.nextToken();
		int year = Integer.parseInt(t.nextToken());
		int runtimesMinutes = Integer.parseInt(t.nextToken());
		movies.add(new Movie(title, actor1, actor2, director, year, runtimesMinutes));
		}
		
		catch(Exception e) 
		{
		 	System.err.println("\nError retrieving from file" + (i + 1) + ": " + e.getMessage());
		 	
		}
        }

		
	}
	
	
	// Methods
	
	//method to add the new entry to file database
	public void addEntry(Movie newEntry)
	{
		if(isValidEntry(newEntry))
		{
			movies.add(newEntry);
			saveToFile();
		}
		else
		{
		System.out.println("\nMovie entry title is invalid. Title of movie should be a minimum of three characters.");	
		}
	}
	
	//method to make sure entry is valid
	private boolean isValidEntry(Movie m)
	{
		return m.getTitle().length() >= 3;
	}
	
	
	//method to save entry to file 
	public void saveToFile()
	{
	fileWrite filewriter = new fileWrite(filename);
	int i = 0;
	while(i < movies.size())
	{
	Movie m = movies.get(i);
	String e = m.getTitle() + "," + m.getActor1() + "," + m.getActor2() + "," + m.getDirector() + "," + m.getYear() + "," + m.getRuntime();
	filewriter.writeLine(e);
	i++;
	}
	filewriter.saveFile();
	
	}
	
	
	public void searchByTitle(String title)
	{
		// TODO
		int c = 0;
		int i = 0;
		while(i < movies.size()) 
		{
		Movie m = movies.get(i);
		if(m.getTitle().equalsIgnoreCase(title))
		{
			System.out.println("\nActors: " + m.getActor1() + ", " + m.getActor2());
			System.out.println("\nDirector: " + m.getDirector());
			System.out.println("\nYear: " + m.getYear());
			System.out.println("\nRuntime: " + m.getRuntime());
			c++;
			break;
			
		}
		i++;
		
		}
		if(c == 0)
		{
		System.out.println("\nNo title found with this entry!");	
		}
		
		
		
	}
	
	public List<Movie> searchByActor(String actor)
	{
		// TODO
		
		List<Movie> allMovies = new ArrayList<>();
		
		int i = 0;
		while(i < movies.size()) 
		{
			
		Movie m = movies.get(i);
		if(m.isActorInMovie(actor))
		{
			allMovies.add(m);
			
		}
		
		i++;
		
		}
		if(allMovies.isEmpty())
		{
		System.out.println("\nNo title found with this actor!");	
		}
		
		
		return allMovies;
	
		
		
	
		
	}
	
	public List<Movie> searchByDirector(String director)
	{
		// TODO
		List<Movie> allMovies = new ArrayList<>();
		int i = 0;
		while(i < movies.size()) 
		{
		Movie m = movies.get(i);
		if(m.getDirector().equalsIgnoreCase(director))
		{
			allMovies.add(m);
		}
		i++;
		
		}
		if(allMovies.isEmpty())
		{
		System.out.println("\nNo title found with this director!");	
		}
		
		
		return allMovies;
		
	
		
	}
	
	public List<Movie> searchByYear(int year)
	{
		// TODO
		List<Movie> allMovies = new ArrayList<>();
		int i = 0;
		while(i < movies.size()) 
		{
		Movie m = movies.get(i);
		if(m.getYear() == year)
		{
			allMovies.add(m);
			
		}
		i++;
		
		}
		if(allMovies.isEmpty())
		{
		System.out.println("\nNo title found with this year!");	
		}
		return allMovies;
		
		
	}
	
	public List<Movie> searchByRuntime(int runtime) 
	{
		// TODO
		List<Movie> allMovies = new ArrayList<>();
		int i = 0;
		while(i < movies.size()) 
		{
		Movie m = movies.get(i);
		if(m.getRuntime() == runtime)
		{
			allMovies.add(m);
			
		}
		i++;
		
		}
		if(allMovies.isEmpty())
		{
		System.out.println("\nNo title found with this runtime!");	
		}
		
		return allMovies;
	
	
	}
	
	public void deleteEntry(String t)
	{
	 int i = 0;
	 while(i < movies.size())
	 {
		 Movie m = movies.get(i);
			if(m.getTitle().equalsIgnoreCase(t))
			{
				movies.remove(i);
				saveToFile();
				System.out.println("Movie Entry deleted successfully!");
				return;
				
			}
			i++;
			
			
	 }
	  System.out.println("Title not found in file!");
	}
	
	
	

	
	
	
	
	
}
