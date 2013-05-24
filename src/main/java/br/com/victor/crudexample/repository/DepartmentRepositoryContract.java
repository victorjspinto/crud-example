package br.com.victor.crudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.victor.crudexample.entity.Department;

public interface DepartmentRepositoryContract extends
		JpaRepository<Department, Long> {
	@Query("from Department department where size(department.employees) = 0")
	public List<Department> listDepartmentWithoutEmployee();
}
