package phone;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Jeremiah
 *@details - This class handles the txt files Menu.txt and 
 * PhoneDirectory.txt
 */
public class TextFile extends SLList{

	private String listFile = "PhoneDirectory.txt";	
	private String menuFile = "Menu.txt";
	private Scanner file;
	private Scanner menuData;
	
	
	public TextFile(){
		
		file = null;
		menuData = null;
		
	}

/**
 * @throws FileNotFoundException 
 * @method - openList
 * @pre - Searches for a txt file
 * @post - ends program if not found.
 * 
 * 
 */
	public void openList() throws FileNotFoundException{
	
	    System.out.println("Opening File...");
						   
	   try
	   {
		   file = new Scanner(new File(listFile));

	   }
	   catch(FileNotFoundException e)
	   {
	       System.out.println("Error opening the file " + 
	    		   listFile);
	       System.exit(0);
	     
	 
	   }
	 
	   System.out.println("File " + listFile + " has been opened.");
	}
	
	/**
	 * @method - writeList 
	 * @throws FileNotFoundException
	 * @post - Prints contents of list onto PhoneDirectory.txt
	 */
	public void writeList() throws FileNotFoundException{
		PrintWriter output = new PrintWriter(listFile);
		int index = 0;
		resetIterator();
		
		output.println("ID:  NAME  PHONE NUMBER   EMAIL");
		output.println();
		
		while (getCurrent() != null)
		{
			output.println(index + ": " + getCurrent().getName() + " " +
					getCurrent().getNumber() + " " + getCurrent().getEmail() + " ");
			output.println();
			
			index++;  
			 setCurrent(getCurrent().getLink());
		}
		output.println();
		output.close();
		System.out.println("Data successfully written to file.");

	}
	/**
	 * @method - readMenu
	 * @post - Opens menu.txt file
	 * and prints its contents on the console
	 * Note: User's are recommended to open .txt file 
	 * or output to see menu options.
	 * 
	 */
	
	public void readMenu(){
	
	
	    System.out.println("Reading file...");
						   
	   try
	   {
		   menuData = new Scanner(new File(menuFile));

	   }
	   catch(FileNotFoundException e)
	   {
	       System.out.println("Error opening the file " + 
	                           menuFile);
	       System.exit(0);
	   }
	   
	   
		while(menuData.hasNextLine()){
			
		String line = menuData.nextLine();
		System.out.println(line);
			
		}
		
		   
	 
	}
	
	/**
	 * @method - readList 
	 * @details - reads each option from the menu
	 *  
	 */
	public void readList(){
		
		
			while(menuData.hasNextLine()){
				
			String line = menuData.nextLine();
			System.out.println(line);
				
			}
		
		
	   }
	
	
}
