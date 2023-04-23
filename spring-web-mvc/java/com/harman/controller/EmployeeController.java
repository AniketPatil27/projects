package com.harman.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.harman.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public ModelAndView emp() {
		Employee emp=new Employee();
		emp.setLanguage(new String[]{"C++","Java","MySql"});
		emp.setGender("M");
		ModelAndView modelandview=new ModelAndView("home","command",emp);
		return modelandview;
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	   public String addEmp(@ModelAttribute("SpringWeb") Employee emp,ModelMap model) {
	      model.addAttribute("empId", emp.getEmpId());
	      model.addAttribute("name", emp.getName());
	      model.addAttribute("salary", emp.getSalary());
	      model.addAttribute("gender", emp.getGender());
	      model.addAttribute("language", emp.getLanguage());
	      return "emps";
	   }
	   
	   @ModelAttribute("webFrameworkList")
	   public Object[] getWebFrameworkList() {
	      List<String> webFrameworkList = new ArrayList<String>();
	      webFrameworkList.add("Hibernate");
	      webFrameworkList.add("HQL");
	      webFrameworkList.add("Struts 2");
	      webFrameworkList.add("Spring");
	      webFrameworkList.add("C++");
	      webFrameworkList.add("Java");
	      webFrameworkList.add("MySql");
	      return webFrameworkList.toArray();
	   }
}
