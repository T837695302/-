package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 *
 * StudentDao クラス
 *
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
	 * すべての学生を検索する
	 *
	 * @return List<Student>
	 */
	public List<Student> queryAll() {
		// SQLから学生情報を貰う
		String sql = "select id,name,birthday,age,score,classid from student";
		ArrayList<Student> studentList = new ArrayList<>();
		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
		// StudentListの中の一番目のstudent対象を取得してプリントする
		System.out.println("StudentListから1番目のStudent対象を取得する" + studentList.get(0));
		System.out.println("StudentListから2番目のStudent対象を取得する" + studentList.get(1));

		for (Student stu : studentList) {
			System.out.println(stu.toString());
			System.out.println("score:"+stu.getScore());
		}
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * 名前で検査する
	 *
	 * @param name
	 * @return List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score,classid from student where name like '%" + name + "%'";
		List<Student> studentList = new ArrayList();
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}

	/**
	 * 学生を新規する
	 *
	 * @param student
	 * @return boolean
	 */
	public boolean AddStudent(Student student) {
		String sql = "insert into student(id,name,birthday,age,score,classid )value(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
						student.getClassid() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}

	/**
	 * idで学生を削除する
	 *
	 * @param id
	 * @return boolean
	 */
	public boolean DeleteStudent(Integer id) {
		String sql = "delete from student where id=?";
		return jdbcTemplate.update(sql, id) == 1;

	}

	/**
	 * 学生の情報を更新する
	 *
	 * @param student
	 * @return boolean
	 */
	public boolean updateStudent(Student student) {
		String sql = "update student set name=?,birthday=?,age=?,score=? ,classid=?,where id=?";

		Object objectStudent[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(),
				student.getScore(), student.getClassid(), student.getId() };

		return jdbcTemplate.update(sql, objectStudent) == 1;
	}

}
