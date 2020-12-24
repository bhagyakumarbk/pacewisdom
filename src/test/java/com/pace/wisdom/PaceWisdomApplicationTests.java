package com.pace.wisdom;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
		System.out.println(response);
		assertTrue(response!=null);

		
	}
	@Test
	public void testGetdEmployeeData(){
		EmployeeData eData=insertData();
		EmployeeData response = eService.findEmployeeById(eData.geteId());
		assertTrue(response!=null);
		
	}@Test
	public void testUpdateEmployeeData(){
		
		EmployeeData eData=insertData();
		eData.setFirstName("Abraham");
		String response = eService.updateEmployee(eData.geteId(), eData);
		assertTrue(response!=null);

		
	}@Test
	public void testDeleteEmployeeData(){
		EmployeeData eData=insertData();
		String response = eService.deleteEmployee(eData.geteId());
		assertTrue(response!=null);
		
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
