package com.dbo;

import java.util.List;

import com.employees.Employee;
import com.exception.ExceptionClass;

public interface EmployeeImpl {

	void deleteQ(int empid) throws ExceptionClass;

	void updateQ(Employee emp) throws ExceptionClass;

	void addQ(Employee emp) throws ExceptionClass;

	List<Employee> allList() throws ExceptionClass;

}
