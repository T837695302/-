package com.student.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {

		Student student = new Student();
		student.setId(resultSet.getInt(1));
		student.setName(resultSet.getString(2));
		student.setBirthday(dateToString(resultSet.getDate(3)));
		student.setAge(resultSet.getInt(4));
		student.setScore(resultSet.getInt(5));
		student.setClassid(resultSet.getInt(6));

		return student;
	}

	/**
	 * 日付から、文字列に変化する.
	 *
	 * @param date 日付.
	 * @return　文字列.
	 */
	private String dateToString(Date date) {

		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat("yyyy/mm/dd").format(date);
		}
		return dateStr;
	}

}
