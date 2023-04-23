package com.ui;

import java.util.List;
import java.util.Scanner;

import com.employees.Employee;
import com.exception.ExceptionClass;
import com.service.EmployeeService;
import com.service.EmployeeVerify;

public class EmployeeChose {
	public static Scanner scan=null;
	private static EmployeeService employeeservice;
	public static void main(String[] args) {
		employeeservice=new EmployeeVerify();
		scan=new Scanner(System.in);
		EmployeeChoice choice=null;
		while(choice!=EmployeeChoice.QUIT)
		{
			System.out.println("Enter Choice: ");
			for(EmployeeChoice ext:EmployeeChoice.values())
			{
				System.out.println(ext.ordinal() +"\t"+ ext);
			}
			System.out.println("Enter Choice");
			
		    int i=scan.nextInt();
			if(i>0 && i<EmployeeChoice.values().length)
			{
				choice = EmployeeChoice.values()[i];
				
				switch (choice)
				{
				case ADD : doAdd();
						   break;
				case LIST: doList();
						   break;
				case DELETE: doDelete();
						     break;
				case QUIT: System.out.println("Application Terminated");
							break;
				}
			 }
		}
	}	
	private static void doAdd() {
		Employee emp = new Employee();
		System.out.print("Enter id : ");
		emp.setId(scan.nextInt());
		System.out.print("Enter name : ");
		emp.setName(scan.nextLine());
		System.out.println("Enter Job Role : ");
		emp.setJobrole(scan.nextLine());
		
		
		try {
			employeeservice.add(emp);
			System.out.println("Employee added succesfully");
		} catch(ExceptionClass excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	private static void doList() {
		try {
			List<Employee> emp1 = employeeservice.listAll();
			if (emp1 == null || emp1.isEmpty()) {
				System.out.println("No Employees found");
			} else {
				for(Employee emp11 : emp1) {
					System.out.println(emp11.getId() + "\t" + emp11.getName() + "\t" + emp11.getJobrole() );
				}
			}
		} catch(ExceptionClass excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	private static void doDelete() {
		System.out.print("Enter employee id:");
		int empid = scan.nextInt();
		try {
			employeeservice.remove(empid);
			System.out.println("Employee detail deleted!");
		} catch(ExceptionClass excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	
	scan.close();
}

	
}