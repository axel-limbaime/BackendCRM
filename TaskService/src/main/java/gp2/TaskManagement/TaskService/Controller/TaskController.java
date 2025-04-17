package gp2.TaskManagement.TaskService.Controller;

//import gp2.StudentLifeCycle.StudentLifecylce.models.Candidate;
import gp2.TaskManagement.TaskService.Entity.Task;
import gp2.TaskManagement.TaskService.ServiceImpl.TaskServiceImplement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task Management", description = "Endpoints for managing tasks")
@RestController
@RequestMapping("/Task")
public class TaskController {

    private final TaskServiceImplement taskService;

    public TaskController(TaskServiceImplement taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Create a new task", description = "Creates a new task and saves it to the database.")
    @ApiResponse(responseCode = "200", description = "Task created successfully")
    @PostMapping("/newTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @Operation(summary = "Get all tasks", description = "Retrieves a list of all tasks.")
    @ApiResponse(responseCode = "200", description = "List of tasks")
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @Operation(summary = "Get tasks by candidate ID", description = "Retrieves tasks assigned to a specific candidate.")
    @ApiResponse(responseCode = "200", description = "List of tasks for the candidate")
    @GetMapping("/candidate/{candidateId}")
    public List<Task> getTasksByCandidate(@PathVariable Long candidateId) {
        return taskService.getTasksByCandidate(candidateId);
    }

    @Operation(summary = "Update a task", description = "Updates an existing task by its ID.")
    @ApiResponse(responseCode = "200", description = "Task updated successfully")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @Operation(summary = "Mark a task as completed", description = "Marks a task as completed by its ID.")
    @ApiResponse(responseCode = "200", description = "Task marked as completed successfully")
    @PutMapping("/complete/{id}")
    public Task markTaskAsCompleted(@PathVariable Long id) {
        return taskService.markTaskAsCompleted(id);
    }

    @Operation(summary = "Delete a task", description = "Deletes a task by its ID.")
    @ApiResponse(responseCode = "204", description = "Task deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskType(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}