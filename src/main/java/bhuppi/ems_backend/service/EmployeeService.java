package bhuppi.ems_backend.service;

import bhuppi.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);


    EmployeeDto getEmployeeById(Long employeeId);
}
