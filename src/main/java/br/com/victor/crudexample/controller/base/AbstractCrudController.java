package br.com.victor.crudexample.controller.base;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.victor.crudexample.entity.AbstractEntity;
import br.com.victor.crudexample.service.contract.BusinessCrudContract;

@Controller
public abstract class AbstractCrudController<T extends AbstractEntity> {

	public static String getRequestContext()
	{
		return "";
	}
	
	private BusinessCrudContract<T> service;
	
	protected BusinessCrudContract<T> getService() {
		return service;
	}

	public AbstractCrudController(BusinessCrudContract<T> service)
	{
		this.service = service;
	}
	
}
