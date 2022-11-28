package com.example.SpringBootDemo;

import java.time.LocalDateTime;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfig 
{
	@Bean(destroyMethod = "close")
	public DataSource dataSource() 
	{
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/posdb?characterEncoding=utf8&serverTimezone=UTC");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	@Bean
	public ProductDao productDao() 
	{
		return new ProductDao(dataSource());
	}
	@Bean
	public MemberDao memberDao() 
	{
		return new MemberDao(dataSource());
	}
	@Bean
	public RecodeDao recodeDao() 
	{
		return new RecodeDao(dataSource());
	}
	@Bean
	public CartDao cartDao() 
	{
		return new CartDao();
	}
}