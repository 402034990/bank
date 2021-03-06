package com.taketicket.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.taketicket.entity.Caller;
import com.taketicket.server.dao.CallerDAO;
import com.taketicket.server.dao.exception.DAOException;
import com.taketicket.util.jdbc.JDBCTemplate;
import com.taketicket.util.jdbc.RowMapper;

public class CallerDAOImplJDBC implements CallerDAO {

	@Override
	public int insertCaller(Caller caller) {

		String[] sqls = { "insert into caller(account, name, password) values(?,?,?)" };

		Object[][] properties = { { caller.getAccount(), caller.getName(),
				caller.getPassword() } };

		return this.update(sqls, properties);
	}

	@Override
	public int deleteCallerByAccount(String account) {

		String[] sqls = { "delete from caller where account = ?" };

		Object[][] properties = { { account } };

		return this.update(sqls, properties);
	}

	@Override
	public int deleteCallerByName(String name) {

		String[] sqls = { "delete from caller where name = ?" };

		Object[][] properties = { { name } };

		return this.update(sqls, properties);
	}

	@Override
	public int updatePasswordByAccount(Caller caller) {

		String[] sqls = { "update caller set password = ? where account = ?" };

		Object[][] properties = { { caller.getPassword(), caller.getAccount() } };

		return this.update(sqls, properties);
	}

	@Override
	public Caller queryByAccount(String account) {

		String sql = "select * from caller where account = ?";

		Object[] properties = { account };

		List<Caller> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Caller> queryByName(String name) {

		String sql = "select * from caller where name = ?";

		Object[] properties = { name };

		List<Caller> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {

			return list;
		}
	}

	@Override
	public List<Caller> queryAll() {

		String sql = "select * from caller";

		Object[] properties = {};

		return this.query(sql, properties);
	}

	private List<Caller> query(String sql, Object[] properties) {
		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Caller caller = new Caller();

						try {

							caller.setId(resultSet.getInt("id"));
							caller.setAccount(resultSet.getString("account"));
							caller.setName(resultSet.getString("name"));
							caller.setPassword(resultSet.getString("password"));
							caller.setDisabled(resultSet.getInt("disabled"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return caller;
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
	public int updateDisabledByAccount(Caller caller) {
		//
		String[] sqls = { "update caller set disabled = ? where account = ?" };

		Object[][] properties = { { caller.getDisabled(), caller.getAccount() } };

		return this.update(sqls, properties);

	}
}
