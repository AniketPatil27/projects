package com.harman.service;

import java.util.List;

import com.harman.entity.Employee;
import com.harman.exception.ExceptionClass;

public interface EmpService {

	public Employee getByIdS(int id);
	List<Employee> getEmpS();
	public void addS(Employee e) throws ExceptionClass;
	public void updateS(Employee e)throws ExceptionClass;
	public void deleteS(int id);
	
}
