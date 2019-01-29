package com.ya.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ya.bean.Ya;
import com.ya.mapper.YaMapper;

public class YaDao {
	// private static final String name = null;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Ya> queryAll(){
		String sql ="select id,name,hobby,height,weight from ya";
		List<Ya> yaallList=new ArrayList<Ya>();
		yaallList=jdbcTemplate.query(sql,new YaMapper());
		return yaallList;
	}
	public List<Ya> queryPageALL(int start,int end) {
		String sql = "select * from ya limit ?,?";
		List<Ya> yaList = new ArrayList<Ya>();
		yaList = jdbcTemplate.query(sql, new Object[]{start,end},new YaMapper());
		return yaList;
	}
	public List<Ya> querybyyaname(String name){
		String sql ="select id,name,hobby,height,weight from ya where name like '%"+name+"%'";
		List<Ya> yanameList = new ArrayList<Ya>();
		yanameList = (List<Ya>) jdbcTemplate.query(sql, new YaMapper());
		return yanameList;
}
	public List<Ya> querybyyaid(int id){
		String sql ="select id,name,hobby,height,weight from ya where id like "+id+"";
		List<Ya> yaidList = new ArrayList<Ya>();
		yaidList = (List<Ya>) jdbcTemplate.query(sql, new YaMapper());
		return yaidList;
	}
	public boolean deleteya(Integer id) {
		String sql = "delete from ya where id =?";
		return jdbcTemplate.update(sql,id)==1;
		}
public boolean addYa(Ya ya) {
	String sql="insert into ya (id,name,hobby,height,weight) values(0,?,?,?,?)";
	return jdbcTemplate.update(sql,
			new Object[]{ ya.getName(), ya.getHobby(), ya.getHeight(),ya.getWeight()},
			new int[]{ Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR}) == 1;

}


}



