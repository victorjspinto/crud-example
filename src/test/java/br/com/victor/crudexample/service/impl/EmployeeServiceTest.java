package br.com.victor.crudexample.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.service.contract.DepartmentServiceContract;
import br.com.victor.crudexample.service.contract.EntityExistsException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-infrastructureContext.xml" })
public class EmployeeServiceTest {

	@Autowired
	private DepartmentServiceContract departmentService;

	@Before
	public void setUp()
	{
	}
	
	@Test
	public void test() throws EntityExistsException {
		Department department = new Department();
		department.setName("Almoxarifado");
		departmentService.save(department);
	}

	
	
}
