package at.phactum.Workflow.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

  Task findTaskByTaskId(String taskId);

  @Modifying
  @Transactional
  @Query("update Task t set t.status = :status where t.taskId = :taskId")
  void updateStatus(@Param(value = "status") String status, @Param(value = "taskId") String taskId);

}
