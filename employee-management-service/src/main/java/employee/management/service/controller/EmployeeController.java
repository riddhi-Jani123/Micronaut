package employee.management.service.controller;

import employee.management.service.model.Employee;
import employee.management.service.repository.EmployeeRepository;
import employee.management.service.serviceImpl.EmployeeServiceImpl;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeServiceImpl employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @Get("/")
    public List<Employee> getAllEmployees() {
        employeeRepository.findAll();
        return employeeService.findAll();
    }

    @Get("/{id}")
    public Employee getEmployeeById(Long id) {
        return employeeService.findById(id);
    }

    @Post("/")
    public Employee saveEmployee(@Body Employee employee) {
        return employeeService.save(employee);
    }

    @Put("/{id}")
    public Employee updateEmployee(Long id, @Body Employee employee) {
        Employee updatedEmployee = new Employee(id, employee.name(), employee.email(), employee.departmentId());
        return employeeService.update(updatedEmployee);
    }

    @Delete("/{id}")
    public void deleteEmployee(Long id) {
        employeeService.deleteById(id);
    }
}
