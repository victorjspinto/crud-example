package br.com.victor.crudexample.repository.impl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.entity.Employee;
import br.com.victor.crudexample.service.contract.EntityExistsException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-infrastructureContext.xml"})
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository; 
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test()
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void ListDepartmentWithoutEmployee() throws EntityExistsException 
	{
		Department departmentWithEmployee = new Department();
		Employee departmentEmployee = new Employee();
		Department departmentWithoutEmployee = new Department();
		
		
		departmentWithEmployee.setName("departmentWithEmployee");
		
		departmentRepository.save(departmentWithEmployee);
		
		departmentEmployee.setName("department employee");
		departmentEmployee.setDepartment(departmentWithEmployee);
		
		employeeRepository.save(departmentEmployee);
		
		
		departmentWithoutEmployee.setName("DeparmentWithoutEmployee");
		
		departmentRepository.save(departmentWithoutEmployee);
		
		Assert.assertTrue(departmentRepository.listDepartmentWithoutEmployee().size() > 0);
	}
}
