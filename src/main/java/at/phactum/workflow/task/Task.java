package at.phactum.workflow.task;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "element_id")
    private String elementId;

    @Column(name = "bpmn_process_id")
    private String bpmnProcessId;

    @Column(name = "process_instance_key")
    private Long processInstanceKey;

    @Column(name = "element_instance_key")
    private Long elementInstanceKey;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "aggregate_id")
    private String aggregateId;

    @Column(name = "status")
    private String status;

    public enum Status {
        OPEN,
        COMPLETED
    }

}
