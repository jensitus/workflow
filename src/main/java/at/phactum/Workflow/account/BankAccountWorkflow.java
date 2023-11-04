package at.phactum.Workflow.account;

import at.phactum.Workflow.task.Task;
import at.phactum.Workflow.task.TaskRepository;
import at.phactum.Workflow.task.TaskService;
import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.*;
import io.vanillabp.spi.service.TaskEvent.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Task task = taskService.createTask(taskId, bankAccount.getId());

    }

    @WorkflowTask(taskDefinition = "set_account_form_key")
    public void setAccountFormKey() {
        log.info("set_account_form_key");
    }

}
