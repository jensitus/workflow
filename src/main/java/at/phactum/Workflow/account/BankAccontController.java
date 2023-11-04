package at.phactum.Workflow.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-account")
public class BankAccontController {

    @Autowired
    private BankAccountWorkflow bankAccountWorkflow;

    @GetMapping("/{type}/request/{customer}")
    public void requestAccount(@PathVariable("type") String type, @PathVariable("customer") String customer) throws Exception {
        bankAccountWorkflow.requestBankAccount(type, customer);
    }

}
