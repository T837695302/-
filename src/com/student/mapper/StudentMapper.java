package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

public class StudentMapper implements RowMapper<Student> {

		public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {

			Student student = new Student();
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setBirthday(getStringDate(resultSet.getString(3)));
			student.setAge(resultSet.getInt(4));
			student.setScore(resultSet.getInt(5));
			student.setClassid(resultSet.getInt(6));

			return student;
		}



//		private  String getStringDate(String birthday) {
//
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			Date dateString = new Date();
//			String strRtnDate = "";
//			try {
//				dateString = formatter.parse(birthday);
//				strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			return strRtnDate;
//		}
		private  String getStringDate(String birthday) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateString = new Date();
			String strRtnDate = "";
			try {
				dateString = formatter.parse(birthday);
				strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return strRtnDate;
		}
	}

