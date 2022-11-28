package com.example.SpringBootDemo;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import object.Product;

public class ProductDao {

	private JdbcTemplate jdbcTemplate;

	public ProductDao(DataSource dataSource) 
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Product> selectAll () {
		List<Product> results = jdbcTemplate.query("select * from PRODUCT",
			(ResultSet rs, int rowNum) -> 
			{
				Product product = new Product( 
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("product_stocks"),
						rs.getTimestamp("product_datetime").toLocalDateTime());
				return product;
			});
			return results;
	}
	public Product selectByID (String product_ID) {
		List<Product> results = jdbcTemplate.query("select * from PRODUCT where PRODUCT_ID = ?",
			(ResultSet rs, int rowNum) -> 
			{
				Product product = new Product( 
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("product_stocks"),
						rs.getTimestamp("product_datetime").toLocalDateTime());
				return product;
			},product_ID);
			return results.isEmpty() ? null : results.get(0);
	}

	public List<Product> selectListByID (String product_ID) {
		List<Product> results = jdbcTemplate.query("select * from PRODUCT where PRODUCT_ID = ?",
			(ResultSet rs, int rowNum) -> 
			{
				Product product = new Product( 
						rs.getString("product_ID"),
						rs.getString("product_name"),
						rs.getString("product_manufacturer"),
						rs.getLong("product_price"),
						rs.getLong("product_stocks"),
						rs.getTimestamp("product_datetime").toLocalDateTime());
				return product;
			},product_ID);
			return results;
	}
	public void insert(String product_ID, String product_name, String manufacturer, long price, long productInStock)
	{
		LocalDateTime now = LocalDateTime.now();
		jdbcTemplate.update("insert into PRODUCT (product_ID, product_name, product_manufacturer, product_price, "
				+ "product_stocks, product_datetime) values(?,?,?,?,?,?)",product_ID, product_name, manufacturer,
				price,productInStock, Timestamp.valueOf(now));
	}
	//제품 수정
	public void updateById(String old_product_ID, String product_ID, String product_name, String manufacturer, 
			long price, long productInStock,LocalDateTime restockDate) 
	{
		jdbcTemplate.update("update PRODUCT set product_ID = ?, product_name = ? , product_manufacturer= ?, "
				+ "product_price = ?, product_stocks = ?, product_datetime = ? where product_ID = ?",
				product_ID,product_name, manufacturer,price,productInStock,Timestamp.valueOf(restockDate),old_product_ID);
	}
	//재입고
	public void restock(String product_ID, long productInStock)
	{
		LocalDateTime now = LocalDateTime.now();
		long sum = selectByID(product_ID).getProductInStock() + productInStock;
		jdbcTemplate.update("update PRODUCT set product_stocks = ?, product_datetime = ? where product_ID = ?",
				sum,Timestamp.valueOf(now),product_ID);
	}
	public void sell(String product_ID, long productInStock)
	{
		long sum = selectByID(product_ID).getProductInStock() - productInStock;
		jdbcTemplate.update("update PRODUCT set product_stocks = ? where product_ID = ?",
				sum,product_ID);
	}
	//환불
	public void refund(String product_ID, long productInStock)
	{
		long sum = selectByID(product_ID).getProductInStock() + productInStock;
		jdbcTemplate.update("update PRODUCT set product_stocks = ? where product_ID = ?",
				sum,product_ID);
	}
	//폐기
	public void deleteById(String product_ID)
	{
		jdbcTemplate.update("delete FROM PRODUCT where product_ID = ?",product_ID);
	}
}