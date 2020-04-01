package com.assignment.employeeapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.assignment.employeeapi.dao.EmployeeRepository;
import com.assignment.employeeapi.dto.EmployeeDTO;
import com.assignment.employeeapi.entity.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * I've converted entites to DTO in service layer to make sure that all my services
 * return a DTO and never an entity to the controller.Therefore,Controller returns DTOs
 * to the model.Hence users cannot have direct access to entities.Because in controller
 * we never use entities.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
        employeeRepository = theEmployeeRepo;
    }

    @Override
    @Transactional
    public List<EmployeeDTO> findAll() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    @Override
    public EmployeeDTO findById(int theId) {


        Optional<Employee> result = employeeRepository.findById(theId);




        if(result.isPresent()) {
            return convertToDto(result.get());
        }
        else {
            throw new RuntimeException("Did not find employee id "+theId);
        }
    }

    @Override
    @Transactional
    public void save(EmployeeDTO theEmployeeDTO) {
        employeeRepository.save(convertToEntity(theEmployeeDTO));
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    private EmployeeDTO convertToDto(Employee employee){

        EmployeeDTO employeeDTO=modelMapper.map(employee,EmployeeDTO.class);

        return employeeDTO;


    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {

        Employee employee=modelMapper.map(employeeDTO, Employee.class);
        return employee;
    }


}






