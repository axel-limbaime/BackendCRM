package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.Event;
import gp2.TaskManagement.TaskService.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl  {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null); // or throw a custom exception
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Long id, Event event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        } else {
            return null; // or throw a custom exception
        }
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}