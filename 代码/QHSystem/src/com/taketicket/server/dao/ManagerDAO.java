package com.taketicket.server.dao;

import java.util.List;

import com.taketicket.entity.Manager;

public interface ManagerDAO {

	public abstract int insertManager(Manager manager);

	public abstract int deleteManagerByAccount(String account);

	public abstract int deleteManagerByName(String name);

	public abstract int updatePasswordByAccount(Manager manager);

	public abstract Manager queryByAccount(String account);

	public abstract Manager queryByName(String name);

	public abstract List<Manager> queryAll();

	public abstract int updateDisabledByaccount(Manager manager);

}
