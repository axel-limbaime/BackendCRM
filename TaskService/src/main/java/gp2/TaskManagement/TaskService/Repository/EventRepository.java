package gp2.TaskManagement.TaskService.Repository;

import gp2.TaskManagement.TaskService.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
