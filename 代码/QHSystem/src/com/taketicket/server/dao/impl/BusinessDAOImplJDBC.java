package com.taketicket.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taketicket.entity.Business;
import com.taketicket.server.dao.BusinessDAO;
import com.taketicket.server.dao.exception.DAOException;
import com.taketicket.util.jdbc.JDBCTemplate;
import com.taketicket.util.jdbc.RowMapper;

public class BusinessDAOImplJDBC implements BusinessDAO {

	@Override
	public int insertBusiness(Business business) {

		String[] sqls = { "insert into business(code, name, disabled, limitCount) values(?,?,?,?)" };

		Object[][] properties = { { business.getCode(), business.getName(),
				business.getDisabled(), business.getLimitCount() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateDisabledByCode(Business business) {

		String[] sqls = { "update business set disabled = ? where code = ?" };

		Object[][] properties = { { business.getDisabled(), business.getCode() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateDisabledByName(Business business) {

		String[] sqls = { "update business set disabled = ? where name = ?" };

		Object[][] properties = { { business.getDisabled(), business.getName() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateBusinessById(Business business) {

		String[] sqls = { "update business set code = ?, name = ?, disabled = ?, limitCount = ? where id = ?" };

		Object[][] properties = { { business.getCode(), business.getName(),
				business.getDisabled(), business.getLimitCount(),
				business.getId() } };

		return this.update(sqls, properties);
	}

	@Override
	public Business queryByCode(String code) {
		if (code == null || code.trim().length() == 0) {
			return null;
		} else {
			String sql = "select * from business where code = ?";

			Object[] properties = { code };

			List<Business> list = this.query(sql, properties);

			if (list == null || list.size() == 0) {
				return null;
			} else {
				return list.get(0);
			}

		}
	}

	@Override
	public Business queryByName(String name) {

		String sql = "select * from business where name = ?";

		Object[] properties = { name };

		List<Business> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public List<Business> queryAll() {

		String sql = "select * from business ";

		Object[] properties = {};

		return this.query(sql, properties);
	}

	private List<Business> query(String sql, Object[] properties) {
		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Business business = new Business();

						try {

							business.setId(resultSet.getInt("id"));
							business.setCode(resultSet.getString("code"));
							business.setName(resultSet.getString("name"));
							business.setDisabled(resultSet.getInt("disabled"));
							business.setLimitCount(resultSet
									.getInt("limitCount"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return business;
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

	@Override
	public Business queryById(String id) {

		String sql = "select * from business where id = ?";

		Object[] properties = { id };

		List<Business> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

}
