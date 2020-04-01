package com.assignment.employeeapi.controller;

import com.assignment.employeeapi.dto.EmployeeDTO;

import com.assignment.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data


    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService=theEmployeeService;
    }


    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<EmployeeDTO> employeeDTOs=employeeService.findAll();


        theModel.addAttribute("employees", employeeDTOs);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        EmployeeDTO employeeDTO=new EmployeeDTO();
        model.addAttribute("employee",employeeDTO);
        return "employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {


        employeeService.save(employeeDTO);

        return "redirect:/employees/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {

        // get the employee from the service
        EmployeeDTO employeeDTO = employeeService.findById(theId);


        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", employeeDTO);

        // send over to our form
        return "employee-form";
    }

    @GetMapping("/delete")
    public String doingDelete(@RequestParam("employeeId") int theId) {

        // get the employee from the service

        employeeService.deleteById(theId);

        // send over to our form
        return "redirect:/employees/list";
    }

}


