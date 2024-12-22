/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	12/1/2024
 * This is the test class for AppointmentService.
 */

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        // Initialize the service
        AppointmentService service = new AppointmentService();
        // Create a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Add a valid appointment
        service.addAppointment("12345", futureDate, "Test description");

        // Retrieve and verify the appointment
        Appointment appointment = service.getAppointment("12345");
        assertNotNull(appointment);
        assertEquals("12345", appointment.getAppointmentId());
    }

    @Test
    public void testAddDuplicateAppointment() {
        // Initialize the service
        AppointmentService service = new AppointmentService();
        // Create a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Add a valid appointment
        service.addAppointment("12345", futureDate, "Test description");

        // Attempt to add a duplicate appointment
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment("12345", futureDate, "Another description");
        });
    }

    @Test
    public void testDeleteAppointment() {
        // Initialize the service
        AppointmentService service = new AppointmentService();
        // Create a valid future date
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Add and delete an appointment
        service.addAppointment("12345", futureDate, "Test description");
        service.deleteAppointment("12345");

        // Verify the appointment is deleted
        assertNull(service.getAppointment("12345"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        // Initialize the service
        AppointmentService service = new AppointmentService();

        // Attempt to delete a non-existent appointment
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("12345");
        });
    }
}
