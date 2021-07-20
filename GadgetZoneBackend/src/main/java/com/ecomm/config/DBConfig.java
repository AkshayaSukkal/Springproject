package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.entity.Category;
import com.ecomm.entity.Supplier;
import com.ecomm.entity.UserDetail;

@Configuration
@EnableTransactionManagement 
@ComponentScan("com.ecomm")
public class DBConfig 
{
	//DataSource Bean
	@Bean(name="dataSource")
	public DataSource getMySQLDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/springproject1");
		dataSource.setUsername("root");
		dataSource.setPassword("@diarymilksilk2653");
		System.out.println("=-=-=-=-=-=-=-=-=Data Source Bean Created=-=-=-=-=-=-=-=-=");
		return dataSource;
	}
	
	//SessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp = new Properties();
		hibernateProp.put("hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getMySQLDataSource());
		
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
		
		SessionFactory sessionFactory = factoryBuilder.buildSessionFactory();
		
		System.out.println("=-=-=-=-=-=-=-=-=Session Factory Bean Created=-=-=-=-=-=-=-=-=");

		return sessionFactory;
	}
		
	//HibernateTransaction Bean
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory)
	{
		System.out.println("=-=-=-=-=-=-=-=-=Hibernate Transaction Bean Created=-=-=-=-=-=-=-=-=");

		return new HibernateTransactionManager(sessionFactory);
	}
}
