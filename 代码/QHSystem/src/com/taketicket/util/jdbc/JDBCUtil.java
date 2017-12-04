package com.taketicket.util.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {

	private static DataSource myDataSource = null;

	static {
		try {
			// Class.forName("com.mysql.jdbc.Driver");

			InputStream is = JDBCUtil.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");

			Properties properties = new Properties();
			properties.load(is);

			JDBCUtil.myDataSource = BasicDataSourceFactory
					.createDataSource(properties);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static DataSource getMyDataSource() {

		return JDBCUtil.myDataSource;
	}

	public static Connection getConnection() throws SQLException {

		return JDBCUtil.myDataSource.getConnection();
	}

	public static void free(ResultSet resultSet, Statement statement,
			Connection connection) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			resultSet = null;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				statement = null;
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					connection = null;
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
