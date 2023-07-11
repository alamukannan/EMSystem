package com.alamu.EmpManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alamu.EmpManagement.dto.EmployeeDTO;
import com.alamu.EmpManagement.services.EmployeeService;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
    private final EmployeeService employeeService;
    private final Logger log = LogManager.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping(value = "/new",consumes = "application/json",produces = "application/json")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        log.info("Requested to save new Employee");
      EmployeeDTO employeeDTO1= employeeService.createNewEmployee(employeeDTO);
      return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }
}
