package br.com.victor.crudexample.service.contract;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.Department;

public interface DepartmentServiceContract extends BusinessCrudContract<Department> {
	@Transactional(readOnly = true, rollbackFor = Exception.class,
			propagation = Propagation.SUPPORTS)
	public List<Department> listDepartmentWithoutEmployee();
}
