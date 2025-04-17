package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.EventType;
import gp2.TaskManagement.TaskService.Repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeServiceImpl {

    @Autowired
    private EventTypeRepository eventTypeRepository;


    public List<EventType> findAll() {
        return (List<EventType>) eventTypeRepository.findAll();
    }

    public EventType findById(Long id) {
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        return eventType.orElse(null); // or throw a custom exception
    }

    public EventType save(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    public EventType update(Long id, EventType eventType) {
        if (eventTypeRepository.existsById(id)) {
            eventType.setId(id);
            return eventTypeRepository.save(eventType);
        } else {
            return null; // or throw a custom exception
        }
    }

    public void delete(Long id) {
        eventTypeRepository.deleteById(id);
    }
}
