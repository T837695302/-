package com.teacher.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.teacher.bean.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet resultSet, int arg1) throws SQLException {

		Teacher teacher = new Teacher();
		teacher.setId(resultSet.getInt("id"));
		teacher.setName(resultSet.getString("name"));
		teacher.setCourse(resultSet.getString("course"));

		return teacher;
	}
}

