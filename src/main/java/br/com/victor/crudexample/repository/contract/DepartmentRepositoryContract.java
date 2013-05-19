package br.com.victor.crudexample.repository.contract;

import java.util.List;

import br.com.victor.crudexample.entity.Department;

public interface DepartmentRepositoryContract extends
		RepositoryCrudContract<Department> {
	public List<Department> listDepartmentWithoutEmployee();
}
