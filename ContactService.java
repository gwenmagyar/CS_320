/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/17/2024
 * Description: The ContactService class manages a collection of contacts and provides 
 * functionality to maintain and update the contact list. 
 */

package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contactMap = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Duplicate contact ID");
        }
        contactMap.put(contact.getContactID(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contactMap.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contactMap.remove(contactID);
    }

    // Update fields
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContactById(contactID);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContactById(contactID);
        contact.setLastName(lastName);
    }

    public void updateNumber(String contactID, String number) {
        Contact contact = getContactById(contactID);
        contact.setNumber(number);
    }

    public void updateAddress(String contactID, String address) {
        Contact contact = getContactById(contactID);
        contact.setAddress(address);
    }

    // Retrieve a contact
    public Contact getContactById(String contactID) {
        if (!contactMap.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contactMap.get(contactID);
    }
}
