package br.com.victor.crudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.crudexample.entity.Employee;

public interface EmployeeRepositoryContract extends JpaRepository<Employee, Long> {

}
