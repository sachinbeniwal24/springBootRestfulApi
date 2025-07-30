package in.sp.main.Repository;

import in.sp.main.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByName(String name);
}




