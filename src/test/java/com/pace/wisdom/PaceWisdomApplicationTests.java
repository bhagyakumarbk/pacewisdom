package com.pace.wisdom;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pace.wisdom.api.EmployeeData;
import com.pace.wisdom.service.EmployeeService;

@SpringBootTest
class PaceWisdomApplicationTests {
	
	@Autowired
	EmployeeService eService;
	@Test
	public void testAddEmployeeData(){
		EmployeeData eData=insertData();
		String response = eService.createEmployee(eData);
		assertTrue(response!=null);

		
	}
	@Test
	public void testGetdEmployeeData(){
		
	}@Test
	public void testUpdateEmployeeData(){
		
	}@Test
	public void testDeleteEmployeeData(){
		
	}
	
	private EmployeeData insertData() {
		EmployeeData eData=new EmployeeData();
		eData.seteId(2255);
		eData.setFirstName("Jonus");
		eData.setLastName("Khanwald");
		eData.setAddress("Winden");
		eData.setAge(24);
		eData.setEmailId("jhonkhanwald@gmail.com");
		eData.setGender("Male");
		
		return eData;
	}
}
