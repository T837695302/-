package com.pro.dao;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pro.bean.Pro;
import com.pro.mapper.ProMapper;

public class ProDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 貨物情報リストを取得する.
	 *
	 * @return
	 */
	public List<Pro> queryAll() {

		String sql = "select id,name,weight from pro";
		return jdbcTemplate.query(sql, new ProMapper());
	}
}

