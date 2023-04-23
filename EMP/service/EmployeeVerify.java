package com.service;

import java.util.ArrayList;

import java.util.List;

import com.dbo.EmployeeDBO;
import com.dbo.EmployeeImpl;
import com.employees.Employee;
import com.exception.ExceptionClass;

public class EmployeeVerify implements EmployeeService{
	
	EmployeeImpl eimp;
	public EmployeeVerify(){
		eimp=new EmployeeDBO();
	}

	@Override
	public Employee add(Employee emp) throws ExceptionClass {
		isValidate(emp);
		eimp.addQ(emp);
		return emp;
	}

	@Override
	public Employee save(Employee emp) throws ExceptionClass {
		isValidate(emp);
		eimp.updateQ(emp);
		return null;
	}

	@Override
	public void remove(int empid) throws ExceptionClass {
		isValid(empid);
		eimp.deleteQ(empid);
	}

	@Override
	public List<Employee> listAll() throws ExceptionClass {
		
		return eimp.allList();
	}

	@Override
	public Employee getById(Integer bookCode) throws ExceptionClass {
		
		return null;
	}
	
	public void isValidate(Employee empo)
	{
		 List<String> empl=new ArrayList<>();
		if(!isValid(empo.getId()))
		{
			empl.add("Id is not valid");
		}
		if(!isValid(empo.getName()))
		{
			empl.add("Name is not valid");
		}
		if(!isValid(empo.getJobrole()))
		{
			empl.add("JobRole is not Valid");
		}
		if(!(empl.isEmpty())) {
			System.out.println(empl.toString());
			
		}
	}

	private boolean isValid(String name) {
		return (name!=null) && (name.length()>0) && (name.length()<20);
	}

	private boolean isValid(int id) {
		return id>0;
	}
	
	
}	