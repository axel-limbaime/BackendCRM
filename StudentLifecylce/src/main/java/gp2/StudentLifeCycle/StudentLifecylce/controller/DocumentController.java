package gp2.StudentLifeCycle.StudentLifecylce.controller;

import gp2.StudentLifeCycle.StudentLifecylce.models.Document;
import gp2.StudentLifeCycle.StudentLifecylce.serviceimpl.DocumentServiceImplement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "Document Management", description = "Endpoints for managing documents")
@RestController
@RequestMapping("/lifecycle/documents")
public class DocumentController {

    private DocumentServiceImplement documentService;

    public DocumentController(DocumentServiceImplement documentService) {
        this.documentService = documentService;
    }

    @Operation(summary = "Upload a document", description = "Uploads a new document and saves it to the database.")
    @ApiResponse(responseCode = "200", description = "Document uploaded successfully")
    @ApiResponse(responseCode = "500", description = "Failed to upload document")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            Document document = documentService.saveDocument(file);
            return ResponseEntity.ok("Document uploaded successfully with ID: " + document.getId());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload document: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return ResponseEntity.ok(document);
    }
    @GetMapping("/candidate/{id}")
    public ResponseEntity<Document> getDocumentsByCandidateId(@PathVariable Long id) {
        Document documents = documentService.getDocumentsByCandidateId(id).orElse(null);
        if (documents != null) {
            return ResponseEntity.ok(documents);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
