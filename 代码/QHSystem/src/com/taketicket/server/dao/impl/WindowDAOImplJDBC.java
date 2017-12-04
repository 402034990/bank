package com.taketicket.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taketicket.constant.MyConstant;
import com.taketicket.entity.Business_WindowVO;
import com.taketicket.entity.Window;
import com.taketicket.server.dao.WindowDAO;
import com.taketicket.server.dao.exception.DAOException;
import com.taketicket.util.jdbc.JDBCTemplate;
import com.taketicket.util.jdbc.RowMapper;

public class WindowDAOImplJDBC implements WindowDAO {

	@Override
	public int insertWindow(Window window) {

		String[] sqls = { "insert into window( num, business_id, disabled) values(?,?,?)" };

		Object[][] properties = { { window.getNum(), window.getBusiness_id(),
				window.getDisabled() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateDisabledByNum(Window window) {

		String[] sqls = { "update window set id = ?, business_id = ? where num = ?" };

		Object[][] properties = { { window.getId(), window.getBusiness_id(),
				window.getNum() } };

		return this.update(sqls, properties);

	}

	@Override
	public int updateDisabledByNum(int num) {

		String[] sqls = { "update window set disabled = ? where num = ?" };

		Object[][] properties = { { MyConstant.DISABLED, num } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateDisabledByBusinessId(int businessId) {

		String[] sqls = { "update window set disabled = ? where business_id = ?" };

		Object[][] properties = { { MyConstant.DISABLED, businessId } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateDisabledByBusinessId(Window window) {

		String[] sqls = { "update window set id = ?, num = ? where business_id= ?" };

		Object[][] properties = { { window.getId(), window.getNum(),
				window.getBusiness_id() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateWindowById(Window window) {

		String[] sqls = { "update window set num = ?,business_id = ?, disabled = ? where id = ?" };

		Object[][] properties = { { window.getNum(), window.getBusiness_id(),
				window.getDisabled(), window.getId() } };

		return this.update(sqls, properties);
	}

	@Override
	public Window queryWindowById(int id) {

		String sql = "select * from window where id = ?";

		Object[] properties = { id };

		List<Window> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Window queryWindowByNum(int num) {

		String sql = "select * from window where num = ?";

		Object[] properties = { num };

		List<Window> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Window queryWindowByBusinessId(int businessId) {

		String sql = "select * from window where business_id = ?";

		Object[] properties = { businessId };

		List<Window> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Window> queryAll() {

		String sql = "select * from window";

		Object[] properties = {};

		return this.query(sql, properties);
	}

	@Override
	public List<Business_WindowVO> queryByBusinessNameForBusinessVO(String name) {

		String sql = "select business.id,window.id, window.num, window.disabled, business.name  from window,business where window.business_id = business.id and business.name = ?";

		Object[] properties = { name };

		return this.queryBusinessVo(sql, properties);
	}

	@Override
	public List<Business_WindowVO> queryByNumForBusinessVO(int num) {

		String sql = "select business.id,window.id, window.num, window.disabled, business.name  from window,business where window.business_id = business.id and window.num = ?";

		Object[] properties = { num };

		return this.queryBusinessVo(sql, properties);
	}

	@Override
	public List<Business_WindowVO> queryAllForBusinessVO() {

		String sql = "select business.id, window.id, window.num, window.disabled, business.name from window,business where window.business_id = business.id";

		Object[] properties = {};

		return this.queryBusinessVo(sql, properties);
	}

	private List<Business_WindowVO> queryBusinessVo(String sql,
			Object[] properties) {
		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Business_WindowVO businessVO = new Business_WindowVO();

						try {

							businessVO.setWindowId(resultSet
									.getInt("window.id"));
							businessVO.setWindowNum(resultSet
									.getInt("window.num"));
							businessVO.setBusinessName(resultSet
									.getString("business.name"));
							businessVO.setWindowDisabled(resultSet
									.getInt("window.disabled"));
							businessVO.setBusinessId(resultSet
									.getInt("business.id"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return businessVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	private List<Window> query(String sql, Object[] properties) {
		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Window window = new Window();

						try {

							window.setId(resultSet.getInt("id"));
							window.setNum(resultSet.getInt("num"));
							window.setBusiness_id(resultSet
									.getInt("business_id"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return window;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	private int update(String[] sqls, Object[][] properties) {

		boolean success = JDBCTemplate.update(sqls, properties);

		if (success) {
			return 1;
		} else {
			return 0;
		}
	}

}
