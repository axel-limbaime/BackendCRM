package gp2.TaskManagement.TaskService.Controller;

import gp2.TaskManagement.TaskService.Entity.EventType;
import gp2.TaskManagement.TaskService.ServiceImpl.EventTypeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Event Type Management", description = "Endpoints for managing event types")
@RestController
@RequestMapping("/Task/event-types")
public class EventTypeController {

    @Autowired
    private EventTypeServiceImpl eventTypeService;

    @Operation(summary = "Get all event types", description = "Retrieves a list of all event types.")
    @ApiResponse(responseCode = "200", description = "List of event types retrieved successfully")
    @GetMapping
    public List<EventType> getAllEventTypes() {
        return eventTypeService.findAll();
    }

    @Operation(summary = "Get event type by ID", description = "Retrieves an event type by its ID.")
    @ApiResponse(responseCode = "200", description = "Event type retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Event type not found")
    @GetMapping("/{id}")
    public ResponseEntity<EventType> getEventTypeById(@PathVariable Long id) {
        EventType eventType = eventTypeService.findById(id);
        if (eventType != null) {
            return ResponseEntity.ok(eventType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new event type", description = "Creates a new event type and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Event type created successfully")
    @PostMapping
    public EventType createEventType(@RequestBody EventType eventType) {
        return eventTypeService.save(eventType);
    }

    @Operation(summary = "Update an event type", description = "Updates an existing event type by its ID.")
    @ApiResponse(responseCode = "200", description = "Event type updated successfully")
    @ApiResponse(responseCode = "404", description = "Event type not found")
    @PutMapping("/{id}")
    public ResponseEntity<EventType> updateEventType(@PathVariable Long id, @RequestBody EventType eventType) {
        EventType updatedEventType = eventTypeService.update(id, eventType);
        if (updatedEventType != null) {
            return ResponseEntity.ok(updatedEventType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete an event type", description = "Deletes an event type by its ID.")
    @ApiResponse(responseCode = "204", description = "Event type deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventType(@PathVariable Long id) {
        eventTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
