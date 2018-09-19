package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;
import com.teacher.bean.Teacher;

public class StudentDao {

	/**
	 * @Fields jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring提供的类
	 *
	 * @param jdbcTemplate
	 *            返回值类型： void
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询所有学生
	 *
	 * @return 返回值类型： List<Student>
	 */
	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age,score from student";
		// MySqlからstudentListを取得
		ArrayList<Student> studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());

		// 学生の1個ずつ取り出す
		// 空teacherMapを生成する
		HashMap<Integer, Student> studentmap = new HashMap<Integer, Student>();
		int i=0;
		for (Student student : studentList) {
			// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
			i = i + 1;
			studentmap.put(i, student);
		}

		for (Student stu : studentmap.values()) {
			// 学生の1個ずつ渡してPrintStudentメソッドを呼び出し、表示処理
			System.out.println(stu);
		}
		 //一番大年上の年齢を印刷
		int maxStudentAge = CalculateMaxAge(studentmap);
		System.out.println("一番年上の年齢:" + maxStudentAge);


		return studentList;
	}
	private static int CalculateMaxAge(HashMap<Integer, Student> studentmap) {
		// TODO 自動生成されたメソッド・スタブ
		int maxStudentAge = 0;
		// foreach（拡張for文）での書き方
		for (Student stu : ((Map<Integer, Student>) studentmap).values()) {
			// 学生の年齢を取り出して、合計する
			if (maxStudentAge < stu.getAge()) {
				maxStudentAge = stu.getAge();
			}

		}
		//学生年齢の最大値を返す
		return maxStudentAge;
	}
	/**
	 * 通过姓名查询
	 *
	 * @param name
	 * @return 返回值类型： List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score  from student where name like '%" + name + "%'";

		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * 添加学生
	 *
	 * @param student
	 * @return 返回值类型： boolean
	 */
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score) values(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}

	/**
	 * 删除学生
	 *
	 * @param id
	 * @return 返回值类型： boolean
	 */
	public boolean deleteStu(Integer id) {

		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 * 更新学生信息
	 *
	 * @param student
	 * @return 返回值类型： boolean
	 */
	public boolean updateStu(Student student) {

		String sql = "update student set name=? ,age=?,birthday = ? ,score = ? where id = ?";
		Object stuObj[] = new Object[] { student.getName(), student.getAge(), student.getBirthday(), student.getScore(),
				student.getId() };

		return jdbcTemplate.update(sql, stuObj) == 1;
	}

	/**
	 * 学生年齢の平均値
	 *
	 * @param Studet
	 *            hashmap return 学生年齢の平均値
	 *
	 */
	private static int averAgeStudent(ArrayList<Student> stuList) {
		int sum = 0;
		// foreach（拡張for文）での書き方
		for (Student stu : stuList) {
			// 学生の年齢を取り出して、合計する
			sum = sum + stu.getAge();
		}
		// 学生年齢の平均値を返す
		return sum / 4;

	}

	/**
	 * 学生の情報を印刷する
	 *
	 * @param Student
	 *            return
	 */
	private static void PrintStudent(Student stu) {
		System.out.println("Age" + stu.getAge());
		System.out.println("Birthday" + stu.getBirthday());
		System.out.println("Name" + stu.getName());
		System.out.println("Score" + stu.getScore());
		System.out.println("Id" + stu.getId());
	}

}
