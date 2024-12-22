/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	12/1/2024
 * This is the test class for Appointment.
 */

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        // Create a valid appointment with a future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in future
        Appointment appointment = new Appointment("12345", futureDate, "Test description");

        // Assert that all fields are correctly set
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Test description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        // Create a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Test null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Test description");
        });

        // Test ID exceeding 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Test description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        // Create a past date
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in past

        // Test appointment with past date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Test description");
        });
    }

    @Test
    public void testInvalidDescription() {
        // Create a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Test null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });

        // Test description exceeding 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is way too long and exceeds fifty characters.");
        });
    }
}
