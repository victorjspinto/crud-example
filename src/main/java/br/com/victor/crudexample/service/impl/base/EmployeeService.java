package br.com.victor.crudexample.service.impl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.crudexample.entity.Employee;
import br.com.victor.crudexample.repository.contract.EmployeeRepositoryContract;
import br.com.victor.crudexample.service.contract.EmployeeServiceContract;

@Service
public class EmployeeService extends AbstractCrudService<Employee> implements
		EmployeeServiceContract {

	@Autowired
	public EmployeeService(EmployeeRepositoryContract repository) {
		super(repository);
	}
}
