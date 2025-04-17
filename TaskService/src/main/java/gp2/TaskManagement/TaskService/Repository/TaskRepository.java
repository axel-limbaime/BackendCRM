package gp2.TaskManagement.TaskService.Repository;

import gp2.TaskManagement.TaskService.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCandidateId(Long candidateId);
}