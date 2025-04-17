package gp2.TaskManagement.TaskService.Client;

import gp2.TaskManagement.TaskService.Entity.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "StudentLifecycle")
public interface CandidateClient {
    @GetMapping("/lifecycle/candidates/{id}")
    ResponseEntity<Candidate> getCandidateById(@PathVariable Long id);
}
