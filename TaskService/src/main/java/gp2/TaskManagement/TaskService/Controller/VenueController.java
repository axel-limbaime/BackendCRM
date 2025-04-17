package gp2.TaskManagement.TaskService.Controller;

import gp2.TaskManagement.TaskService.Entity.Venue;
import gp2.TaskManagement.TaskService.ServiceImpl.VenueServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Venue Management", description = "Endpoints for managing venues")
@RestController
@RequestMapping("/Task/venues")
public class VenueController {

    @Autowired
    private VenueServiceImpl venueService;

    @Operation(summary = "Get all venues", description = "Retrieves a list of all venues.")
    @ApiResponse(responseCode = "200", description = "List of venues retrieved successfully")
    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.findAll();
    }

    @Operation(summary = "Get venue by ID", description = "Retrieves a venue by its ID.")
    @ApiResponse(responseCode = "200", description = "Venue retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Venue not found")
    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = venueService.findById(id);
        if (venue != null) {
            return ResponseEntity.ok(venue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new venue", description = "Creates a new venue and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Venue created successfully")
    @PostMapping
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.save(venue);
    }

    @Operation(summary = "Update a venue", description = "Updates an existing venue by its ID.")
    @ApiResponse(responseCode = "200", description = "Venue updated successfully")
    @ApiResponse(responseCode = "404", description = "Venue not found")
    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
        Venue updatedVenue = venueService.update(id, venue);
        if (updatedVenue != null) {
            return ResponseEntity.ok(updatedVenue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a venue", description = "Deletes a venue by its ID.")
    @ApiResponse(responseCode = "204", description = "Venue deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
