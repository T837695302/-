package com.teacher.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.teacher.bean.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {
	@Override

	public Teacher mapRow(ResultSet resultSet, int arg1) throws SQLException {

		Teacher teacher = new Teacher();
		teacher.setId(resultSet.getInt(1));
		teacher.setName(resultSet.getString(2));
		teacher.setCourse(resultSet.getString(3));
		return teacher;

	}
}
