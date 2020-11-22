package com.techelevator.projects.model.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCProjectDAOTests extends JDBCBaseDAOTest {

	private JDBCEmployeeDAO empDao;
	private JDBCProjectDAO projDao;
	private JdbcTemplate jdbc;
	private Long dummyDepartmentId;
	
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

	}
	
	@Test
	public void get_all_active_projects_returns_correct_projects () {
		
		List<Project> allActiveProjectBefore = projDao.getAllActiveProjects();
		int allActiveProjectsBeforeNumber = allActiveProjectBefore.size();
		
		String sqlInsertDummyProject = "INSERT INTO project (project_id, name, from_date, to_date) " + 
									   "VALUES (DEFAULT, 'Cheesecake Project', '2000-12-31', '2030-12-31') " +
									   "RETURNING project_id";
		jdbc.queryForRowSet(sqlInsertDummyProject);
		
		List<Project> allActiveProjectAfter = projDao.getAllActiveProjects();
		int allActiveProjectsAfterNumber = allActiveProjectAfter.size();

		Assert.assertEquals(allActiveProjectsBeforeNumber + 1, allActiveProjectsAfterNumber);

	}
	
	@Test
	public void add_employee_to_project_adds_employee_to_project () {
		
		String sqlInsertDummyProject = "INSERT INTO project (project_id, name, from_date, to_date) " + 
									   "VALUES (DEFAULT, 'Cheesecake Project', '2000-12-31', '2030-12-31') " +
									   "RETURNING project_id";
		SqlRowSet returningDummyProjectId = jdbc.queryForRowSet(sqlInsertDummyProject);
		returningDummyProjectId.next();
		Long dummyProjectId = returningDummyProjectId.getLong("project_id");
		
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
	public void remove_employee_from_project_removes_employee_from_project () {
		
		String sqlInsertDummyProject = "INSERT INTO project (project_id, name, from_date, to_date) " + 
				   "VALUES (DEFAULT, 'Cheesecake Project', '2000-12-31', '2030-12-31') " +
				   "RETURNING project_id";
		SqlRowSet returningDummyProjectId = jdbc.queryForRowSet(sqlInsertDummyProject);
		returningDummyProjectId.next();
		Long dummyProjectId = returningDummyProjectId.getLong("project_id");

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
		
		projDao.removeEmployeeFromProject(dummyProjectId, dummyEmployeeId);
		
		Assert.assertEquals(allEmployeesAfterNumber - 1, allEmployeesBeforeNumber);
		
	} 
	
}
