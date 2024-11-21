package SpringBoot.Management_System.Rpositories;

import SpringBoot.Management_System.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
