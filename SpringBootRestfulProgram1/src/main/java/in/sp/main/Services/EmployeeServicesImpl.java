package in.sp.main.Services;

import in.sp.main.Entities.Employee;
import in.sp.main.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override


    public Employee createEmployee(Employee employee) {
        return   employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }


    @Override
    public Employee updateEmployeeDetails(Long id,Employee emp) {
      return employeeRepository.save(emp);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Page<Employee> getAllByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}