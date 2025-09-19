package com.multi.springboot.mapper;


import com.multi.springboot.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employees")
    List<Employee> getAllEmployees();

    @Insert("INSERT INTO employees(name, age, employee_number, department) VALUES(#{name}, #{age}, #{employeeNumber}, #{department})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addEmployee(Employee employee);

    @Update("UPDATE employees SET name=#{name}, age=#{age}, employee_number=#{employeeNumber}, department=#{department} WHERE id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    void deleteEmployeeById(Long id);
}



