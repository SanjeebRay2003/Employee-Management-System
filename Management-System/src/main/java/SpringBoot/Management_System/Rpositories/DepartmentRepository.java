package SpringBoot.Management_System.Rpositories;

import SpringBoot.Management_System.Entities.DepartmentEntity;
import SpringBoot.Management_System.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
