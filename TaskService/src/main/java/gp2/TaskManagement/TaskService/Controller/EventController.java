package gp2.TaskManagement.TaskService.Controller;

import gp2.TaskManagement.TaskService.Entity.Event;
import gp2.TaskManagement.TaskService.ServiceImpl.EventServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Event Management", description = "Endpoints for managing events")
@RestController
@RequestMapping("/Task/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @Operation(summary = "Get all events", description = "Retrieves a list of all events.")
    @ApiResponse(responseCode = "200", description = "List of events retrieved successfully")
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @Operation(summary = "Get event by ID", description = "Retrieves an event by its ID.")
    @ApiResponse(responseCode = "200", description = "Event retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Event not found")
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.findById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new event", description = "Creates a new event and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Event created successfully")
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @Operation(summary = "Update an event", description = "Updates an existing event by its ID.")
    @ApiResponse(responseCode = "200", description = "Event updated successfully")
    @ApiResponse(responseCode = "404", description = "Event not found")
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event updatedEvent = eventService.update(id, event);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete an event", description = "Deletes an event by its ID.")
    @ApiResponse(responseCode = "204", description = "Event deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
