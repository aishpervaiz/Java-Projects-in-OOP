package Main;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;
	
	// Constructor
	public Movie(String title, String actor1, String actor2, String director, int year, int runtimeMinutes){
		// TODO
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
	}
	
	// Methods
	public String getTitle()
	{
		// TODO
		return title;
	}
	
	public String getActor1()
	{
		// TODO
		return actor1; 
	}
	
	public String getActor2()
	{
		// TODO
		return actor2;
	}
	
	public String getDirector()
	{
		// TODO
		return director;
	}
	
	public int getYear()
	{
		// TODO
		return year;
	}
	
	public int getRuntime()
	{
		// TODO
		return runtimeMinutes;
	}
	
	// Optional
	public boolean isActorInMovie(String actor)
	{
		// TODO
		return actor.equalsIgnoreCase(actor1) || actor.equalsIgnoreCase(actor2);
	}
}
