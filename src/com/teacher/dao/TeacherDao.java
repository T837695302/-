package com.teacher.dao;

import java.sql.Types;
import java.util.ArrayList;
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
 *
 * @return
 */
	public List<Teacher> queryAll() {
		String sql = "select id,name,course from teacher";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (List<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());

		return teacherList;
	}
/**
 *
 * @param name
 * @return
 */
	public List<Teacher> queryByname(String name) {
		String sql = "select id,name,course from teacher where name like '%"+name+"%'";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (List<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());

		return teacherList;
	}
	/**
	 *
	 * @param id
	 * @return
	 */
	public List<Teacher> queryByid(int id) {
		String sql = "select id,name,course from teacher where id like "+id+"";
		List<Teacher> teaidList = new ArrayList<Teacher>();
		teaidList = (List<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());

		return teaidList;
	}
	/**
	 *
	 * @param teacher
	 * @return
	 */
	public boolean addTea(Teacher teacher) {
		String sql = "insert into teacher(id,name,course) values(0,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { teacher.getName(), teacher.getCourse()},
				new int[] { Types.VARCHAR, Types.VARCHAR,}) == 1;
	}

	public boolean deleteTea(Integer id) {
		String sql = "delete from teacher where id =?";
		return jdbcTemplate.update(sql,id)==1;
		}


}
