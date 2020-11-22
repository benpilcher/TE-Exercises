package com.techelevator.projects.model.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOTests extends JDBCBaseDAOTest {

	private JDBCDepartmentDAO depDao;
	private JdbcTemplate jdbc;
	
	@Before
	public void setup () {
		
		depDao = new JDBCDepartmentDAO(dataSource);
		jdbc = new JdbcTemplate(dataSource);
	} 
	
	@Test
	public void get_all_departments_returns_all_departments () {
		
		List<Department> allDepartmentsBefore = depDao.getAllDepartments();
		int allDepartmentsBeforeNumber = allDepartmentsBefore.size();
		
		String sqlInsertDummyDepartment = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Nunya Bizniss') " +
										  "RETURNING department_id";
		jdbc.queryForRowSet(sqlInsertDummyDepartment);
		
		List<Department> allDepartmentsAfter = depDao.getAllDepartments();
		int allDepartmentsAfterNumber = allDepartmentsAfter.size();

		Assert.assertEquals(allDepartmentsBeforeNumber + 1, allDepartmentsAfterNumber);
	}
	
	@Test
	public void search_department_by_name_returns_correct_department () {
		
		String sqlInsertDummyDepartment = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Nunya Bizniss') " +
				  "RETURNING department_id";
		SqlRowSet returningDummyDepartmentId = jdbc.queryForRowSet(sqlInsertDummyDepartment);
		returningDummyDepartmentId.next();
		Long dummyDepartmentId = returningDummyDepartmentId.getLong("department_id");
		
		List<Department> foundDepartments = depDao.searchDepartmentsByName("bizn");
		
		Assert.assertNotNull(foundDepartments);
		Assert.assertEquals(1, foundDepartments.size());
		Assert.assertEquals(dummyDepartmentId, foundDepartments.get(0).getId());
		Assert.assertEquals("Nunya Bizniss", foundDepartments.get(0).getName());
	}
	
	@Test
	public void create_department_adds_department () {
		
		List<Department> allDepartmentsBefore = depDao.getAllDepartments();
		int allDepartmentsBeforeNumber = allDepartmentsBefore.size();
		
		Department dummyDepartment = getDepartment("Nunya Bizniss");
				
		depDao.createDepartment(dummyDepartment);
		
		List<Department> allDepartmentsAfter = depDao.getAllDepartments();
		int allDepartmentsAfterNumber = allDepartmentsAfter.size();

		Assert.assertEquals(allDepartmentsBeforeNumber + 1, allDepartmentsAfterNumber);
		Assert.assertNotNull(dummyDepartment);
		Assert.assertEquals("Nunya Bizniss", dummyDepartment.getName());
	}
	
	@Test
	public void get_department_by_id_returns_correct_department () {
		
		String sqlInsertDummyDepartment = "INSERT INTO department (department_id, name) VALUES (DEFAULT, 'Nunya Bizniss') " +
				  "RETURNING department_id";
		SqlRowSet returningDummyDepartmentId = jdbc.queryForRowSet(sqlInsertDummyDepartment);
		returningDummyDepartmentId.next();
		Long dummyDepartmentId = returningDummyDepartmentId.getLong("department_id");
		
		Department foundDepartment = depDao.getDepartmentById(dummyDepartmentId);
		
		Assert.assertNotNull(foundDepartment);
		Assert.assertEquals(dummyDepartmentId, foundDepartment.getId());
		Assert.assertEquals("Nunya Bizniss", foundDepartment.getName());
	}
	
	private Department getDepartment(String name) {
		
		Department theDepartment = new Department();
		theDepartment.setName(name);
		return theDepartment;  
	}
}
