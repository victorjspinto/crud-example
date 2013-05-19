package br.com.victor.crudexample.repository.impl;

import static org.junit.Assert.*;

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
import br.com.victor.crudexample.service.contract.EntityNotExistException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-infrastructureContext.xml"})
public class EmployeeRepositoryTest {

	@Autowired
	public EmployeeRepository repository;
	
	@Autowired
	public DepartmentRepository departmentRepository;
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void SaveEmployeeWithoutDepartmentTest() throws EntityExistsException {
		
		Employee employee = new Employee();
		employee.setName("Victor");
		
		//repository.save(employee);
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void SaveEmployeeWithDepartmentTest() throws EntityExistsException {
		
		Employee employee = new Employee();
		
		Department department = new Department();
		department.setName("EmployeeDepartmentName");
		
		departmentRepository.save(department);
		
		employee.setName("EmployeeWithDepartment");
		employee.setDepartment(department);
		
		repository.save(employee);
		
		assertEquals(repository.getById(employee.getId()).getDepartment().getName(), "EmployeeDepartmentName");
	}

	@Test(expected=EntityExistsException.class)
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void SaveExistingEmployeeTest() throws EntityExistsException {
		
		Employee employee = new Employee();
		employee.setName("Victor");
		
		Department testDepartment = new Department();
		testDepartment.setName("TestExistingEmployeeDepartment");
		
		departmentRepository.save(testDepartment);
		
		employee.setDepartment(testDepartment);
		
		repository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setName("Victor");
		employee2.setDepartment(testDepartment);
		
		repository.save(employee2);
	}
	
	@Test()
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void UpdateEmployeeTest() throws EntityExistsException, EntityNotExistException {
		
		Employee employee = new Employee();
		employee.setName("TestUpdate");
		
		Department department = new Department();
		department.setName("UpdateEmployeeDepartment");
		
		departmentRepository.save(department);
		
		employee.setDepartment(department);
		
		repository.save(employee);
		
		Employee recoredEmployee = repository.getById(employee.getId());
		recoredEmployee.setName("TesteNameUpdated");
		
		repository.update(recoredEmployee);
		
		assertEquals(repository.getById(employee.getId()).getName(), "TesteNameUpdated");
	}
	
	@Test(expected=EntityNotExistException.class)
	@Transactional(readOnly=false, propagation=Propagation.SUPPORTS)
	public void TryUpdateNewEmployeeTest() throws EntityNotExistException {
		
		Employee employee = new Employee();
		employee.setName("newEmployee");
		
		repository.update(employee);
	}
}
