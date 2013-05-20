package br.com.victor.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.service.contract.DepartmentServiceContract;
import br.com.victor.crudexample.service.contract.EntityNotExistException;


@Controller
public class DepartmentController {

	private static final String REQUEST_ROOT = "/department";
	
	private DepartmentServiceContract departmentService;

	@Autowired
	public DepartmentController(DepartmentServiceContract departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value = REQUEST_ROOT, method = RequestMethod.GET, 
			produces = "application/json")
	@ResponseBody
	public List<Department> list()
	{
		return departmentService.list();
	}

	@RequestMapping(value = REQUEST_ROOT + "/listDepartmentWithoutEmployees", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Department> listDepartmentWithoutEmployees()
	{
		return departmentService.listDepartmentWithoutEmployee();
	}

	@RequestMapping(value = REQUEST_ROOT + "/{id}", 
			method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable String id) throws EntityNotExistException
	{
		Department department = new Department();
		department.setId(Long.parseLong(id));
		
		if(department == null)
			return;
		departmentService.delete(department);
	}
}
