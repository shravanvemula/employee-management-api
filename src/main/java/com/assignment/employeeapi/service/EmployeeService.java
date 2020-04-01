package com.assignment.employeeapi.service;
import java.util.List;

import com.assignment.employeeapi.dto.EmployeeDTO;




public interface EmployeeService {
    List<EmployeeDTO> findAll();

    EmployeeDTO findById(int theId);

     void save(EmployeeDTO theEmployeeDTO);

    void deleteById(int theId);
}
