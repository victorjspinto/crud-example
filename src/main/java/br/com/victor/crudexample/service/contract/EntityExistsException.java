package br.com.victor.crudexample.service.contract;

public class EntityExistsException extends Exception {

	public EntityExistsException(String errorMessage)
	{
		super(errorMessage);
	}

	private static final long serialVersionUID = 266990146165485779L;

}
