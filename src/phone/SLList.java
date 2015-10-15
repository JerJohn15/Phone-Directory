package phone;



import java.util.NoSuchElementException;

/**
 * 
 * @author Jeremiah
 *@details - This class handles and stores all of the data within
 *the single linked list.
 */



public class SLList  implements ListInterface {


	private Node previous;
	private Node current;
	private Node head;
	private int length;


	public SLList(){
		previous = null;
		current = null;
		head = null;
		length = 0;
	}


	/**
	 * @method - getCurrent
	 * @return - returns current element
	 */
	public Node getCurrent() {
		return current;
	}


	/**
	 * @method- setCurrent
	 * @details - sets current element.
	 */
	public void setCurrent(Node current) {
		this.current = current;
	}



	/**
	 * @method - getLength
	 * @details - gets the length of list.
	 * @return - length
	 * 
	 */
	public int getLength(){

		for(resetIterator();current!=null;current=current.link){		
			length++;
		}
		return length;
	}

	/**
	 * @method - addtoBack
	 * @param - aName, aNumber, aEmail (String)
	 * @details - Adds an entry to the back of linked list. 
	 */
	public void addtoBack(String aName,String aNumber, String aEmail){
		Node nextNode = new Node();
		nextNode.name = aName;
		nextNode.number = aNumber;
		nextNode.email = aEmail;

		if(current == null){
			//adds element to start of list 
			addtoFront(aName,aNumber, aEmail);
			current =  head;
		}else{
			//moves iterator past inserted element.

			nextNode.link = current.link;
			current.link = nextNode;
			current = nextNode;
		}
	}

	/**
	 * @method - addtoFront
	 * @param - aName, aNumber, aEmail (String)
	 * @post - puts data at the front of list. 
	 * 
	 */
	public void addtoFront(String aName,String aNumber, String aEmail)
	{

		head = new Node(aName,aNumber,aEmail,head);

	}




	/**
	 @method - resetIterator
	 @details - Moves the iterator
	 to the beginning of the list.
	 */

	public void resetIterator( )
	{
		current = head;
		previous = null;
	}


	/**
	 * @method - iterator
	 * @details - Transverses the list 
	 * @throws - NoSuchElementException
	 * 

	 */
	public void iterator(int number){
		resetIterator();
		for(int index = 0;index<number;index++){

			try{

				if (!hasNext()){
					//throw exception if iterator goes too far. 		
					throw new NoSuchElementException();

				}else{
					previous = current; 
					current = current.link;	
				}	

			}catch(NoSuchElementException e){
				System.out.println("You have reached end of list.");
				break;
			}

		}
	}



	/**
	 * @method - hasNext
	 * @details - returns true if an
	 *  element exists after the current one and false 
	 *  if the head is empty or has no element at the end of list.
	 * 
	 *
	 */
	public boolean hasNext(){
		//head contains a number
		if (current == null){
			return head != null;
		}
		else{//end of list is reached. 
			return current.link != null;
		}
	}



	/**
	 * @method - isEmpty
	 * @details - Checks if list is empty 
	 * @return - true/false 
	 */
	public boolean isEmpty(){

		if(head == null){
			return true;
		}else{
			return false;
		}

	}

	/**
	 * @method - sort
	 * @pre- iterates through the list comparing each name
	 *  to current one to be added.
	 * @post - sorts a list according to string values being 
	 * compared. (Adds new element to the front, back and middle of list
	 * depending on conditions)
	 */
	public void sort(String aName,String aNumber,String aEmail){

		Node next;
		boolean hasAdded = false;
		resetIterator();
		while(current != null && hasAdded == false){

			int strVal = current.name.compareTo(aName);

			//str1 < str2 add to front of list
			if (strVal > 0)  
			{  

				addtoFront(aName,aNumber,aEmail);
				hasAdded = true;
				//str2 is > str1 add to back of list
			} else if(strVal < 0) 
			{	
				//check if iterator has reached end of list	
				next = current.link;
				if(next == null)
				{
					//add name to end of list		
					hasAdded = true;
					addtoBack(aName,aNumber,aEmail);

				}else if(next.name.compareTo(aName) > 0)
				{
					//add name to middle of list 			
					hasAdded = true;
					addtoBack(aName,aNumber,aEmail);
				}

			}else{
				//if str1 = str 2, add to back of str1
				hasAdded = true;
				addtoBack(aName,aNumber,aEmail);

			}
			previous = current; 
			current = current.link;

		}



	}

	/**
	 * @method - remove
	 * @details - Removes an element from a linked list
	 * Prints error message if iterator is not been called
	 * before remove method. 
	 */
	public void remove(int data) {
		//takes index and steps through iterator
		iterator(data);
		if(previous == current)

			throw new IllegalStateException("list has not been moved.");

		if(current == head){
			removeFirst();

		}else{
			previous.link = current.link;
		}
		current = previous;



	}

	/**
	 * @method - removeFirst
	 * @details - removes the first element from the list 
	 * 
	 */
	public void removeFirst() {

		if(head == null){
			throw new NoSuchElementException("This element is empty.");
		}	
		head = head.link;

	}

	/**
	 * @method - listSearch
	 * @param target
	 * @detail - Searches for a name or email
	 * @return - The name, email or null, if not found.
	 */
	public  String search(String target)
	{
		Node cursor;

		for (cursor = head; cursor != null; cursor = cursor.link){
			if (target.equals(cursor.name))
			{
				return cursor.name;
			}else if(target.equals(cursor.email))
			{
				return cursor.email;
			}

		}
		return null;
	}

	/**
	 * @method - printSearched
	 * @param - data
	 * @details - prints out the searched list.
	 * 
	 */
	public void printSearched(String data) {
		resetIterator();
		int index = 0;
		System.out.println(data + " has been found.");
		System.out.println("ID:  NAME  PHONE NUMBER   EMAIL");
		while (current != null) {
			if (current.name.equals(search(data)) || current.email.equals(search(data)))
			{

				System.out.println(index + ": " + current.name + " " +
						current.number + " " + current.email + " ");

			}

			current = current.link;
			index++;

		}
		System.out.println();


	}


	/**
	 * @method - printList
	 * @details - Prints a list and each element's index. 
	 * 
	 */
	public void printList( )
	{
		int index = 0;
		resetIterator();
		System.out.println("ID:  NAME  PHONE NUMBER   EMAIL");
		System.out.println();
		while (current != null)
		{
			System.out.print(index + ": " + current.name + " " +
					current.number + " " + current.email + " ");
			System.out.println();

			index++;  
			current = current.link;

		}
		System.out.println();


	}


	/*
	 * @author - Jeremiah 
	 * This class creates the nodes for a int Linked List.
	 * 
	 */
	public class Node
	{
		private  String name;
		private String number;
		private String email;
		private  Node link;

		public Node(){
			name = "";
			number = "";
			email = "";
			link = null;
		}

		public Node(String aName,String aNumber, String aEmail, Node aLink)
		{
			name = aName;
			number = aNumber;
			email = aEmail;
			link = aLink;
		}

		public String getName() {
			return name;
		}

		public void setName(String aName) {
			name = aName;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}


	}




}
