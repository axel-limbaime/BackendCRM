package gp2.TaskManagement.TaskService.Controller;

import gp2.TaskManagement.TaskService.Entity.Contact;
import gp2.TaskManagement.TaskService.ServiceImpl.ContactServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Contact Management", description = "Endpoints for managing contacts")
@RestController
@RequestMapping("/Task/contacts")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @Operation(summary = "Get all contacts", description = "Retrieves a list of all contacts.")
    @ApiResponse(responseCode = "200", description = "List of contacts retrieved successfully")
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @Operation(summary = "Get contact by ID", description = "Retrieves a contact by its ID.")
    @ApiResponse(responseCode = "200", description = "Contact retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Contact not found")
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new contact", description = "Creates a new contact and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Contact created successfully")
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @Operation(summary = "Update a contact", description = "Updates an existing contact by its ID.")
    @ApiResponse(responseCode = "200", description = "Contact updated successfully")
    @ApiResponse(responseCode = "404", description = "Contact not found")
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact updatedContact = contactService.update(id, contact);
        if (updatedContact != null) {
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a contact", description = "Deletes a contact by its ID.")
    @ApiResponse(responseCode = "204", description = "Contact deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
