package com.multi.springboot.service;

import com.multi.springboot.mapper.EmployeeMapper;
import com.multi.springboot.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
        return employee;
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployeeById(Long id) {
        employeeMapper.deleteEmployeeById(id);
    }
}