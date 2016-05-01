package com.sjsu.cmpe277.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sjsu.cmpe277.util.Constants;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.sjsu.cmpe277" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(Constants.MYSQL_DRIVER);
		driverManagerDataSource.setUrl(Constants.MYSQL_RDS_URI);
		driverManagerDataSource.setUsername(Constants.MYSQL_RDS_USER);
		driverManagerDataSource.setPassword(Constants.MYSQL_RDS_PASSWORD);
		return driverManagerDataSource;
	}
}