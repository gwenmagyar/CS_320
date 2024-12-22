/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	12/1/2024
 * The Appointment Service class used to maintain appointments
 * and allows for adding, updating, and deleting appointments.
 */

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // Map to store appointments, with the appointment ID as the key
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method to add a new appointment
    public void addAppointment(String appointmentId, java.util.Date futureDate, String description) {
        // Check if the ID is already in use
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID must be unique");
        }
        // Create a new appointment and add it to the map
        Appointment newAppointment = new Appointment(appointmentId, futureDate, description);
        appointments.put(appointmentId, newAppointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        // Check if the ID exists in the map
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        // Remove the appointment from the map
        appointments.remove(appointmentId);
    }

    // Optional: Getter for retrieving an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
