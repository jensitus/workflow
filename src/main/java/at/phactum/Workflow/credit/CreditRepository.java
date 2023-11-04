package at.phactum.Workflow.credit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<CreditAggregate, Long> {
}
