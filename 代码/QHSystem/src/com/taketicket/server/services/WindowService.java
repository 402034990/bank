package com.taketicket.server.services;

import java.util.List;

import com.taketicket.entity.Business_WindowVO;
import com.taketicket.entity.Window;

public interface WindowService {

	public abstract int insertWindow(Window window);

	public abstract int updateDisabledByNum(Window window);

	public abstract int updateWindowById(Window window);

	public abstract int updateDisabledByBusinessId(Window window);

	public abstract int updateDisabledByNum(int num);

	public abstract Window queryWindowByNum(int num);

	public abstract Window queryWindowByBusinessId(int businessId);

	public abstract List<Window> queryAll();

	public abstract List<Business_WindowVO> queryAllForBusinessVO();

	public abstract List<Business_WindowVO> queryByNumForBusinessVO(int num);

	public abstract List<Business_WindowVO> queryByBusinessNameForBusinessVO(
			String name);

	public abstract int updateDisabledByBusinessId(int businessId);
	
	public abstract Window queryWindowById(int id);

}