/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/17/2024
 * Description: Junit tests for Contact Class
 *************************/

package Test;

import Contact.Contact;
import Contact.ContactService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    @DisplayName("Add contact successfully")
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertEquals(contact, service.getContactById("12345"));
    }

    @Test
    @DisplayName("Adding duplicate contact ID throws exception")
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> 
            service.addContact(new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St")));
    }

    @Test
    @DisplayName("Delete contact successfully")
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.getContactById("12345"));
    }

    @Test
    @DisplayName("Deleting non-existing contact throws exception")
    void testDeleteNonExistingContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    @DisplayName("Update contact fields successfully")
    void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.updateFirstName("12345", "Jane");
        service.updateLastName("12345", "Smith");
        service.updateNumber("12345", "0987654321");
        service.updateAddress("12345", "456 Elm St");

        Contact updatedContact = service.getContactById("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getNumber());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    @DisplayName("Updating non-existing contact throws exception")
    void testUpdateNonExistingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> 
            service.updateFirstName("99999", "Jane"));
    }
}
