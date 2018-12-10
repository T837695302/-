package com.pro.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pro.bean.Pro;

	public class ProMapper implements RowMapper<Pro> {

		@Override
		public Pro mapRow(ResultSet resultSet, int arg1) throws SQLException {
			Pro pro = new Pro();
			pro.setId(resultSet.getInt("id"));
			pro.setName(resultSet.getString("name"));
			pro.setWeight(resultSet.getString("weight"));
			return pro;
		}
	}


