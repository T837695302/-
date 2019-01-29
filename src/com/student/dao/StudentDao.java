package com.student.dao;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;


import com.student.bean.Student;

import com.student.mapper.StudentMapper;


public class StudentDao {

		private JdbcTemplate jdbcTemplate;

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age,score,classid from student";
		List<Student> studentList = new ArrayList<Student>();
		studentList =(List<Student>) jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}
	public List<Student> queryByname(String name) {
		String sql = "select id,name,birthday,age,score,classid from student where name like '%"+name+"%'";
		List<Student> nameList = new ArrayList<Student>();
		nameList = (List<Student>) jdbcTemplate.query(sql, new StudentMapper());
		return nameList;
	}
	public List<Student> queryByclassid(int classid) {
		String sql = "select id,name,birthday,age,score,classid from student where classid like "+classid+"" ;
		List<Student> classidList = new ArrayList<Student>();
		classidList = (List<Student>) jdbcTemplate.query(sql, new StudentMapper());

		return classidList;
	}
	public List<Student> queryByid(int id) {
		String sql = "select id,name,birthday,age,score,classid from student where id like "+id+"" ;
		List<Student> idList = new ArrayList<Student>();
		idList = (List<Student>) jdbcTemplate.query(sql, new StudentMapper());
		return idList;
	}
	public boolean deleteStu(Integer id) {
		String sql = "delete from student where id =?";
		return jdbcTemplate.update(sql,id)==1;
		}
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score,classid) values(0,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(),student.getAge(),student.getScore(),student.getClassid()},
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,}) == 1;
	}

	public boolean updateStu(Student student){
		String sql="update student set name=? ,birthday=? ,age=? ,score=? ,classid=? where id=? ";
		Object stuObj[]=new Object[] {
			student.getName(),student.getBirthday(),student.getAge(),student.getScore(),student.getClassid(),student.getId()};
		return jdbcTemplate.update(sql,stuObj)==1;
	}


	public Object addaddressStu(String address) {
		// TODO 自動生成されたメソッド・スタブ
		return "index";
	}
}



//	public List<Student> displayGoodController(){
//		String sql="select id,name,birthday,age,score,classid from student";
//		List<Student> goodList=new ArrayList<Student>();
//		goodList=jdbcTemplate.query(sql, new StudentMapper());
//		double sumScore=0;
//		for(Student stu : goodList) {
//			sumScore=sumScore+stu.getScore();
//		}
//		double averScore=sumScore/goodList.size();
//		List<Student> goodScoreList=new ArrayList<Student>();
//		for(Student stu : goodList) {
//			if(stu.getScore()>averScore) {
//				goodScoreList.add(stu);
//			}
//		}
//		return goodScoreList;
//	}
//
//
//	public List<Student> GokakuStudentController(){
//		String sql="select id,name,birthday,age,score,classid from student";
//		List<Student> GokakustudentList=new ArrayList<Student>();
//		GokakustudentList=jdbcTemplate.query(sql, new StudentMapper());
//		List<Student> passStudentList=new ArrayList<Student>();
//		for(Student stu : GokakustudentList) {
//			if(stu.getScore()>=60) {
//				passStudentList.add(stu);
//			}
//		}
//		return passStudentList;
//	}
//}
//	public Double classAverage(int classid){
//		String sql="select score from student where classid like '%"+classid+"%'";
//		Double classAverScore=new Double<student.score()>();
//		classAverScore=jdbcTemplate.query(sql, new StudentMapper());
//		return classAverScore;
//	}
//}
