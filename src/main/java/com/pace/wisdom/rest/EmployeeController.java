package com.pace.wisdom.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.wisdom.api.EmployeeAPI;
import com.pace.wisdom.api.EmployeeData;

@RestController
@RequestMapping(path = "paceWisdom")
public class EmployeeController {

	@Autowired
	EmployeeAPI api;

	@PostMapping(path = EmployeeRestConstants.ADDEMPLOYEE)
	public String addEmployee(@RequestBody EmployeeData eData) {
		return api.createEmployee(eData);
	}

	@GetMapping(path = EmployeeRestConstants.GETALLEMPLOYEES)
	public List<EmployeeData> findAll() {
		return api.findAllEmployees();
	}

	@GetMapping(path = EmployeeRestConstants.GETEMPLOYEE + "/" + "{" + EmployeeRestConstants.ID + "}")
	public EmployeeData findById(@PathVariable int id) {
		return api.findEmployeeById(id);
	}

	@PutMapping(path = EmployeeRestConstants.UPDATEEMPLOYEE + "/" + "{" + EmployeeRestConstants.ID + "}")
	public String update(@RequestBody EmployeeData eData,@PathVariable int id) {
		return api.updateEmployee(id ,eData);
	}

	@DeleteMapping (path = EmployeeRestConstants.DELETEEMPLOYEE + "/" + "{" + EmployeeRestConstants.ID + "}")
	public String delete(@PathVariable int id) {
		return api.deleteEmployee(id);
	}

}
