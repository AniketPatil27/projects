package com.harman.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.entity.Employee;
import com.harman.exception.ExceptionClass;
import com.harman.service.EmpService;
import com.harman.service.EmpServiceImpl;

@WebServlet({"/"})
public class ControllerS extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EmpService emps;
	public void init() {
		emps=new EmpServiceImpl();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request,response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String action="";
			switch(action) {
				case "/add":
				{
					addI(request,response);
					break;
				}
				case "/edit":
				{
					editI(request,response);
					break;
				}
				case "/delete":
				{
					deleteI(request,response);
					break;
				}
				default :
				{
					listI(request,response);
					break;
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	private void listI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> emp=new ArrayList<>();
		emp=emps.getEmpS();
		request.setAttribute("employee",emp);	
		RequestDispatcher rs=request.getRequestDispatcher("list.jsp");
		rs.forward(request, response);
	}
	
	private void deleteI(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		emps.deleteS(id);
		response.sendRedirect("list.jsp");
	}
	
	private void editI(HttpServletRequest request, HttpServletResponse response) throws ExceptionClass, IOException {
		Employee e=new Employee();
		e.setName(request.getParameter("name"));
		e.setId(Integer.parseInt(request.getParameter("id")));
		e.setSalary(Double.parseDouble(request.getParameter("salary")));
		emps.updateS(e);
		response.sendRedirect("list.jsp");
	}
	
	private void addI(HttpServletRequest request, HttpServletResponse response) throws ExceptionClass, IOException {
		Employee e=new Employee();
		e.setName(request.getParameter("name"));
		e.setId(Integer.parseInt(request.getParameter("id")));
		e.setSalary(Double.parseDouble(request.getParameter("salary")));
		emps.addS(e);
		response.sendRedirect("list.jsp");
	}
	
}
