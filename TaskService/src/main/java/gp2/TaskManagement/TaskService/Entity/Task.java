package gp2.TaskManagement.TaskService.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String objective;
    private LocalDateTime deadline;
    private int priorityIndex;


    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType type;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public enum TaskStatus {
        PENDING,
        COMPLETED,
        OVERDUE
    }

    private Long candidateId; // Associated candidate

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getObjective() {
        return objective;
    }

    public Task setObjective(String objective) {
        this.objective = objective;
        return this;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public Task setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }

    public int getPriorityIndex() {
        return priorityIndex;
    }

    public Task setPriorityIndex(int priorityIndex) {
        this.priorityIndex = priorityIndex;
        return this;
    }

    public TaskType getType() {
        return type;
    }

    public Task setType(TaskType type) {
        this.type = type;
        return this;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task setStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public Task setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
        return this;
    }
}