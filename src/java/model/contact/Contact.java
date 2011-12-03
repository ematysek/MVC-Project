package model.contact;

/**
 * A contact object containing information about the contact
 * 
 * @author Eric Matysek
 * 
 */
public class Contact implements Comparable<Contact> {

    private String ID;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String homePhone;
    private String cellPhone;
    private String email;

    /**
     * Constructs a new Contact from the provided fields. ID in most cases will
     * not be necessary as this value is set by the database.
     * 
     * @param ID
     *            id of the contact
     * @param firstName
     *            first name
     * @param lastName
     *            last name
     * @param address
     *            address
     * @param city
     *            city
     * @param state
     *            state
     * @param zip
     *            zip
     * @param homePhone
     *            home phone
     * @param cellPhone
     *            cell phone
     * @param email
     *            email
     */
    public Contact(String ID, String firstName, String lastName,
            String address, String city, String state, String zip,
            String homePhone, String cellPhone, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.email = email;
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.homePhone = "";
        this.cellPhone = "";
        this.email = "";
    }

    @Override
    public int compareTo(Contact c) {
        return this.lastName.compareToIgnoreCase(c.lastName);
    }

    /**
     * Compares two Contact objects based on their information including ID.
     * 
     * @param contact
     *            contact to compare to
     * @return false if any field is different, true otherwise.
     */
    public boolean equals(Contact contact) {
        if (!ID.equals(contact.getID())) {
            return false;
        }
        if (!firstName.equals(contact.getFirstName())) {
            return false;
        }
        if (!lastName.equals(contact.getLastName())) {
            return false;
        }
        if (!address.equals(contact.getAddress())) {
            return false;
        }
        if (!city.equals(contact.getCity())) {
            return false;
        }
        if (!state.equals(contact.getState())) {
            return false;
        }
        if (!zip.equals(contact.getZip())) {
            return false;
        }
        if (!homePhone.equals(contact.getHomePhone())) {
            return false;
        }
        if (!cellPhone.equals(contact.getCellPhone())) {
            return false;
        }
        if (!email.equals(contact.getEmail())) {
            return false;
        }

        return true;
    }

    /**
     * Returns the address of the contact.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the cell phone number of the contact.
     * 
     * @return the cellPhone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * Returns the city of the contact.
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the email of the contact.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the first name of the contact.
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the home phone number of the contact.
     * 
     * @return the homePhone
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Returns the ID of the contact.
     * 
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the last name of the contact.
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns a string formatted for the JTree in lastname, firstname format.
     * If no last name is supplied for the contact then only the first name is
     * returned.
     * 
     * @return a string in lastname, firstname format
     */
    public String getNodeString() {
        String nodeString;
        if (this.lastName.equals("")) {
            nodeString = this.firstName;
        } else {
            nodeString = (this.lastName + ", " + this.firstName);
        }
        return nodeString;
    }

    /**
     * Returns the state of the contact.
     * 
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the zip of the contact.
     * 
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the address of the contact.
     * 
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the cell phone number of the contact.
     * 
     * @param cellPhone
     *            the cellPhone to set
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * Sets the city of the contact.
     * 
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the email of the contact.
     * 
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the first name of the contact.
     * 
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the home phone number of the contact.
     * 
     * @param homePhone
     *            the homePhone to set
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Sets the ID of the contact.
     * 
     * @param iD
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * Sets the last name of the contact.
     * 
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the state of the contact.
     * 
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the zip of the contact.
     * 
     * @param zip
     *            the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return (this.firstName + " " + this.lastName);
    }
}
