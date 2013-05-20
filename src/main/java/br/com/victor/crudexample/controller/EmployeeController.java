package br.com.victor.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.entity.Employee;
import br.com.victor.crudexample.service.contract.DepartmentServiceContract;
import br.com.victor.crudexample.service.contract.EmployeeServiceContract;
import br.com.victor.crudexample.service.contract.EntityExistsException;
import br.com.victor.crudexample.service.contract.EntityNotExistException;

@Controller
public class EmployeeController {

	private static final String REQUEST_ROOT = "/employee";
	
	private EmployeeServiceContract employeeService;
	
	@Autowired
	public EmployeeController(EmployeeServiceContract employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = REQUEST_ROOT, method = RequestMethod.GET, 
			produces = "application/json")
	@ResponseBody
	public List<Employee> list()
	{
		return employeeService.list();
	}

	@RequestMapping(value = REQUEST_ROOT + "/{id}", 
			method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable String id) throws EntityNotExistException
	{
		Employee employee = new Employee();
		employee.setId(Long.parseLong(id));
		
		employee = employeeService.get(employee);
		
		if(employee == null)
			return;
		
		employeeService.delete(employee);
	}
	
	@RequestMapping(value = REQUEST_ROOT + "/new", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void save(@RequestBody Employee employee) throws EntityExistsException
	{
		employeeService.insert(employee);
	}
	
	@RequestMapping(value = REQUEST_ROOT + "/update", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void update(@RequestBody Employee employee) throws EntityNotExistException
	{
		employeeService.update(employee);
	}
}
