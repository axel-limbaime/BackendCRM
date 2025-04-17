package gp2.TaskManagement.TaskService.Repository;

import gp2.TaskManagement.TaskService.Entity.TaskType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskTypeRepository extends CrudRepository<TaskType, Long> {
    Optional<TaskType> findByName(String name);
}