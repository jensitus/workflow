package at.phactum.Workflow.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(String taskId, String aggregateId) {
        Task task = new Task();
        task.setTaskId(taskId);
        task.setAggregateId(aggregateId);
        task.setStatus(Task.Status.OPEN.toString());
        return taskRepository.save(task);
    }
    public void createTask(TaskDto taskDto, String taskId) {
        Task task = taskRepository.findTaskByTaskId(taskId);
        task.setElementId(taskDto.getElementId());
        task.setBpmnProcessId(taskDto.getBpmnProcessId());
        task.setProcessInstanceKey(taskDto.getProcessInstanceKey());
        task.setElementInstanceKey(taskDto.getElementInstanceKey());
        taskRepository.save(task);
    }

    public void updateStatus(String taskId, String status) {
        taskRepository.updateStatus(status, taskId);
    }

}
