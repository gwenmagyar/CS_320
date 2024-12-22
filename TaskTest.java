/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/24/2024
 * Description: Junit tests for Task Class
 */

package Test;

import org.junit.jupiter.api.Test;

import Task.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testValidTaskCreation() {
        Task task = new Task("12345", "Test Task", "This is a test description.");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Test", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Test", "Description"));
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This name is definitely too long", "Description"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Test", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Test", "This description is definitely too long to be valid because it exceeds the fifty character limit."));
    }
}
