package br.com.victor.crudexample.service.contract;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.crudexample.entity.AbstractEntity;

public interface BusinessCrudContract<E extends AbstractEntity> {
	public void insert(E entity) throws EntityExistsException;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class,
			propagation = Propagation.REQUIRED)
	public void update(E entity) throws EntityNotExistException;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class,
			propagation = Propagation.REQUIRED)
	public void delete(E entity) throws EntityNotExistException;
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<E> list();
	
	@Transactional(readOnly = true, rollbackFor = Exception.class,
			propagation = Propagation.SUPPORTS)
	public E get(E entity) throws EntityNotExistException;
}
