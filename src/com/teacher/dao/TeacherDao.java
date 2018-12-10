package com.teacher.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.teacher.bean.Teacher;
import com.teacher.mapper.TeacherMapper;

public class TeacherDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 先生情報リストを取得する.
	 *
	 * @return
	 */
	public List<Teacher> queryAll() {

		String sql = "select id,name,course from teacher";
		return jdbcTemplate.query(sql, new TeacherMapper());
	}
}
