package com.example.SpringBootDemo;
import object.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Member> selectAll () 
	{
		List<Member> results = jdbcTemplate.query("select * from MEMBER",
			(ResultSet rs, int rowNum) -> 
			{
				Member member = new Member( 
						rs.getString("member_ID"),
						rs.getString("member_PW"),
						rs.getString("member_role"),
						rs.getString("member_name"),
						rs.getString("member_address"),
						rs.getString("member_phone"),
						rs.getTimestamp("member_datetime").toLocalDateTime());
				return member;
			});
		return results;
	}
	public List<Member> selectListAll (String ID)
	{
		List<Member> results = jdbcTemplate.query("select * from MEMBER where member_ID = ?",
				(ResultSet rs, int rowNum) -> 
				{
					Member member = new Member( 
							rs.getString("member_ID"),
							rs.getString("member_PW"),
							rs.getString("member_role"),
							rs.getString("member_name"),
							rs.getString("member_address"),
							rs.getString("member_phone"),
							rs.getTimestamp("member_datetime").toLocalDateTime());
					return member;
				},ID);
		return results;
	}
	public void insert (String iD, String pW, String role, String name, String address, String phone)
	{
		LocalDateTime now = LocalDateTime.now();
		jdbcTemplate.update("insert into MEMBER (member_ID, member_PW, member_role, member_name,"
				+ "member_address, member_phone, member_datetime) values(?,?,?,?,?,?,?)",
				iD, pW, role, name, address, phone, Timestamp.valueOf(now));
	}
	public void update (String iD, String pW, String name, String address, String phone)
	{
		jdbcTemplate.update("update MEMBER set member_PW = ?, member_name = ?, member_address = ?, "
				+ "member_phone = ? where member_ID = ?",
				pW, name, address, phone, iD);
	}
	public void deleteById(String member_ID)
	{
		jdbcTemplate.update("delete FROM MEMBER where member_ID = ?",member_ID);
	}
	public Member login (String ID, String PW)
	{
		List<Member> results = jdbcTemplate.query("select * from MEMBER where MEMBER_ID = ? and MEMBER_PW = ? ",
			(ResultSet rs, int rowNum) -> 
			{
				Member member = new Member( 
						rs.getString("member_ID"),
						rs.getString("member_PW"),
						rs.getString("member_role"),
						rs.getString("member_name"),
						rs.getString("member_address"),
						rs.getString("member_phone"),
						rs.getTimestamp("member_datetime").toLocalDateTime());
				return member;
			}, ID, PW);
		return results.isEmpty() ? null : results.get(0);
	}
	//중복 검사
	public boolean is_ID_overlap(String ID)
	{
		List<Member> results = jdbcTemplate.query("select * from MEMBER where MEMBER_ID = ?",
				(ResultSet rs, int rowNum) -> 
				{
					Member member = new Member( 
							rs.getString("member_ID"),
							rs.getString("member_PW"),
							rs.getString("member_role"),
							rs.getString("member_name"),
							rs.getString("member_address"),
							rs.getString("member_phone"),
							rs.getTimestamp("member_datetime").toLocalDateTime());
					return member;
				}, ID);
			return results.isEmpty() ? false : true;
	}
	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
}