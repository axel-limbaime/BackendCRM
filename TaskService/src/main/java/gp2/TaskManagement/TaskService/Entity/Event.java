package gp2.TaskManagement.TaskService.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "events")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable=false,unique=true)
    private String name;
    @Column(name="start_date", nullable=false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate start;
    @Column(name="end_date", nullable=false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate end;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name="start_time", nullable=false)
    LocalTime start_time;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name="end_time", nullable=false)
    LocalTime end_time;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    EventType typeId;

    @ManyToOne
    @JoinColumn(name="location", nullable=false)
    Venue location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public EventType getTypeId() {
        return typeId;
    }

    public void setTypeId(EventType typeId) {
        this.typeId = typeId;
    }

    public Venue getLocation() {
        return location;
    }

    public void setLocation(Venue location) {
        this.location = location;
    }
}
