package at.phactum.Workflow.credit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CreditController {

    private final CreditWorkflow creditWorkflow;

    public CreditController(CreditWorkflow creditWorkflow) {
        this.creditWorkflow = creditWorkflow;
    }

    @GetMapping("/request-credit")
    public void requestCredit() throws Exception {
        creditWorkflow.requestCredit();
    }

    @GetMapping("/donner")
    public void donner() {
        System.out.println("Donner");
    }

}
