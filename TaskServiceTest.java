/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/24/2024
 * Description: Junit tests for Task Service Class
 */

package Test;

import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("12345"));
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        taskService.addTask(task);
        taskService.deleteTask("12345");
        assertNull(taskService.getTask("12345"));
    }

    @Test
    public void testUpdateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        taskService.addTask(task);
        taskService.updateTask("12345", "Updated Name", "Updated Description");
        Task updatedTask = taskService.getTask("12345");
        assertEquals("Updated Name", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
    }
}
