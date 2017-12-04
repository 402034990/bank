package com.taketicket.server.services.impl;

import java.util.List;

import com.taketicket.entity.Manager;
import com.taketicket.server.services.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public int insertManager(Manager manager) {

		return 0;
	}

	@Override
	public int deleteManagerByAccount(String account) {

		return 0;
	}

	@Override
	public int deleteManagerByName(String name) {

		return 0;
	}

	@Override
	public int updatePasswordByAccount(Manager manager) {

		return 0;
	}

	@Override
	public Manager queryByAccount(String account) {

		return null;
	}

	@Override
	public Manager queryByName(String name) {

		return null;
	}

	@Override
	public List<Manager> queryAll() {

		return null;
	}

	@Override
	public int updateDisabledByaccount(Manager manager) {

		return 0;
	}

}
