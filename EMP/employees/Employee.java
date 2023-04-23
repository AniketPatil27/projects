package com.employees;

import java.io.Serializable;

public class Employee implements Serializable{
	 
	private static final long serialVersionUID = 1L;
		private int id;
	    private String name=null;
	    private String manager=null;
	    private String jobrole=null;
	    
		public Employee(int int1, String string, String string2) {
			this.id=int1;
			this.name=string;
			this.jobrole=string2;
		}
		public Employee() {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public String getJobrole() {
			return jobrole;
		}
		public void setJobrole(String jobrole) {
			this.jobrole = jobrole;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getManager() {
			return manager;
		}
		public void setManager(String manager) {
			this.manager = manager;
		}
		
		@Override
		public String toString() {
			return String.format("empid=%s, name=%s, manager=%s, JobRole=%s", id, name, manager,jobrole);
		}
		
}
