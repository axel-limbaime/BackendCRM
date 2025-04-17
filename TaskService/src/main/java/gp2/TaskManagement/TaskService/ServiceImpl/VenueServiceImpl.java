package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.Venue;
import gp2.TaskManagement.TaskService.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueServiceImpl {

        @Autowired
        private VenueRepository venueRepository;

        public List<Venue> findAll() {
            return (List<Venue>) venueRepository.findAll();
        }

        public Venue findById(Long id) {
            Optional<Venue> venue = venueRepository.findById(id);
            return venue.orElse(null); // or throw a custom exception
        }

        public Venue save(Venue venue) {
            return venueRepository.save(venue);
        }

        public Venue update(Long id, Venue venue) {
            if (venueRepository.existsById(id)) {
                venue.setId(id);
                return venueRepository.save(venue);
            } else {
                return null; // or throw a custom exception
            }
        }

        public void delete(Long id) {
            venueRepository.deleteById(id);
        }
}
