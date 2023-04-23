package com.harman.service;

import java.util.ArrayList;
import java.util.List;

import com.harman.dao.EmpDao;
import com.harman.dao.EmpDaoImpl;
import com.harman.entity.Employee;
import com.harman.exception.ExceptionClass;

public class EmpServiceImpl implements EmpService{

	private EmpDao empd;
	public EmpServiceImpl() {
		//defaultConstructor
		empd=new EmpDaoImpl();
	}
	
	private void validateEmp(Employee emp) throws ExceptionClass{
		List<String> errMsgs = new ArrayList<String>();
		
		if(!isValidEmpId(emp.getId())) {
			errMsgs.add("BookCode can not be negative");
		}
		if(!isValidName(emp.getName())) {
			errMsgs.add("Book Title can not be left blank and must be of 4 to 50 chars in length");
		}
		if(!isValidSalary(emp.getSalary())) {
			errMsgs.add("Price can not be negative");
		}
		
		if(!errMsgs.isEmpty()) {
			throw new ExceptionClass(errMsgs.toString());
		}
	}
	
	
	

	private boolean isValidSalary(double salary) {
		return salary>0;
	}

	private boolean isValidName(String name) {
		return ((name==null) || (name.length()>2) || (name.length()<20));
	}

	private boolean isValidEmpId(Integer id) {
		return id>0;
	}

	@Override
	public Employee getByIdS(int id) {
		return empd.getEmp(id);
	}

	@Override
	public List<Employee> getEmpS() {
		return empd.getAllEmp();
	}

	@Override
	public void addS(Employee e) throws ExceptionClass {
		validateEmp(e);
	    empd.saveEmp(e);
	}

	@Override
	public void updateS(Employee e) throws ExceptionClass {
		validateEmp(e);
		empd.updateEmp(e);;
	}

	@Override
	public void deleteS(int id) {
		 empd.deleteEmp(id);;
	}
	

}
