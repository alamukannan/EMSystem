package com.alamu.EmpManagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alamu.EmpManagement.controller.EmployeeController;

@SpringBootTest
class EmpManagementApplicationTests {

	@Autowired
	EmployeeController employeeController;
	@Test
	void contextLoads() {
		assertNotNull(employeeController);
	}

}
