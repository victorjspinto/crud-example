package br.com.victor.crudexample.repository.impl.base;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.victor.crudexample.entity.AbstractEntity;
import br.com.victor.crudexample.repository.contract.RepositoryCrudContract;
import br.com.victor.crudexample.service.contract.EntityExistsException;
import br.com.victor.crudexample.service.contract.EntityNotExistException;

public abstract class AbstractCrudRepository<T extends AbstractEntity>
		implements RepositoryCrudContract<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entity;

	public AbstractCrudRepository(Class<T> entity) {
		this.entity = entity;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T data) throws EntityExistsException {
		try {
			getSession().save(data);
		} catch (ConstraintViolationException ex) {
			throw new EntityExistsException("Data already exist in database.");
		}
	}

	@Override
	public void update(T data) throws EntityNotExistException {
		if(data.getId() == null)
			throw new EntityNotExistException("Cannot update new data");
		
		getSession().update(data);

	}

	@Override
	public void delete(T data) {
		getSession().delete(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return Collections.unmodifiableList(getSession().createCriteria(entity)
				.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(long id) {
		return ((T) getSession().get(entity, id));
	}
}
