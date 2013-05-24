package br.com.victor.crudexample.service.impl.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.AbstractEntity;
import br.com.victor.crudexample.service.contract.BusinessCrudContract;
import br.com.victor.crudexample.service.contract.EntityExistsException;
import br.com.victor.crudexample.service.contract.EntityNotExistException;

public abstract class AbstractCrudService<T extends AbstractEntity> implements
		BusinessCrudContract<T> {

	private JpaRepository<T, Long> repository;

	protected JpaRepository<T, Long> getRepository() {
		return repository;
	}

	public AbstractCrudService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void save(T entity) throws EntityExistsException {
		repository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void delete(T entity) throws EntityNotExistException {
		repository.delete(entity);
	}
	
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void update(T entity) throws EntityNotExistException {
		repository.save(entity);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> list() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public T get(T entity) throws EntityNotExistException {
		return repository.findOne(entity.getId());
	}
}
