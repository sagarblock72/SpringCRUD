package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.nt.controller","com.nt.dao"})
public class AppConfig {
	
	
	@Bean
	public ViewResolver viewresolver() {
		InternalResourceViewResolver view =null;
		view =new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/pages/");
		view.setSuffix(".jsp");
		return view;
	}
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("system");
		datasource.setPassword("manager");
		return datasource;
	}
	
	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(getDataSource());
	}

}
