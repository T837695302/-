package com.teacher.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.student.bean.Teacher;
import com.student.mapper.TeacherMapper;

/**
 *
 * StudentDao クラス
 *
 * @author liu
 *
 */
public class TeacherDao {

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
	public List<Teacher> queryAll() {
		String sql = "select id,teachername,course from teacher";
		// SQLから学生情報を貰う
		ArrayList<Teacher> teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		// teacherdao("StudentListから1番目のStudent対象を取得する" + teacherList1.get(0));
		// System.out.println("StudentListから2番目のStudent対象を取得する" + teacherList1.get(1));
		System.out.println("teacherList:" + teacherList);
		// for (Teacher teacher : teacherList1) {
		// System.out.println(teacher.toString());
		// System.out.println("teachername" + teacher.getTeachername());

		// String sql=""
		return jdbcTemplate.query(sql, new TeacherMapper());
	}

	/**
	 * 名前で検査する
	 *
	 * @param name
	 * @return List<Student>
	 */
	public List<Teacher> queryByName(String teachername) {
		String sql = "select id,teachername,course from teacher where teachername like '%" + teachername + "%'";
		List<Teacher> teacherList = new ArrayList();
		teacherList = jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	/**
	 * 学生を新規する
	 *
	 * @param student
	 * @return boolean
	 */
	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into teacher(id,teachername,course )value(0,?,?)";

		return jdbcTemplate.update(sql, new Object[] { teacher.getTeachername(), teacher.getCourse() },
				new int[] { Types.VARCHAR, Types.VARCHAR }) == 1;
		// new Object[]{X,X,X,X},new int[]{X,X,X,X})==1(基本構成)
		// return jdbcTemplate.update(sql,new Object[] {X,X,X,X },new int[] {X,X,X,X })
		// == 1;
		/**
		 *
		 */

	}

	/**
	 * idで学生を削除する
	 *
	 * @param id
	 * @return boolean
	 */
	public boolean deleteTeacher(Integer id) {
		String sql = "delete from teacher where id=?";
		return jdbcTemplate.update(sql, id) == 1;

	}

	/**
	 * 学生の情報を更新する
	 *
	 * @param student
	 * @return boolean
	 */
	public boolean updateTeacher(Teacher teacher) {
		String sql = "update teacher set teachername=? ,course=? where id=?";

		Object teacherobject[] = new Object[] {  teacher.getTeachername(), teacher.getCourse(), teacher.getId()};

		return jdbcTemplate.update(sql, teacherobject) == 1;
	}

}
