package com.pace.wisdom.api;

import java.util.List;
import java.util.Set;

public interface EmployeeAPI {
	
	public String createEmployee(EmployeeData eData);
	public List<EmployeeData> findAllEmployees();
	public EmployeeData findEmployeeById(int id);
	public String updateEmployee(int id,EmployeeData eData);
	public String deleteEmployee(int id);

}
