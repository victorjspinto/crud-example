package br.com.victor.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.service.contract.DepartmentServiceContract;


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
	public List<Department> list()
	{
		return departmentService.list();
	}

	@RequestMapping(value = REQUEST_ROOT + "/listDepartmentWithoutEmployees", 
			method = RequestMethod.GET, produces = "application/json")
	public List<Department> listDepartmentWithoutEmployees()
	{
		return departmentService.listDepartmentWithoutEmployee();
	}

	@RequestMapping(value = REQUEST_ROOT + "/delete/{id}", 
			method = RequestMethod.GET, produces = "application/json")
	public void delete(@PathVariable String id)
	{
		
	}
}
