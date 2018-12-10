package com.student.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 学生情報リストを取得する.
	 *
	 * @return
	 */
	public List<Student> queryAll() {

		String sql = "select id,name,birthday,age,score,classid from student";
		return jdbcTemplate.query(sql, new StudentMapper());
	}
}