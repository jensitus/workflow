package at.phactum.workflow.cockpit;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class UserTaskEvent {

    private String id;

    private Boolean updated;

    private String userTaskId;

    private String initiator;

    private OffsetDateTime timestamp;

    private String source;

    private String workflowModule;

    private String comment;

    private String bpmnProcessId;

    private String bpmnProcessVersion;

    private Map<String, String> workflowTitle = null;

    private String workflowId;

    private String subWorkflowId;

    private String businessId;

    private Map<String, String> title = new HashMap<>();

    private String bpmnTaskId;

    private String taskDefinition;

    private Map<String, String> taskDefinitionTitle = null;

    private String workflowModuleUri;

    private String taskProviderApiUriPath;

    private String uiUriPath;

    private UiUriType uiUriType;

    private String assignee;

    private List<String> candidateUsers = null;

    private List<String> candidateGroups = null;

    private OffsetDateTime dueDate;

    private OffsetDateTime followUpDate;

    private Map<String, Object> details = null;

    private String detailsFulltextSearch;

}
