package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate; 

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override 
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		String sqlAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
								 "FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllEmployees);
		
		while (results.next()) {
			Employee employeeResult = mapRowToEmployee(results);
			allEmployees.add(employeeResult);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeesSearched = new ArrayList<>();
		String sqlEmployeesSearched = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
				 					  "FROM employee WHERE first_name ILIKE CONCAT('%', ?, '%') AND last_name ILIKE CONCAT('%', ?, '%')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlEmployeesSearched, firstNameSearch, lastNameSearch);
		
		while (results.next()) {
			Employee employeeResult = mapRowToEmployee(results);
			employeesSearched.add(employeeResult);
		}
		
		return employeesSearched;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employeesSearched = new ArrayList<>();
		String sqlEmployeesSearched = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
				 					  "FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlEmployeesSearched, id);
		
		while (results.next()) {
			Employee employeeResult = mapRowToEmployee(results);
			employeesSearched.add(employeeResult);
		}
		
		return employeesSearched;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeesWithoutProjects = new ArrayList<>();
		String sqlEmployeesWithoutProjects = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
				 					  "FROM employee WHERE employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlEmployeesWithoutProjects);
		
		while (results.next()) {
			Employee employeeResult = mapRowToEmployee(results);
			employeesWithoutProjects.add(employeeResult);
		}
		
		return employeesWithoutProjects;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeesSearched = new ArrayList<>();
		String sqlEmployeesSearched = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, e.birth_date, e.gender, e.hire_date " +
				 					  "FROM employee e JOIN project_employee pe ON e.employee_id = pe.employee_id " +
				 					  "WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlEmployeesSearched, projectId);
		
		while (results.next()) {
			Employee employeeResult = mapRowToEmployee(results);
			employeesSearched.add(employeeResult);
		}
		
		return employeesSearched;
	}
	
	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlUpdateDepartmentAssignment = "UPDATE employee set department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(sqlUpdateDepartmentAssignment, departmentId, employeeId);

	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee specificEmployee = new Employee();
		specificEmployee.setId(results.getLong("employee_id"));
		specificEmployee.setDepartmentId(results.getLong("department_id"));
		specificEmployee.setFirstName(results.getString("first_name"));
		specificEmployee.setLastName(results.getString("last_name"));
		specificEmployee.setBirthDay(results.getDate("birth_date").toLocalDate());
		specificEmployee.setGender(results.getString("gender").charAt(0));
		specificEmployee.setHireDate(results.getDate("hire_date").toLocalDate());
		return specificEmployee;
	}
}
