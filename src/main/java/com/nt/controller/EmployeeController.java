package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dao.EmployeeDAO;
import com.nt.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO dao;
	
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/getAll")
	public String listAll(Map<String,Object> map) {
		List<Employee> list=dao.getAllEmployee();
		map.put("list", list);
		return "list";
	}
	
	@RequestMapping("add")
	public String onView(Model m) {
		m.addAttribute("cmd", new Employee());
		return "view";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEmployee(@RequestParam("no")int no,@RequestParam("name")String name,@RequestParam("addr")
	                          String addr,@RequestParam("email") String email,Map<String,Object> map) {
		Employee emp=new Employee();
		emp.setId(no);
		emp.setEname(name);
		emp.setAddr(addr);
		emp.setEmail(email);
		
		int count=dao.save(emp);
		String msg=null;
		if(count==1) {
			msg="employee registrered successfully";
		}else {
			msg="employee not registrered successfully";
		}
		map.put("msg", msg);
		return "welcome";
	}
	
	@RequestMapping(value="/deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id,Model map) {
		int no=dao.delete(id);
		String msg=null;
		if(no==1)
			msg="employee deelted successfully";
		else
			msg="not deleted";
		map.addAttribute("msg", msg);
		return "redirect:/getAll";
	}
	
	@PostMapping("/saveagain")
	public String  addNew(@ModelAttribute("cmd") Employee emp,Model map) {
		int count=dao.updatebyId(emp);
		String msg=null;
		if(count==1)
			msg="success";
		else
			msg="failled";
		map.addAttribute("msg", msg);
		return "redirect:/getAll";
	}
	
	@RequestMapping(value="/editemp/{id}")
	public String updateEmployee(@PathVariable int id,Model map) {
		Employee emp=null;
		emp=dao.getByid(id);
		map.addAttribute("cmd", emp);
		return "view";
	}

}
