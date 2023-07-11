package com.alamu.EmpManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alamu.EmpManagement.domain.Employee;
import com.alamu.EmpManagement.dto.EmployeeDTO;
import com.alamu.EmpManagement.repository.EmployeeRepository;
import com.alamu.EmpManagement.utilities.Mapper;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    static final Long EMPLOYEE_IDENTIFIER1 =1L;
    @Mock
    EmployeeRepository employeeRepository;

    EmployeeService employeeService;


    @BeforeEach
    void init(){
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    @DisplayName("test Create new employee in service layer")
    void createNewEmployee() {
        // Given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(EMPLOYEE_IDENTIFIER1);
        employeeDTO.setFirstName("alamu");
        employeeDTO.setLastName("khanna");
        employeeDTO.setEmail("abc@gmail.com");
        Employee employee= Mapper.getEmployee(employeeDTO);
        given(employeeRepository.save(any(Employee.class))).willReturn(employee);

        // When
        EmployeeDTO savedEmployee=  employeeService.createNewEmployee(employeeDTO);
        // Then
        assertNotNull(savedEmployee);
        assertEquals(EMPLOYEE_IDENTIFIER1,savedEmployee.getId());
        assertEquals("khanna",savedEmployee.getLastName());
        then(employeeRepository).should().save(any(Employee.class));
        then(employeeRepository).shouldHaveNoMoreInteractions();
    }
}
