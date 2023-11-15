package at.phactum.workflow.account;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "bankaccount")
@Data
@ToString
public class BankAccount {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "customer")
    private String customer;

    @Column(name = "confirm_account_task_id")
    private String confirmAccountTaskId;

}
