package gp2.TaskManagement.TaskService.ServiceImpl;

import gp2.TaskManagement.TaskService.Entity.TaskType;
import gp2.TaskManagement.TaskService.Repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskTypeServiceImplement {
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    public TaskType createTaskType(TaskType taskType) {
        if (taskTypeRepository.findByName(taskType.getName()).isPresent()) {
            throw new IllegalArgumentException("Task type already exists.");
        }
        return taskTypeRepository.save(taskType);
    }

    public List<TaskType> getAllTaskTypes() {
        return (List<TaskType>) taskTypeRepository.findAll();
    }

    public void deleteTaskType(Long id) {
        if (!taskTypeRepository.existsById(id)) {
            throw new RuntimeException("Task type not found");
        }
        taskTypeRepository.deleteById(id);
    }
}
