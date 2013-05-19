package br.com.victor.crudexample.repository.contract;

import java.util.List;

import br.com.victor.crudexample.entity.AbstractEntity;
import br.com.victor.crudexample.service.contract.EntityExistsException;
import br.com.victor.crudexample.service.contract.EntityNotExistException;

public interface RepositoryCrudContract<T extends AbstractEntity> {

	public void save(T data) throws EntityExistsException;

	public void update(T data) throws EntityNotExistException;

	public void delete(T data);

	public List<T> list();

	public T getById(long id);
}
