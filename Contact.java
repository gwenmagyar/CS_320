/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/17/2024
 * Description: The Contact class represents an individual contact, storing their 
 * information.
 *
 * This class ensures that all fields meet the required constraints and provides 
 * methods to retrieve and update specific fields (except for the contact ID).
 */

package Contact;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String number, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        this.contactID = contactID;

        setFirstName(firstName);
        setLastName(lastName);
        setNumber(number);
        setAddress(address);
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        if (number == null || number.length() != 10 || !number.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.number = number;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
