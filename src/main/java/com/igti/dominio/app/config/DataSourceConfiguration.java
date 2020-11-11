package com.igti.dominio.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfiguration {
	
	
	@Value("${env.JDBC_URL}")
	private String url;
	
	@Value("${env.JDBC_USER}")
	private String user;
	
	@Value("${env.JPA_JDBC_PASSWORD}")
	private String password;
	
	@Value("${env.JDBC_DRIVER}")
	private String driver;


	@Bean
	public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(driver);
	      dataSource.setUrl(url);
	      dataSource.setUsername(user);
	      dataSource.setPassword(password);
	      return dataSource;
	}

	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	 * LocalContainerEntityManagerFactoryBean em = new
	 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource());
	 * em.setPackagesToScan("com.igti.dominio.app.model");
	 * 
	 * JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * em.setJpaVendorAdapter(vendorAdapter);
	 * em.setJpaProperties(additionalProperties());
	 * 
	 * return em;
	 * 
	 * }
	 */
	 
}