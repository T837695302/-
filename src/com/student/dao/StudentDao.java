/**
 *
 */
package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;

	}
//select * from student

	public List<Student>queryAll(){
		String sql="select id,name,birthday,age,score from student";
		List<Student>studentList=new ArrayList<Student>();
		studentList=jdbcTemplate.query(sql,new StudentMapper());
		return studentList;
	}


	//学生の名前で捜索する
	public List<Student>queryByName(String name){
		String sql="select id,name,birthday,age,score from student where name like '%" + name + "%'";

		return jdbcTemplate.query(sql,new StudentMapper());
	}

}
