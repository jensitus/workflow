package at.phactum.Workflow.credit;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "credit")
@Data
public class CreditAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    public enum Type {
        IMMO
    }

}
