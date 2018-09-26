package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 *
 *StudentDao　クラス
 * @author liu
 *
 */
public class StudentDao {

	// @Fields jdbcTemplate
	private JdbcTemplate jdbcTemplate;

	// spring提供的类
	// @param jdbcTemplate
	// 返回值类型： void
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 *すべての学生を検索する
	 * @return　List<Student>
	 */
	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age,score from student";

		List<Student> studentList = new ArrayList();

		studentList = jdbcTemplate.query(sql, new StudentMapper());

		return studentList;
	}

	/**
	 *名前で検査する
	 * @param name
	 * @return　List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score from student where name like '%" + name + "%'";
		List<Student> studentList = new ArrayList();
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}

	/**
	 *学生を新規する
	 * @param student
	 * @return　boolean
	 */
	public boolean AddStudent(Student student) {
		String sql = "insert into student(id,name,birthday,age,score )value(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}

	/**
	 *idで学生を削除する
	 * @param id
	 * @return　boolean
	 */
	public boolean DeleteStudent(Integer id) {
		String sql = "delete from student where id=?";
		return jdbcTemplate.update(sql, id) == 1;

	}

	/**
	 *学生の情報を更新する
	 * @param student
	 * @return　boolean
	 */
	public boolean updateStudent(Student student) {
		String sql = "update student set name=?,birthday=?,age=?,score=? where id=?";

		Object objectStudent[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(),
				student.getScore(), student.getId() };

		return jdbcTemplate.update(sql, objectStudent) == 1;
	}

}
