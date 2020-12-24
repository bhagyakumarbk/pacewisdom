package com.pace.wisdom.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pace.wisdom.api.EmployeeAPI;
import com.pace.wisdom.api.EmployeeData;
import com.pace.wisdom.exceptions.EmployeeAlreadyExists;
import com.pace.wisdom.exceptions.EmployeeDetailsNotFound;
import com.pace.wisdom.exceptions.EmployeesNotFound;
import com.pace.wisdom.model.EmployeeEntity;
import com.pace.wisdom.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeAPI {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	EmployeeRepository eRepository;

	@Override
	public String createEmployee(EmployeeData eData) {
		// TODO Auto-generated method stub
		logger.info("Into the Implementation of Create Employee");
		EmployeeEntity e = eRepository.findByeId(eData.geteId());
		if (e == null) {

			EmployeeEntity eEntity = new EmployeeEntity();
			eEntity.seteId(eData.geteId());
			eEntity.setFirstName(eData.getFirstName());
			eEntity.setLastName(eData.getLastName());
			eEntity.setAddress(eData.getAddress());
			eEntity.setAge(eData.getAge());
			eEntity.setEmailId(eData.getEmailId());
			eEntity.setGender(eData.getGender());
			eRepository.save(eEntity);
			logger.info("Employee Saved" + eEntity);

			return "Employee Data Saved Successfully";
		} else {
			logger.error("Employee Already Exists");

			throw new EmployeeAlreadyExists("Employee Already Exists");
		}
	}

	@Override
	public List<EmployeeData> findAllEmployees() {
		// TODO Auto-generated method stub
		logger.info("Into the Implementation of list of Employees");

		List<EmployeeEntity> eEntity = eRepository.findAll();
		if (eEntity.isEmpty()) {
			logger.error("No Records found");

			throw new EmployeesNotFound("No Records found");
		} else {
			List<EmployeeData> list = new ArrayList<EmployeeData>();
			EmployeeData eData = new EmployeeData();
			eEntity.stream().forEach(s -> {
				eData.seteId(s.geteId());
				eData.setFirstName(s.getFirstName());
				eData.setLastName(s.getLastName());
				eData.setAddress(s.getAddress());
				eData.setAge(s.getAge());
				eData.setEmailId(s.getEmailId());
				eData.setGender(s.getGender());
				list.add(eData);
			}

			);

			return list;
		}
	}

	@Override
	public EmployeeData findEmployeeById(int id) {
		// TODO Auto-generated method stub
		logger.info("Into the Implementation of find Employee");
		EmployeeEntity s = eRepository.findByeId(id);
		EmployeeData eData = new EmployeeData();
		if (s == null) {
			logger.error("Employee not found");

			throw new EmployeeDetailsNotFound("Employee not found");
		} else {
			eData.seteId(s.geteId());
			eData.setFirstName(s.getFirstName());
			eData.setLastName(s.getLastName());
			eData.setAddress(s.getAddress());
			eData.setAge(s.getAge());
			eData.setEmailId(s.getEmailId());
			eData.setGender(s.getGender());

			return eData;
		}
	}

	@Override
	public String updateEmployee(int id, EmployeeData eData) {
		// TODO Auto-generated method stub
		logger.info("Into the Implementation of update Employee");
		EmployeeEntity eEntity = eRepository.findByeId(id);
		if (eEntity != null) {
			eEntity.seteId(eData.geteId());
			eEntity.setFirstName(eData.getFirstName());
			eEntity.setLastName(eData.getLastName());
			eEntity.setAddress(eData.getAddress());
			eEntity.setAge(eData.getAge());
			eEntity.setEmailId(eData.getEmailId());
			eEntity.setGender(eData.getGender());
			eRepository.save(eEntity);
			return "Employee Updated Successfully";
		} else {
			logger.error("Employee not found");

			throw new EmployeeDetailsNotFound("Employee Not Found");
		}
	}

	@Override
	public String deleteEmployee(int id) {
		logger.info("Into the Implementation of update Employee");
		EmployeeEntity eEntity = eRepository.findByeId(id);
		if (eEntity != null) {
			eRepository.delete(eEntity);
			return "Employee Deleted Successfully";
		} else {
			logger.error("Employee not found");

			throw new EmployeeDetailsNotFound("Employee Not Found");
		}
	}

}
