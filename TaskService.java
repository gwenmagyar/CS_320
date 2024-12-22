/*************************
 * Name: 	Gwen Magyar 
 * Course: 	CS-320 
 * Date: 	11/24/2024
 * The TaskService class manages a collection of Task objects.
 * It provides methods to add, delete, and update tasks, ensuring data integrity.
 */

package Task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Add a task
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete a task
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    // Update task fields
    public void updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(name);
        task.setDescription(description);
    }

    // Retrieve a task (for testing or validation purposes)
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
