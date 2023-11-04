package at.phactum.Workflow.credit;

import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.TaskId;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@WorkflowService(workflowAggregateClass = CreditAggregate.class)
@Slf4j
public class CreditWorkflow {

    @Autowired
    private ProcessService<CreditAggregate> processService;

    @Autowired
    private CreditRepository creditRepository;

    @WorkflowTask(taskDefinition = "grantCredit")
    public void grantCredit(final CreditAggregate creditAggregate, @TaskId final String taskId) {
        log.info("credit task: {}", taskId);
    }

    public void requestCredit() throws Exception {
        CreditAggregate creditAggregate = new CreditAggregate();
        creditAggregate.setType(CreditAggregate.Type.IMMO.name());
        creditAggregate.setId(2L);
        processService.startWorkflow(creditAggregate);
    }

}
