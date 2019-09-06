package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee();
	public int save(Employee emp);
	public int delete(int id);
	public Employee getByid(int id);
	public int updatebyId(Employee emp);

}
