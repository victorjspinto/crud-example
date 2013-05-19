package br.com.victor.crudexample.service.contract;

public class EntityNotExistException extends Exception {

	public EntityNotExistException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -5402288595650874593L;

}
