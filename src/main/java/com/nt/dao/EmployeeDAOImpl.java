package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String query="select * from employee";
	private static final String query1="insert into employee values(?,?,?,?) ";
	private static final String query2="delete from employee where eno = ? ";
	private static final String query3="select eno,ename,addr,email  from employee where eno = ? ";
	private static final String query4="update employee set ename = ?,addr = ?,email=? where eno=? ";
	
	@Inject
	private JdbcTemplate template;

	
	@Override
	public List<Employee> getAllEmployee() {
		
          return template.query(query,new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp=new Employee();
				emp.setId(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setAddr(rs.getString(3));
				emp.setEmail(rs.getString(4));
				return emp;
			}
		});
	}


	@Override
	public int save(Employee emp) {
		
		return template.update(query1, emp.getId(),emp.getEname(),emp.getAddr(),emp.getEmail());
	}


	@Override
	public int delete(int id) {
		int no=template.update(query2,id);
		return no;
	}


	@Override
	public Employee getByid(int id) {
		return template.queryForObject(query3,new Object[] {id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}


	@Override
	public int updatebyId(Employee emp) {
		
		return template.update(query4, emp.getEname(),emp.getAddr(),emp.getEmail(),emp.getId());
	}


	
}
