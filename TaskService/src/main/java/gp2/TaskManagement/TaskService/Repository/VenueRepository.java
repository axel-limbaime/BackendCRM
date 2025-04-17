package gp2.TaskManagement.TaskService.Repository;

import gp2.TaskManagement.TaskService.Entity.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
}
