package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.Contact;
import gp2.TaskManagement.TaskService.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null); // or throw a custom exception
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact update(Long id, Contact contact) {
        if (contactRepository.existsById(id)) {
            contact.setId(id);
            return contactRepository.save(contact);
        } else {
            return null; // or throw a custom exception
        }
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
