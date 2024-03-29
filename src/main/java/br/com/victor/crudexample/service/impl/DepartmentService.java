package br.com.victor.crudexample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.repository.DepartmentRepositoryContract;
import br.com.victor.crudexample.service.contract.DepartmentServiceContract;
import br.com.victor.crudexample.service.impl.base.AbstractCrudService;

@Service
public class DepartmentService extends AbstractCrudService<Department> implements
		DepartmentServiceContract {

	private DepartmentRepositoryContract repository;
	
	@Autowired
	public DepartmentService(DepartmentRepositoryContract repository) {
		super(repository);
		
		this.repository = repository;
	}
	
	@Override
	protected DepartmentRepositoryContract getRepository() {
		return repository;
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
	public List<Department> listDepartmentWithoutEmployee() {
		return getRepository().listDepartmentWithoutEmployee();
	}

}
