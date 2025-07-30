
package in.sp.main.Controllar;

import in.sp.main.BaseControllar.BaseController;
import in.sp.main.Entities.Employee;
import in.sp.main.Responce.CustomResponse;
import in.sp.main.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class MyController extends BaseController {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/employee")
    public CustomResponse<Employee> createEmployee(@RequestBody Employee employee) {
        return success(employeeServices.createEmployee(employee), "Employee created successfully");
    }

    @GetMapping("/employee")
    public  CustomResponse<List<Employee>> getAllEmployee() {
        return success(employeeServices.getAllEmployees(), "All Employees fetched successfully");
    }

    @GetMapping("/employee/{id}")
    public CustomResponse<Optional<Employee>>getById(@PathVariable Long id) {
       return success(employeeServices.getById(id), "Employee fetched by ID successfully");
    }

    @GetMapping("/employeeName/{name}")
    public CustomResponse<List<Employee>> getByName(@PathVariable String name) {
        return success(employeeServices.getByName(name), "Employees fetched by name successfully") ;

    }

    @PutMapping("/employee/{id}")
    public CustomResponse<Employee>UpdateEmployeeDetails(@PathVariable Long id, @RequestBody Employee emp) {
        return success(employeeServices.updateEmployeeDetails(id, emp), "Employee updated successfully");
    }

    @DeleteMapping("/employee/{id}")
    public CustomResponse<String> deleteEmployee(@PathVariable Long id) {
        employeeServices.deleteEmployee(id);
        return success( null,"Employee deleted successfully");
    }

    @GetMapping("/employee/page")
    public CustomResponse<Page<Employee>> getAllByPage(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
      return success(employeeServices.getAllByPage(PageRequest.of(page, size)), "Employees fetched by page successfully");
    }
}