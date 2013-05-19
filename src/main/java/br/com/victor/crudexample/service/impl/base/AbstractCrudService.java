package br.com.victor.crudexample.service.impl.base;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.AbstractEntity;
import br.com.victor.crudexample.repository.contract.RepositoryCrudContract;
import br.com.victor.crudexample.service.contract.BusinessCrudContract;
import br.com.victor.crudexample.service.contract.EntityExistsException;
import br.com.victor.crudexample.service.contract.EntityNotExistException;

public abstract class AbstractCrudService<T extends AbstractEntity> implements
		BusinessCrudContract<T> {

	private RepositoryCrudContract<T> repository;

	protected RepositoryCrudContract<T> getRepository() {
		return repository;
	}

	public AbstractCrudService(RepositoryCrudContract<T> repository) {
		this.repository = repository;
	}

	@Override
	public void insert(T entity) throws EntityExistsException {
		repository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void update(T entity) throws EntityNotExistException {
		repository.update(entity);
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void delete(T entity) throws EntityNotExistException {
		repository.delete(entity);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<T> list() {
		return repository.list();
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
	public T get(T entity) throws EntityNotExistException {
		return repository.getById(entity.getId());
	}
}
