 /*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/17/2024
 * Description: Junit tests for Contact Service Class
 *************************/

package Test;

import Contact.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    @DisplayName("Contact creation with valid inputs")
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    @DisplayName("Contact creation fails with invalid ID")
    void testInvalidContactID() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    @DisplayName("First name must be valid")
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "JohnDoeTooLong", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    @DisplayName("Last name must be valid")
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "DoeTooLongName", "1234567890", "123 Main St"));
    }

    @Test
    @DisplayName("Phone number must be valid")
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    @DisplayName("Address must be valid")
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "1234567890", "Address that is way too long to be valid"));
    }
}
