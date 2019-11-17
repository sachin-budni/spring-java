package com.org.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public HelloService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String getMessageOne(int id) {
		return this.jdbcTemplate.queryForObject("SELECT message FROM messages where id= ?",new Object[] { id },new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("message");
			}
			
		});
	}
	
//	public String getMessageTwo() {
//		return this.jdbcTemplate.queryForObject("SELECT message FROM messages where id=2",new RowMapper<String>() {
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return rs.getString("message");
//			}
//			
//		});
//	}
//	
//	public String getMessageThree() {
//		return this.jdbcTemplate.queryForObject("SELECT message FROM messages where id=3",new RowMapper<String>() {
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return rs.getString("message");
//			}
//			
//		});
//	}
}
