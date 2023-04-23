package com.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employees.Employee;
import com.exception.ExceptionClass;

public class EmployeeDBO implements EmployeeImpl{

	
		public static final String insertQ="insert into employee(id,name,jobrole) values(?,?,?)";
		public static final String updateQ="update employee set name=?,jobrole=? where id=?";
		public static final String deleteQ="delete * from employee where id=?";
		public static final String selectQ="select * from employee";
	@Override
	public void deleteQ(int empid) throws ExceptionClass {
		try(Connection con=Connected.connect()){
			PreparedStatement pst = con.prepareStatement(deleteQ); 
				pst.setInt(1,empid);
				pst.executeUpdate();
		} 
		
		catch (SQLException e) {
			throw new ExceptionClass("Error occured at the time of Deletion");
		}
		
	}

	@Override
	public void updateQ(Employee emp) throws ExceptionClass {
		try(Connection con=Connected.connect()){
			PreparedStatement pst = con.prepareStatement(updateQ); 
				pst.setInt(3,emp.getId());
				pst.setString(1,emp.getName());
				pst.setString(2,emp.getJobrole());
				pst.executeUpdate();
		} 
		
		catch (SQLException e) {
			throw new ExceptionClass("Error occured at the time of Updation");
		}
		
		
	}

	@Override
	public void addQ(Employee emp) throws ExceptionClass {
		try(Connection con=Connected.connect()){
			PreparedStatement pst = con.prepareStatement(insertQ); 
				pst.setInt(1, emp.getId());
				pst.setString(2, emp.getName());
				pst.setString(3, emp.getJobrole());
				pst.executeUpdate();
		} 
		
		catch (SQLException e) {
			throw new ExceptionClass("Error occured at the time of Inserting Data");
		}
		
	}

	@Override
	public List<Employee> allList() throws ExceptionClass {
		try(Connection con=Connected.connect()){
			PreparedStatement pst = con.prepareStatement(selectQ); 
				ResultSet rs=pst.executeQuery();
				List<Employee> ls=new ArrayList<Employee>();
				while(rs.next()) {
					Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
					ls.add(e);
				}
				return ls;
		} 
		
		catch (SQLException e) {
			throw new ExceptionClass("Error occured at the time of Inserting Data");
		}
	}

}
