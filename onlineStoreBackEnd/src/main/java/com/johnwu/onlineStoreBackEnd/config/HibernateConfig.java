package com.johnwu.onlineStoreBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//here we are using hibernate version 5, so we need to import version 5 package
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//here we are using hibernate version 5, so we need to import version 5 package
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.johnwu.onlineStoreBackEnd.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	//change the below based on the DBMS you choose
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlinestoredb";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	//datasource bean will be available
	@Bean
	public DataSource getDataSource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;		
	}
	
	//sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder sessionBulider = new LocalSessionFactoryBuilder(dataSource);
		sessionBulider.addProperties(getHibernateProperties());
		//scan all the entities created in the dto package. 
		sessionBulider.scanPackages("com.johnwu.onlineStoreBackEnd.dto");
		return sessionBulider.buildSessionFactory();
	}

	//all the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		//add a property that will create the table for us
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		return properties;
	}
	
	//transactionManager bean is available
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionBulider){
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionBulider);
		return transactionManager;
	}
	
}
