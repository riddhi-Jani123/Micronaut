package employee.management.service.serviceImpl;

import employee.management.service.entity.EmployeeEntity;
import employee.management.service.model.Employee;
import employee.management.service.repository.EmployeeRepository;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl {
    @Inject
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {

        List<EmployeeEntity> employeeList = employeeRepository.findAll();

        List<Employee> employees = new ArrayList<>();
        employeeList.forEach(employee -> {
            employees.add(new Employee(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartmentId()));
        });

        return employees;
    }

    public Employee findById(Long id) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

        return employeeEntity.map(entity -> new Employee(entity.getId(), entity.getName(), entity.getEmail(), entity.getDepartmentId())).orElse(null);
    }

    public Employee save(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity(employee.id(), employee.name(), employee.email(), employee.departmentId());

        entity  = employeeRepository.save(entity);

        employee = new Employee(entity.getId(), entity.getName(), entity.getEmail(), entity.getDepartmentId());

        return employee;
    }

    public Employee update(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity(employee.id(), employee.name(), employee.email(), employee.departmentId());

        employeeRepository.update(entity);

        return employee;
    }

    public void deleteById(Long id) {

        employeeRepository.deleteById(id);


    }
}
