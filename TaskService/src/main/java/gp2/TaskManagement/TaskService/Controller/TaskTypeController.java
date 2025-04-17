package gp2.TaskManagement.TaskService.Controller;

import gp2.TaskManagement.TaskService.Entity.TaskType;
import gp2.TaskManagement.TaskService.ServiceImpl.TaskTypeServiceImplement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task Type Management", description = "Endpoints for managing task types")
@RestController
@RequestMapping("/Task/task-types")
public class TaskTypeController {

    @Autowired
    private TaskTypeServiceImplement taskTypeService;

    @Operation(summary = "Create a new task type", description = "Creates a new task type and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Task type created successfully")
    @PostMapping
    public ResponseEntity<TaskType> createTaskType(@RequestBody TaskType taskType) {
        TaskType createdType = taskTypeService.createTaskType(taskType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType);
    }

    @Operation(summary = "Get all task types", description = "Retrieves a list of all task types.")
    @ApiResponse(responseCode = "200", description = "List of task types retrieved successfully")
    @GetMapping
    public ResponseEntity<List<TaskType>> getAllTaskTypes() {
        return ResponseEntity.ok(taskTypeService.getAllTaskTypes());
    }

    @Operation(summary = "Delete a task type", description = "Deletes a task type by its ID.")
    @ApiResponse(responseCode = "204", description = "Task type deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskType(@PathVariable Long id) {
        taskTypeService.deleteTaskType(id);
        return ResponseEntity.noContent().build();
    }
}