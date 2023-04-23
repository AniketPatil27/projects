package com.service;
import java.util.*;

import com.employees.Employee;
import com.exception.ExceptionClass;

public interface EmployeeService {
	
	Employee add(Employee emp) throws ExceptionClass;
	Employee save(Employee emp) throws ExceptionClass;
	void remove(int empid) throws ExceptionClass;
	List<Employee> listAll() throws ExceptionClass;
	Employee getById(Integer bookCode) throws ExceptionClass;
		
}
