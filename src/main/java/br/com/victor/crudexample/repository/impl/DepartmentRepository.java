package br.com.victor.crudexample.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.victor.crudexample.entity.Department;
import br.com.victor.crudexample.repository.contract.DepartmentRepositoryContract;
import br.com.victor.crudexample.repository.impl.base.AbstractCrudRepository;

@Repository
public class DepartmentRepository extends AbstractCrudRepository<Department>
		implements DepartmentRepositoryContract {

	public DepartmentRepository() {
		super(Department.class);
	}

	@SuppressWarnings("unchecked")
	public List<Department> listDepartmentWithoutEmployee() {
		return getSession().createQuery("from Department department where size(department.employees) = 0").list();
	}
}
