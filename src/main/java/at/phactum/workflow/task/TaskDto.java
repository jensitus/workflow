package at.phactum.workflow.task;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskDto {
    private String elementId;
    private String bpmnProcessId;
    private Long processInstanceKey;
    private Long elementInstanceKey;
    private Long processDefinitionKey;
    private String taskId;
    private String aggregateId;
    private String status;
}
