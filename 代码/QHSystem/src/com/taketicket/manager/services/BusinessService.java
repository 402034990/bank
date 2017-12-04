package com.taketicket.manager.services;

import java.util.List;

import com.taketicket.entity.Business;

public interface BusinessService {

	public abstract int insertBusiness(Business business);

	public abstract int updateBusinessByCode(Business business);

	public abstract int updateBusinessByName(Business business);

	public abstract int updateBusinessById(Business business);

	public abstract Business queryByCode(String code);

	public abstract Business queryByName(String name);

	public abstract List<Business> queryAll();

}
