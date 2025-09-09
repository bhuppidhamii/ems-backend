package bhuppi.ems_backend.controller;

import bhuppi.ems_backend.dto.EmployeeDto;
import bhuppi.ems_backend.entity.Employee;
import bhuppi.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //    add employee rest api
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //    get emp by id
    @GetMapping("{Id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("Id") Long Id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(employeeDto);
    }

    //    get all employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //    update employee
    @PutMapping("{Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("Id") Long Id, @RequestBody EmployeeDto updateEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(Id, updateEmployee);
        return ResponseEntity.ok(employeeDto);

    }


    //    delete employee
    @DeleteMapping("{Id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("Id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted");
    }

}

