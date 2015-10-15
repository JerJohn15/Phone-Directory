package phone;

/**
 * @author Jeremiah
 * @details - This class handles all of the user input from the menu
 */

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Directory extends TextFile{

	private Scanner keyboard;
	private String name;
	private String number;
	private String email;

	
	public Directory(){

		keyboard = new Scanner(System.in);
		name = "";
		number = "";
		email = "";
		
	}



	
	/**
	 * @method - startProgram
	 * @throws - FileNotFoundException
	 * @details - Starts and ends the  program 
	 * 
	 */
	public void startProgram() throws FileNotFoundException {
	
		String selection = "";
		readMenu();
		while(!selection.equalsIgnoreCase("q")){
	
			String choice =	askUser();
			selection =	handleInput(choice);
	
		}
		
		System.out.println("Ending Program...");
		System.exit(0);
	}



	/**
	 * 
	 * @method - askUser
	 * @details - Asks user for input from menu 
	 * 
	 */
	public String askUser(){
		
		String selection = "";
		
		do{

			System.out.println("Please select an option: (Refer to Menu.txt or output above for menu.)");
			selection = keyboard.nextLine();
			selection = selection.toLowerCase();

		}while(!selection.matches("[a-zA-Z]*"));

		return selection;


	}

	/**
	 * @method -askName
	 * @precondition - asks for a name
	 * @postcondition - converts name to lowercase
	 */
	public void askName(){

		do{
			System.out.println("Please enter a name: ");
			name = keyboard.nextLine();
			
		}while(!name.matches("[a-zA-Z\\s]*"));
		name = name.toLowerCase();

	}

	/**
	 * @method - askNumber
	 * @pre- asks for a number
	 * Takes both phone numbers and indexes (for 
	 * remove option).
	 * 
	 */
	public void askNumber(){

		do{
			System.out.println("Please enter a number: ");
			number = keyboard.nextLine();
		}while(!number.matches("[0-9-]*"));



	}

	/**@method - askEmail
	 * @pre - asks for an email address
	 * @post- converts input to lowercase
	 */
	public void askEmail(){


		do{
			System.out.println("Please enter an email: ");
			email = keyboard.nextLine();
		}while(!email.matches("[0-9a-zA-Z@.]*"));
		email =	email.toLowerCase();
	}

	/**
	 * 
	 * @method - handleInput
	 * @param - selection (String)
	 * @throws FileNotFoundException 
	 * @precondition - For each case, checks for an empty list.
	 * @postcondition - Asks for data to populate list if empty,
	 * and handles a user's selection from the menu.
	 * 	NOTE: Refer to handleInput section in design document
	 *
	 */
	public String handleInput(String selection) throws FileNotFoundException {


		switch(selection){
		case "a":
			handleAdd();
			break;
		case "p":
			checkEmptyList();
			printList();
			break;
		case "s":
			checkEmptyList();
			askName();
			handleSearch(name);
			break;
		case "e":
			checkEmptyList();
			askEmail();
			handleSearch(email);
			break;
		case "d":
			checkEmptyList();
			printList();
			askNumber();
			int index = Integer.parseInt(number);
			checkIndex(index);
			remove(index);
			System.out.println("Entry removed.");
			System.out.println();
			break;
		case "w":
			checkEmptyList();
			openList();
			writeList();
			break;
		case "r":
			checkEmptyList();
			openList();
			readList();
			break;
		case "q":
			break;
		default:
			System.out.println("Invalid letter detected!");
			break;

		}
		return selection;
	}


	/**
	 * @method - handleAdd
	 * @pre - Asks the user for data to be
	 * entered in the list.
	 * @post - Adds the data to the back of list
	 * , if empty list, else pass current data to-be-
	 * sorted in method sort.
	 */
	public void handleAdd(){
		askName();
		askNumber();
		askEmail();
		if(isEmpty()==true){

			addtoBack(name,number,email);
			System.out.println("List is now populated.");
		}else{
			sort(name,number,email);
		}


	}
	
	
	/**
	 * @method - handleSearch
	 * @param target
	 * @pre - prints a searched list if found
	 * @post - prints a search not found message 
	 */
	public void handleSearch(String target){
		if(search(target) == null){
			System.out.println("Requested data is not in list.");
			System.out.println();
		}else{
			printSearched(target);
			  }
			
		}
	
	/**
	 * @method - checkIndex
	 * @param - aNumber 
	 * @details - re-asks user to enter an index if
	 * end of list is reached.
	 */
	public void checkIndex(int aNumber){
		while(aNumber>getLength()-1){
			System.out.print("Index out of range! ");
			askNumber();
			aNumber = Integer.parseInt(number);
		}

	}

/**
 * @method - checkEmptyList
 * @pre - Checks for an empty list 
 * @post - prompts user to create a list.
 */
	public void checkEmptyList(){
		//if list is empty populate list
		while(isEmpty() == true){

			System.out.println("List is empty. " +
					"Please add an entry.");

			handleAdd();
		}

	}
}
