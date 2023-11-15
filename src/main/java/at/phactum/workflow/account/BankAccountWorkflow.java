package at.phactum.workflow.account;

import at.phactum.workflow.cockpit.UserTaskEvent;
import at.phactum.workflow.task.Task;
import at.phactum.workflow.task.TaskService;
import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.TaskId;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@WorkflowService(workflowAggregateClass = BankAccount.class)
@Slf4j
public class BankAccountWorkflow {

    @Autowired
    private ProcessService<BankAccount> bankAccountProcessService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskService taskService;

    public void requestBankAccount(String type, String customer) throws Exception {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setType(type);
        bankAccount.setCustomer(customer);
        bankAccountProcessService.startWorkflow(bankAccount);
    }

    @WorkflowTask(taskDefinition = "confirm_account")
    public void confirmAccount(final BankAccount bankAccount, final @TaskId String taskId) {
        log.info("confirm_account: {}", bankAccount);
        log.info("taskId: {}", taskId);
        // Task task = taskService.createTask(taskId, bankAccount.getId());
        UserTaskEvent userTaskEvent = new UserTaskEvent();
        userTaskEvent.setBpmnTaskId("confirm_account");
        userTaskEvent.setTaskDefinition("confirm_account");
        userTaskEvent.setUserTaskId(taskId);
        userTaskEvent.setBpmnProcessId("confirm_account");
        taskService.sendTaskToBusinessCockpit(userTaskEvent);
    }

    @WorkflowTask(taskDefinition = "set_account_form_key")
    public void setAccountFormKey() {
        log.info("set_account_form_key");
    }

    public void completeTask(String aggregateId, String taskId) {
        Optional<BankAccount> bankAccountOptional = accountRepository.findById(aggregateId);
        if (bankAccountOptional.isPresent()) {
            taskService.updateStatus(taskId, Task.Status.COMPLETED.name());
            bankAccountProcessService.completeUserTask(bankAccountOptional.get(), taskId);
        }

    }

}
