package com.harman.dao;

import java.util.List;

import com.harman.entity.Employee;

public interface EmpDao {

	public void saveEmp(Employee user);
	public void updateEmp(Employee user);
	public void deleteEmp(int id);
	public Employee getEmp(int id);
	public List<Employee> getAllEmp();
}
