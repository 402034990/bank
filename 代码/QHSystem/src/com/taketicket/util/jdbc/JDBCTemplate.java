package com.taketicket.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {

	public static boolean update(String[] sqls, Object[][] properties) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;

		try {
			connection = JDBCUtil.getConnection();

			connection.setAutoCommit(false);

			for (int i = 0; i < sqls.length; i++) {

				preparedStatement = connection.prepareStatement(sqls[i]);

				for (int j = 0; j < properties[i].length; j++) {
					preparedStatement.setObject(j + 1, properties[i][j]);
				}
				rows += preparedStatement.executeUpdate();
			}

			connection.commit();

		} catch (SQLException e) {
			rows = 0;
			try {
				connection.rollback();
			} catch (SQLException e1) {

				// throw new DAOException(e1.getMessage());
				return false;
			}
			// throw new DAOException(e.getMessage());
			return false;

		} finally {

			JDBCUtil.free(null, preparedStatement, connection);
		}

		if (rows == 0) {
			return false;
		}
		return true;
	}

	public static List<Object> queryByProperties(String sql,
			Object[] properties, RowMapper rowMapper) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object> list = new ArrayList<Object>();

		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < properties.length; i++) {
				preparedStatement.setObject(i + 1, properties[i]);
			}

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(rowMapper.mapRow(resultSet));
			}

		} catch (SQLException e) {

			return null;
			// throw new DAOException(e.getMessage());

		} finally {

			JDBCUtil.free(resultSet, preparedStatement, connection);
		}

		return list;
	}
}
