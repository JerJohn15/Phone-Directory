package phone;

import phone.SLList.Node;

public interface ListInterface {

	/**
	 * @author Jeremiah
	 * @details - This class contains the interface for
	 * the SLList class
	 * 
	 */


	/**
	 * Adds elements to the back of the list 
	 */
	public void addtoBack(String aName,String aNumber, String aEmail);

	/**
	 * 
	 *Adds elements to the front of the list 
	 */
	public void addtoFront(String aName,String aNumber, String aEmail);


	/**
	 * Returns the current element's reference in memory
	 */
	public Node getCurrent();

	/**
	 * Sets the current element's reference in memory 
	 * 
	 */

	public void setCurrent(Node current);

	/**
	 * Searches for a name and email address
	 */

	public String search(String data);

	/**
	 * Resets the iterator 
	 * 
	 */
	public void resetIterator();


	/**
	 * Checks if a list is empty 
	 *
	 */
	public boolean isEmpty();

	/**
	 * 
	 * Sorts the user's elements 
	 * 
	 */

	public void sort(String aName,String aNumber,String aEmail);

	/**
	 * Returns the current length of the list.
	 */

	public int getLength();

	/**
	 * Checks if the list has reached its end.
	 */

	public boolean hasNext();

	/**
	 * Transverses the list 
	 * 
	 */

	public void iterator(int number);

	/**
	 * 
	 * @param number
	 * Removes an element from the list. 
	 */
	public void remove(int number);

	/**
	 * Removes the first element from the list
	 */
	public void removeFirst();

	/**
	 * Prints out the list
	 */

	public void printList();
	
	/**
	 * Prints a searched list
	 * @param data
	 */
	
	public void printSearched(String data);
}
