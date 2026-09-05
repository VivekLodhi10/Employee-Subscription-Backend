package com.employee_subscription.service;

import com.employee_subscription.entity.Employee;
import com.employee_subscription.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
    }
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id,Employee employee) {
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setStatus(employee.getStatus());

        return this.employeeRepository.save(existingEmployee);
    }

}
