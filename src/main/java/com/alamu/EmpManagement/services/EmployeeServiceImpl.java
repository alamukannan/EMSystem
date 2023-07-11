package com.alamu.EmpManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamu.EmpManagement.domain.Employee;
import com.alamu.EmpManagement.dto.EmployeeDTO;
import com.alamu.EmpManagement.repository.EmployeeRepository;
import com.alamu.EmpManagement.utilities.Mapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        Employee detachedEmployee = Mapper.getEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(detachedEmployee);

        return Mapper.getEmployeeDTO(savedEmployee);
    }
}
