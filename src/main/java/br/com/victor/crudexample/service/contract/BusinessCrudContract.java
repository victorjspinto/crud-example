package br.com.victor.crudexample.service.contract;

import java.util.List;

import br.com.victor.crudexample.entity.AbstractEntity;

public interface BusinessCrudContract<E extends AbstractEntity> {
	public void save(E entity) throws EntityExistsException;

	public void update(E entity)throws EntityNotExistException;
	
	public void delete(E entity) throws EntityNotExistException;
	
	public List<E> list();
	
	public E get(E entity) throws EntityNotExistException;
}
