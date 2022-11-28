package com.example.SpringBootDemo;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import object.*;

public class RecodeDao {
	private JdbcTemplate jdbcTemplate;

	public RecodeDao(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Recode> selectAll () {
		List<Recode> results = jdbcTemplate.query("select * from RECODE",
			(ResultSet rs, int rowNum) -> 
			{
				Recode recode = new Recode(
						rs.getInt("recode_ID"),
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sell_amount"),
						rs.getTimestamp("recode_datetime").toLocalDateTime(),
						rs.getString("recode_type"));
				return recode;
			});
			return results;
	}
	public List<Recode> selectListByID (int recodeID) {
		List<Recode> results = jdbcTemplate.query("select * from RECODE where recode_ID = ?",
			(ResultSet rs, int rowNum) -> 
			{
				Recode recode = new Recode(
						rs.getInt("recode_ID"),
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sell_amount"),
						rs.getTimestamp("recode_datetime").toLocalDateTime(),
						rs.getString("recode_type"));
				return recode;
			}, recodeID);
			return results;
	}
	public Recode selectByID (int recodeID) {
		List<Recode> results = jdbcTemplate.query("select * from RECODE where recode_ID = ?",
			(ResultSet rs, int rowNum) -> 
			{
				Recode recode = new Recode(
						rs.getInt("recode_ID"),
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sell_amount"),
						rs.getTimestamp("recode_datetime").toLocalDateTime(),
						rs.getString("recode_type"));
				return recode;
			}, recodeID);
			return results.isEmpty() ? null : results.get(0);
	}
	//환불제외 데이터
	public List<Recode> selectListByNormal () {
		List<Recode> results = jdbcTemplate.query("select * from RECODE where recode_type = ?",
			(ResultSet rs, int rowNum) -> 
			{
				Recode recode = new Recode(
						rs.getInt("recode_ID"),
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sell_amount"),
						rs.getTimestamp("recode_datetime").toLocalDateTime(),
						rs.getString("recode_type"));
				return recode;
			},"normal");
			return results;
	}
	//데이터 삽입, 제품팔림
	public void insert(String product_ID, String product_name, String manufacturer, long price,
			long amount, String recode_type)

	{
		LocalDateTime now = LocalDateTime.now();
		jdbcTemplate.update("insert into RECODE (recode_ID,product_ID, product_name, product_manufacturer, product_price, "
				+ "sell_amount, recode_datetime, recode_type) values(null,?,?,?,?,?,?,?)",product_ID, product_name, manufacturer,
				price,amount, Timestamp.valueOf(now),recode_type);
	}
	//환불시 업데이트
	public void change_refund(int recodeID) 
	{
		jdbcTemplate.update("update RECODE set recode_type = ? where recode_ID = ?","refund",recodeID);
	}
	//판매량, 총액으로 묶고 정렬1
	public List<SumAmount> groupingbyamount() {
		List<SumAmount> results = jdbcTemplate.query("select product_ID, product_name, product_manufacturer, "
				+ "product_price, SUM(sell_amount) as sum, SUM(sell_amount * product_price) as total  from recode where recode_type = 'normal' "
				+ "Group by product_ID order by sum;",
			(ResultSet rs, int rowNum) -> 
			{
				SumAmount sum = new SumAmount(
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sum"),
						rs.getLong("total"));
				return sum;
			});
			return results;
	}
	//판매량, 총액으로 묶고 정렬2
	public List<SumAmount> groupingbyTotal() {
		List<SumAmount> results = jdbcTemplate.query("select product_ID, product_name, product_manufacturer, "
				+ "product_price, SUM(sell_amount) as sum, SUM(sell_amount * product_price) as total  from recode where recode_type = 'normal'"
				+ "Group by product_ID order by total;",
			(ResultSet rs, int rowNum) -> 
			{
				SumAmount sum = new SumAmount(
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sum"),
						rs.getLong("total"));
				return sum;
			});
			return results;
	}
	//시간순 정렬
	public List<Recode> sortDate() {
		List<Recode> results = jdbcTemplate.query("select * from RECODE where recode_type = 'normal' order by recode_datetime;",
			(ResultSet rs, int rowNum) -> 
			{
				Recode recode = new Recode(
						rs.getInt("recode_ID"),
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("sell_amount"),
						rs.getTimestamp("recode_datetime").toLocalDateTime(),
						rs.getString("recode_type"));
				return recode;
			});
			return results;
	}
	//Recode2로 변환
	public Recode2 toR2(Recode recode)
	{
		String sum = String.valueOf(recode.getAmount() * recode.getPrice());
		
		Recode2 result = new Recode2(String.valueOf(recode.getRecode_ID()), recode.getProduct_ID(), recode.getProduct_name(),
				recode.getManufacturer(), String.valueOf(recode.getPrice()), String.valueOf(recode.getAmount()),sum,
				String.valueOf(recode.getSellingTime()), recode.getRecode_type());
		
		return result;
	}
	//주간 통계
	public List<Recode2> statWeek()
	{
		List<Recode> sortdate = sortDate();
		List<Recode2> result = new ArrayList<Recode2>();
		
		long sum = 0;
		LocalDateTime start = null;
		LocalDateTime end = null;
		for (int i = 0; i < sortdate.size(); i++)
		{
			Recode recode = sortdate.get(i);
			if (i == 0)
			{
				start = recode.getSellingTime();
				end = start.plusWeeks(1);
				sum = recode.getAmount() * recode.getPrice();
				
				String Date = start.toString().substring(0,10) + " ~ " + end.toString().substring(0,10);
				Recode2 recode2 = new Recode2("","","","","","","",Date,"");
				
				result.add(recode2);
				result.add(toR2(recode));
			}
			else
			{
				if(end.compareTo(recode.getSellingTime())>=0)
				{
					sum = sum + recode.getPrice() * recode.getAmount();
					result.add(toR2(recode));
				}
				else
				{
					Recode2 recode2 = new Recode2("","","","","","",String.valueOf(sum),"","");
					System.out.print("sum"+sum);
					result.add(recode2);
					
					
					do
					{
						start = end;
						end = start.plusWeeks(1);
					}while(end.compareTo(recode.getSellingTime())<0);
					sum = recode.getPrice() * recode.getAmount();
					String Date = start.toString().substring(0,10) + " ~ " + end.toString().substring(0,10);
					recode2 = new Recode2("","","","","","","",Date,"");
					
					result.add(recode2);
					result.add(toR2(recode));
				}
			}
		}
		Recode2 recode2 = new Recode2("","","","","","",String.valueOf(sum),"","");
		result.add(recode2);
		System.out.print("sum"+sum);
		
		return result;
	}
	//연간, 월간, 일간 통계
	public List<Recode2> statDate(String date)
	{
		List<Recode> sortdate = sortDate();
		List<Recode2> result = new ArrayList<Recode2>();
		
		
		int index = 10;
		if (date.equals("year"))
		{
			index = 4;
		}
		else if (date.equals("month"))
		{
			index = 7;
		}
		
		long sum = 0;
		String start = null;
		for (int i = 0; i < sortdate.size(); i++)
		{
			Recode recode = sortdate.get(i);
			if (i == 0)
			{
				start = recode.getSellingTime().toString().substring(0,index);
				Recode2 recode2 = new Recode2("","","","","","","",start,"");
				sum = recode.getPrice() * recode.getAmount();
				
				
				result.add(recode2);
				result.add(toR2(recode));
			}
			else
			{
				if(start.equals(recode.getSellingTime().toString().substring(0,index)))
				{
					sum = sum + recode.getPrice() * recode.getAmount();
					result.add(toR2(recode));
				}
				else
				{
					Recode2 recode2 = new Recode2("","","","","","",String.valueOf(sum),"","");
					System.out.print("sum"+sum);
					result.add(recode2);
					
					
					start = recode.getSellingTime().toString().substring(0,index);
					
					sum = recode.getPrice() * recode.getAmount();
					recode2 = new Recode2("","","","","","","",start,"");
					
					result.add(recode2);
					result.add(toR2(recode));
				}
			}
		}
		Recode2 recode2 = new Recode2("","","","","","",String.valueOf(sum),"","");
		result.add(recode2);
		System.out.print("sum"+sum);
		
		return result;
	}
	//객체 출력
	public void printList(List<Recode2> list)
	{
		for(int i=0; i < list.size();i++)
		{
			Recode2 recode = list.get(i);
			System.out.println(recode.toString());
		}
	}
	
}
