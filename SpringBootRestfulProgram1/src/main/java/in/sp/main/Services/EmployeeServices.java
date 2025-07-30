package in.sp.main.Services;

import in.sp.main.Entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    public Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> getByName(String name);
    Optional<Employee> getById(Long id);
    public Employee updateEmployeeDetails(Long id, Employee employee);
    void deleteEmployee(Long id);
    Page<Employee> getAllByPage(Pageable pageable);
}