// Your name here (NO NAME, NO CREDIT!): Aishah Pervaiz

package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Lab10{
	public static void main(String[] args)
	{
		// TEST PORTION (DO NOT MODIFY!)
		ArrayList<String> alist = new ArrayList<String>();	// Created array list
		Stack<Integer> st = new Stack<Integer>();			// Created stack
		final int n = 10;
		for(int i = 0; i < n; i++)
		{
			alist.add(Integer.toString(i));
			st.push(i);
		}
		// END TEST...CODE BELOW THIS LINE!
		// TODO (Remove this when you finish lab)
		
		//Displaying ArrayList elements 
		System.out.println("ArrayList Iterator:\n");
		Iterator<String> a = alist.iterator();
		while(a.hasNext())
		{
			p(a.next());
		}
		 pn("\n");
		 
		 
		 //Displaying Stack Elements 
		 System.out.println("Stack Iterators in LIFO Order:\n");
		 Iterator<Integer> s = getStackIterator(st);
		 while(s.hasNext())
		 {
		 p(s.next());
		 }
		 pn("");
		 
		
		
		
	}
	
	public static Iterator<Integer> getStackIterator(Stack<Integer> st)
	{
		// TODO: Follow specifications in hand out!
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		while(!st.isEmpty())
		{
			al.add(st.pop());
		}
		
		
		for(int i = al.size() - 1; i >= 0; i--)//to restore the original order of the stack elements
		{
			st.push(al.get(i));
			
		}
		
		return al.iterator(); //return in LIFO order 
		
		
		
		//return null; // This is just to prevent a Java error; remove when you complete this method!
	}	

	/* Helper method for easy printing on same line */
	public static <E> void p(E item)
	{
		System.out.print(item + " ");
	}
	
	/* Helper method for easy printing with line return */
	public static <E> void pn(E item)
	{
		System.out.println(item);
	}
}