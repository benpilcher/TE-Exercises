package com.techelevator.projects.model.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCEmployeeDAOTests extends JDBCBaseDAOTest {
 
	private JDBCEmployeeDAO empDao;
	private JDBCProjectDAO projDao;
	private JdbcTemplate jdbc;
	private Long dummyDepartmentId;
	private Long dummyDepartment2Id;
	private Long dummyProjectId;
	
	@Before
	public void setup () {
		
		empDao = new JDBCEmployeeDAO(dataSource);
		projDao = new JDBCProjectDAO(dataSource);
		jdbc = new JdbcTemplate(dataSource);
		
		String sqlInsertDummyDepartment = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Nunya Bizniss') " +
				  						  "RETURNING department_id";
		SqlRowSet returningDummyDepartmentId = jdbc.queryForRowSet(sqlInsertDummyDepartment);
		returningDummyDepartmentId.next();
		dummyDepartmentId = returningDummyDepartmentId.getLong("department_id");

		String sqlInsertDummyDepartment2 = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Mindya Bizniss') " +
				   "RETURNING department_id";
		SqlRowSet returningDummyDepartment2Id = jdbc.queryForRowSet(sqlInsertDummyDepartment2);
		returningDummyDepartment2Id.next();
		dummyDepartment2Id = returningDummyDepartment2Id.getLong("department_id");
		
		String sqlInsertDummyProject = "INSERT INTO project (project_id, name, from_date, to_date) " + 
									   "VALUES (DEFAULT, 'Cheesecake Project', '2000-12-31', '2030-12-31') " +
									   "RETURNING project_id";
		SqlRowSet returningDummyProjectId = jdbc.queryForRowSet(sqlInsertDummyProject);
		returningDummyProjectId.next();
		dummyProjectId = returningDummyProjectId.getLong("project_id");
	}
	
	@Test
	public void get_all_employees_returns_all_employees () {
		
		List<Employee> allEmployeesBefore = empDao.getAllEmployees();
		int allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
				"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
				"RETURNING employee_id";
		jdbc.queryForRowSet(sqlInsertDummyEmployee);
		
		List<Employee> allEmployeesAfter = empDao.getAllEmployees();
		int allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);

	}
	
	@Test
	public void search_employee_by_name_returns_correct_employee () {
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
										"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
										"RETURNING employee_id";
		SqlRowSet returningDummyEmployeeId = jdbc.queryForRowSet(sqlInsertDummyEmployee);
		returningDummyEmployeeId.next();
		Long dummyEmployeeId = returningDummyEmployeeId.getLong("employee_id");
		
		List<Employee> foundEmployees = empDao.searchEmployeesByName("Dor", "zbo");
		
		Assert.assertNotNull(foundEmployees);
		Assert.assertEquals(1, foundEmployees.size());
		Assert.assertEquals(dummyEmployeeId, foundEmployees.get(0).getId());
		Assert.assertEquals("Dorothy", foundEmployees.get(0).getFirstName());
		Assert.assertEquals("Zbornak", foundEmployees.get(0).getLastName());
	
	}
	
	@Test
	public void get_employees_by_department_id_returns_all_employees_in_department () {
		
		List<Employee> allEmployeesBefore = empDao.getEmployeesByDepartmentId(dummyDepartmentId);
		int allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
										"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
										"RETURNING employee_id";
		jdbc.queryForRowSet(sqlInsertDummyEmployee);
		
		List<Employee> allEmployeesAfter = empDao.getEmployeesByDepartmentId(dummyDepartmentId);
		int allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);
	}
	
	@Test
	public void get_employees_without_projects_returns_correct_employees () {
		
		List<Employee> allEmployeesBefore = empDao.getEmployeesWithoutProjects();
		int allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
										"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
										"RETURNING employee_id";
		jdbc.queryForRowSet(sqlInsertDummyEmployee);
		
		List<Employee> allEmployeesAfter = empDao.getEmployeesWithoutProjects();
		int allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);
	}
	
	@Test
	public void get_employees_by_project_id_returns_correct_employees () {
		
		List<Employee> allEmployeesBefore = empDao.getEmployeesByProjectId(dummyProjectId);
		int allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
										"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
										"RETURNING employee_id";
		SqlRowSet returningDummyEmployeeId = jdbc.queryForRowSet(sqlInsertDummyEmployee);
		returningDummyEmployeeId.next();
		Long dummyEmployeeId = returningDummyEmployeeId.getLong("employee_id");
		
		projDao.addEmployeeToProject(dummyProjectId, dummyEmployeeId);
		
		List<Employee> allEmployeesAfter = empDao.getEmployeesByProjectId(dummyProjectId);
		int allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);
	}
	
	@Test  
	public void change_employee_department_assigns_employee_to_correct_department () {
		
		List<Employee> allEmployeesBefore = empDao.getEmployeesByDepartmentId(dummyDepartmentId);
		int allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		String sqlInsertDummyEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " + 
										"VALUES (DEFAULT, " + dummyDepartmentId + ", 'Dorothy', 'Zbornak', '1930-01-01', 'F', '1950-01-01') " +
										"RETURNING employee_id";
		SqlRowSet returningDummyEmployeeId = jdbc.queryForRowSet(sqlInsertDummyEmployee);
		returningDummyEmployeeId.next();
		Long dummyEmployeeId = returningDummyEmployeeId.getLong("employee_id");
		
		List<Employee> allEmployeesAfter = empDao.getEmployeesByDepartmentId(dummyDepartmentId);
		int allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);
		
		allEmployeesBefore = empDao.getEmployeesByDepartmentId(dummyDepartment2Id);
		allEmployeesBeforeNumber = allEmployeesBefore.size();
		
		empDao.changeEmployeeDepartment(dummyEmployeeId, dummyDepartment2Id);
		
		allEmployeesAfter = empDao.getEmployeesByDepartmentId(dummyDepartment2Id);
		allEmployeesAfterNumber = allEmployeesAfter.size();

		Assert.assertEquals(allEmployeesBeforeNumber + 1, allEmployeesAfterNumber);
		
	}
}
