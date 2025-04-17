package gp2.TaskManagement.TaskService.Repository;

import gp2.TaskManagement.TaskService.Entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
