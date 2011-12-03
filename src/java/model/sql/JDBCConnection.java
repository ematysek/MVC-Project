package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import model.contact.Contact;
import model.contact.ContactList;


/**
 *
 * @author Eric
 */
public class JDBCConnection {

    private static JDBCConnection instance = null;
    Connection connection = null;
    final String driver = "com.mysql.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://www.freesql.org/addressbook";
    final String username = "javacoder";
    final String password = "java9312";

    /**
     * constructs the database connection according to final parameters
     * 
     */
    private JDBCConnection() {

        try {
            // load the JDBC mysql bridge driver
            //Class.forName(driver).newInstance();
            // use the DriverManager to create a Connection object
            //connection = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);

            // load the JDBC-ODBC bridge driver
            Class.forName(driver);
            // use the DriverManager to create a Connection object
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Successfully connected to database");
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e);
        }



    }

    public ArrayList<Contact> getAllContacts() {

        Statement statement = null;
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM contactinfo");
            while (rs.next()) {
                Contact temp = new Contact(Integer.toString((rs.getInt("id"))), rs.getString("firstname"), rs.getString("lastname"), rs.getString("address"), rs.getString("city"),
                        rs.getString("state"), rs.getString("zip"), rs.getString("homephone"), rs.getString("cellphone"), rs.getString("email"));
                if (contacts.add(temp)) {
                    //System.out.println("successfully loaded " + temp.getFirstName() + " into contact array");
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }

        return contacts;

    }

    public ArrayList<Contact> getAllContactsSorted() {
        ArrayList<Contact> contacts = this.getAllContacts();

        Collections.sort(contacts);

        return contacts;
    }
    
    	public ContactList getSortedContactList() {
		return new ContactList(this.getAllContactsSorted());
	}
	
	/**
	 * Returns a ContactList of Contacts populated from the contact table.
	 * 
	 * @return a ContactList of Contact objects.
	 */
	public ContactList getContactList() {
		return new ContactList(this.getAllContacts());
	}

    public void addContact(Contact contact) {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("INSERT INTO contactinfo (firstname, lastname, address, city, state, zip, homephone, cellphone, email) "
                    + "VALUES ('" + contact.getFirstName() + "', '" + contact.getLastName() + "', '" + contact.getAddress() + "', '" + contact.getCity() + "', '" + contact.getState()
                    + "', '" + contact.getZip() + "', '" + contact.getHomePhone() + "', '" + contact.getCellPhone() + "', '" + contact.getEmail() + "')");
            System.out.println("added " + contact.getFirstName() + " " + contact.getLastName());
        } catch (SQLException e) {
            //e.printStackTrace();
        }

    }
    
    	/**
	 * removes entry designated by id from contact table
	 * 
	 * @param id id
	 */
	public void removeContact(int id) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DELETE FROM contactinfo WHERE id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * updates contact table entry for Contact
	 * 
	 * @param contact object
	 */
	public void updateContact(Contact contact) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("UPDATE contactinfo SET firstname='" + contact.getFirstName() + "', lastname='" + contact.getLastName() + "', address='" + contact.getAddress() + 
					"', city='" + contact.getCity() + "', state='" + contact.getState() + "', zip='" + contact.getZip() + "', homephone='" + contact.getHomePhone() + 
					"', cellphone='" + contact.getCellPhone() + "', email='" + contact.getEmail() + "' WHERE ID=" + contact.getID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gets the Contact from the database with the supplied ID.
	 * @param id ID of the contact to return
	 * @return the contact with the supplied ID
	 */
	public Contact getContact(int id) {
		Statement statement = null;
		Contact contact = null;
		try{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM contactinfo WHERE id=" + id);
			contact = new Contact(Integer.toString((rs.getInt("id"))), rs.getString("firstname"), rs.getString("lastname"), rs.getString("address"), rs.getString("city"),
											rs.getString("state"), rs.getString("zip"), rs.getString("homephone"), rs.getString("cellphone"), rs.getString("email"));
				
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return contact;
	
	}

    public static JDBCConnection getInstance() {
        if (instance == null) {
            synchronized(JDBCConnection.class){
                if(instance == null){
                    instance = new JDBCConnection();
                }
            }
        }

        return instance;
    }
}
