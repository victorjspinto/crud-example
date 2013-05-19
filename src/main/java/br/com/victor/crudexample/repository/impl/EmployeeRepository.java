package br.com.victor.crudexample.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.victor.crudexample.entity.Employee;
import br.com.victor.crudexample.repository.contract.EmployeeRepositoryContract;
import br.com.victor.crudexample.repository.impl.base.AbstractCrudRepository;

@Repository
public class EmployeeRepository extends AbstractCrudRepository<Employee>
		implements EmployeeRepositoryContract {

	public EmployeeRepository() {
		super(Employee.class);
	}
}
