package com.aaa.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aaa.bean.Aaa;
import com.aaa.mapper.AaaMapper;

public class AaaDao {

	// private static final String name = null;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Aaa> queryAll() {
		String sql = "select id,name,place,weight,line,address from aaa";
		List<Aaa> aList = new ArrayList<Aaa>();
		aList = jdbcTemplate.query(sql, new AaaMapper());
		return aList;
	}


	// public List<Teacher> queryAlltea() {
	// String sql = "select id,name,course from teacher";
	// List<Teacher> teacherList = new ArrayList<Teacher>();
	// teacherList = (List<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
	//
	// return teacherList;
	// }
	public List<Aaa> queryBysname(String name) {
		String sql = "select id,name,place,weight,line,address from aaa where name like '%" + name + "%'";
		List<Aaa> snameList = new ArrayList<Aaa>();
		snameList = (List<Aaa>) jdbcTemplate.query(sql, new AaaMapper());

		return snameList;
	}
	public boolean deleteAaa(Integer id) {
		String sql = "delete from aaa where id =?";
		return jdbcTemplate.update(sql,id)==1;
		}

	public boolean updaAaa(Aaa aaa) {
		String sql = "update aaa set name=? ,place=? ,weight=? ,line=?,address=? where id=? ";
		Object aaaObj[] = new Object[] {
				aaa.getName(), aaa.getPlace(), aaa.getWeight(), aaa.getLine(), aaa.getAddress(),aaa.getId() };
		return jdbcTemplate.update(sql, aaaObj) == 1;
	}
	public boolean addAaa(Aaa aaa) {
		String sql = "insert into aaa(id,name,place,weight,line,address) values(0,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { aaa.getName(), aaa.getPlace(), aaa.getWeight(), aaa.getLine(), aaa.getAddress()},
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,}) == 1;
	}








}
