package gp2.TaskManagement.TaskService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8080/auth") // URL of the user service in the gateway
public interface UserClient {
    @GetMapping("/users/validate-role")
    boolean validateRole(@RequestParam("username") String username, @RequestParam("role") String role);
}