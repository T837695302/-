package com.aaa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aaa.bean.Aaa;


public class AaaMapper implements RowMapper<Aaa> {

@Override
	public Aaa mapRow(ResultSet resultSet, int arg1) throws SQLException {

		Aaa aaa = new Aaa();
		aaa.setId(resultSet.getInt(1));
		aaa.setName(resultSet.getString(2));
		aaa.setPlace(resultSet.getString(3));
		aaa.setWeight(resultSet.getInt(4));
		aaa.setLine(resultSet.getInt(5));
		aaa.setAddress(resultSet.getString(6));
		return aaa;
	}
}


