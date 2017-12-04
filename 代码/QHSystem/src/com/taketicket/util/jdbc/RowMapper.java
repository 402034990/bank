package com.taketicket.util.jdbc;

import java.sql.ResultSet;

public interface RowMapper {

	public abstract Object mapRow(ResultSet resultSet);
}
