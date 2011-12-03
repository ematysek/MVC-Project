package model.contact;

import java.util.ArrayList;


/**
 * Contact list containing a list of Contact objects.
 * 
 * @author Eric Matysek
 * 
 */
public class ContactList {

	private ArrayList<Contact> contactList;

	/**
	 * Constructs a new ContactList from and ArrayList of Contact objects.
	 * 
	 * @param contactList
	 *            an ArrayList of Contact objects.
	 */
	public ContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}

	/**
	 * Adds the provided Contact object to the ContactList.
	 * 
	 * @param contact
	 *            the Contact object to add to the ContactList
	 */
	public void add(Contact contact) {
		contactList.add(contact);
	}

	/**
	 * Gets the Contact object from the specified index.
	 * 
	 * @param index
	 *            index of the Contact to get
	 * @return the Contact at specified index
	 */
	public Contact get(int index) {
		return contactList.get(index);
	}

	/**
	 * Removes the Contact object at the specified index.
	 * 
	 * @param index
	 *            index of the Contact to remove
	 */
	public void remove(int index) {
		contactList.remove(index);
	}

	/**
	 * Returns the size of the ContactList.
	 * 
	 * @return the size of the ContactList
	 */
	public int size() {
		return contactList.size();
	}

}
