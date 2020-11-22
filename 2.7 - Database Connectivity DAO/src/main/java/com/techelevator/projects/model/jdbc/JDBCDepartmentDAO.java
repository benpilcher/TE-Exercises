package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate; 

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	@Override
	public List<Department> getAllDepartments() {
		List<Department> allDepartments = new ArrayList<>();
		String sqlAllDepartments = "SELECT department_id, name FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllDepartments);
		
		while (results.next()) {
			Department departmentResult = mapRowToDepartment(results);
			allDepartments.add(departmentResult);
		}
		return allDepartments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> departmentsSearched = new ArrayList<>();
		String sqlDepartmentsSearched = "SELECT department_id, name FROM department " +
										"WHERE name ILIKE CONCAT( '%', ?, '%')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDepartmentsSearched, nameSearch);
		
		while (results.next()) {
			Department departmentResult = mapRowToDepartment(results);
			departmentsSearched.add(departmentResult);
		}
		
		return departmentsSearched;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department set name = ? WHERE department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());

	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) VALUES(?, ?)";
		newDepartment.setId(getNextDepartmentId());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		
		return newDepartment; 
	}

	@Override
	public Department getDepartmentById(Long id) {
		String sqlGetDepartment = "SELECT department_id, name FROM department WHERE department_id =?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartment, id);
		if (results.next()) {
			return mapRowToDepartment(results);
		} else {
			return null; 
		}

	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department specificDepartment = new Department();
		specificDepartment.setId(results.getLong("department_id"));
		specificDepartment.setName(results.getString("name"));
		return specificDepartment;
	}

	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
}
