package com.ya.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ya.bean.Ya;

public class YaMapper implements RowMapper<Ya> {
	@Override
	public Ya mapRow(ResultSet resultSet, int arg1) throws SQLException {

		Ya ya = new Ya();
		ya.setId(resultSet.getInt(1));
		ya.setName(resultSet.getString(2));
		ya.setHobby(resultSet.getString(3));
		ya.setHeight(resultSet.getInt(4));
		ya.setWeight(resultSet.getInt(5));

		return ya;
	}
}

