package com.taketicket.server.dao;

import java.util.List;

import com.taketicket.entity.Business;

public interface BusinessDAO {

	public abstract int insertBusiness(Business business);

	public abstract int updateDisabledByCode(Business business);

	public abstract int updateDisabledByName(Business business);

	public abstract int updateBusinessById(Business business);

	public abstract Business queryByCode(String code);

	public abstract Business queryByName(String name);

	public abstract List<Business> queryAll();

	public abstract Business queryById(String id);

}
