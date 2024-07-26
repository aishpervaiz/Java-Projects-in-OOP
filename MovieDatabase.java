package Main;

import java.util.List;

public class MovieDatabase 
{
	public static void main(String[] args)
   {
	  System.out.println("\nThis is the beginning of Aishah's Movie Database Management System!");
	  displayCommands();
	  Database mD = new Database("src/main/db.txt");
	  keyboardInput k = new keyboardInput();
	  
	  String c = "";
  
	  while(!c.equals("quit"))
	{
		  System.out.println("\nEnter Command or Type 'quit' to exit the program >");
		  c = k.getKeyboardLine().trim().toLowerCase();
		  
		  switch(c)
		  {
		  
		  case "new entry":
			  addNewEntry(mD, k);
			  break;
			  
		  case "search by year":
			  System.out.println("\nEnter year >");
			  int searchYear = k.getIntKeyBoard();
			  displayMovies(mD.searchByYear(searchYear));
			  break;
			  
		  case "search by title":
			  System.out.println("\nEnter title >");
			  String title = k.getKeyboardLine();
			  mD.searchByTitle(title);
			  break;
			  
		  case "search by director":
			  System.out.println("\nEnter director >");
			  String director = k.getKeyboardLine();
			  displayMovies(mD.searchByDirector(director));
			  break;
			  
		  case "search by actor":
			  System.out.println("\nEnter actor >");
			  String actor = k.getKeyboardLine();
			  displayMovies(mD.searchByActor(actor));
			 break;
			  
		  case "search by runtime":
			  System.out.println("\nEnter runtime (minutes) >");
			  int searchRuntime = k.getIntKeyBoard();
			  displayMovies(mD.searchByRuntime(searchRuntime));
			  break;
			  
		  case "delete entry":
			  System.out.println("\nEnter title to delete >");
			  String deleteTitle = k.getKeyboardLine().trim();
			  mD.deleteEntry(deleteTitle); 
			 break;
			  
		  case "quit":
			  System.out.println("\nYou are exiting the movie database management system.");
			 break;
			  
		  default: 
			  System.out.println("\nInvalid command. Try again with a new entry!");
			  break;  
		  
		  
		  }
		  
		 
		  
		   
	  }
	  k.close();
	 
	  
   }
   


   private static void displayCommands() 
   {
		// TODO Auto-generated method stub
	   System.out.println("\nCommands:");
	   System.out.println("\nnew entry > (add a new movie entry)");
	   System.out.println("search by title > (search by movie title)");
	   System.out.println("search by actor >  (search by movie actor)");
	   System.out.println("search by director > (search by movie director");
	   System.out.println("search by year > (serach by movie year)");
	   System.out.println("search by runtime > (search by movie runtime in minutes)");
	   System.out.println("delete entry > (delete movie entry)");
	   System.out.println("quit > (exit the program)");
	}

   private static void addNewEntry(Database mD, keyboardInput k)
   {
	 System.out.println("\nPlease enter movie entry details!"); 
		   
	   String title = "";
	   while (title.isEmpty())
	   {
		   System.out.println("\nEnter title >");
		   title = k.getKeyboardLine().trim();
		   if(title.isEmpty())
		   {
			   System.out.println("Title cannot be empty");
		   }
	   }
	   
	   
	   String actor1 = "";
	   while (actor1.isEmpty())
	   {
		   System.out.println("\nEnter Actor 1 >");
		   actor1 = k.getKeyboardLine().trim();
		   if(actor1.isEmpty())
		   {
			   System.out.println("Actor 1 cannot be empty. Enter again.");
		   }
	   }
	   
	   String actor2 = "";
	   while (actor2.isEmpty())
	   {
		   System.out.println("\nEnter Actor 2 >");
		   actor2 = k.getKeyboardLine().trim();
		   if(actor2.isEmpty())
		   {
			   System.out.println("Actor 2 cannot be empty. Enter again.");
		   }
	   }
	    
	   
	   String director = "";
	   while (director.isEmpty())
	   {
		   System.out.println("\nEnter Director >");
		   director = k.getKeyboardLine().trim();
		   if(director.isEmpty())
		   {
			   System.out.println("Director cannot be empty. Enter again.");
		   }
	   }

	   int year = 0;
	   while (year <= 0)
	   {
		   System.out.println("\nEnter year >");
		   year = k.getIntKeyBoard();
		   if(year <= 0)
		   {
			   System.out.println("Invalid year. Enter again with a valid year.");
		   }
	   }

	   int runtime = 0;
	   while (runtime <= 0)
	   {
		   System.out.println("\nEnter runtime (minutes) >");
		   runtime = k.getIntKeyBoard();
		   if(runtime <= 0)
		   {
			   System.out.println("Invalid runtime. Enter again with a valid runtime in minutes.");
		   }
	   }

	     Movie m = new Movie(title,actor1,actor2,director,year,runtime);
		 mD.addEntry(m);
		 System.out.println("\nNew Movie Entry added successfully!!");
		   
	    
	    
	 
   }
   private static void displayMovies(List<Movie> movies)
   {
	   if(movies.isEmpty())
	   {
		   System.out.println("\nNo matching movies found!");
	   }
	   else 
	   {
		   System.out.println("\nMatching Movies:");
		   for(Movie movie : movies)
		   {
			 System.out.println("Title: " + movie.getTitle());  
		   }
			   
	   }
   }
   
   
}

