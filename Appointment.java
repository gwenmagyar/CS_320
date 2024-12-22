/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	12/1/2024
 * The Appointment class used to create and store appointment information.
 */

import java.util.Date;

public class Appointment {
    // Fields for appointment details
    private final String appointmentId; // Unique ID for the appointment, cannot be null or updated
    private final Date appointmentDate; // Date of the appointment, cannot be null or in the past
    private final String description;   // Description of the appointment, cannot be null or exceed 50 characters

    // Constructor to initialize fields with validation
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate the appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // Validate the appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // Validate the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        // Initialize fields
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter for appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Getter for appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}
