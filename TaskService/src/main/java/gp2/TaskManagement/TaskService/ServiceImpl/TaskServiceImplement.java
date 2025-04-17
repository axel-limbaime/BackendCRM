package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.Task;
import gp2.TaskManagement.TaskService.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplement {
    private final TaskRepository taskRepository;

    public TaskServiceImplement(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        if (task.getDeadline().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Deadline cannot be in the past.");
        }
        task.setStatus(Task.TaskStatus.PENDING);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByCandidate(Long candidateId) {
        return taskRepository.findByCandidateId(candidateId);
    }

    public  List<Task> getTasks(){ return taskRepository.findAll(); }

    public void deleteTask(Long id){ taskRepository.deleteById(id);}

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isEmpty()) {
            throw new RuntimeException("Task not found");
        }

        Task task = existingTask.get();
        if (task.getDeadline().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Cannot update a task after the deadline");
        }
        if (task.getStatus() != Task.TaskStatus.PENDING) {
            throw new RuntimeException("Action not allowed: The task is not in PENDING status.");
        }

        task.setName(updatedTask.getName());
        task.setObjective(updatedTask.getObjective());
        task.setDeadline(updatedTask.getDeadline());
        task.setPriorityIndex(updatedTask.getPriorityIndex());
        task.setType(updatedTask.getType());

        return taskRepository.save(task);
    }

    public Task markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        if (task.getDeadline().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Cannot mark a task as completed after the deadline");
        }
        task.setStatus(Task.TaskStatus.COMPLETED);
        return taskRepository.save(task);
    }
}
