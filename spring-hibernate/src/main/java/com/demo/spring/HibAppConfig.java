package com.demo.spring;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
public class HibAppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean lsfb(DataSource ds) { //spring creates session factory and injects in the methods given below - see the parameter of the methods
		LocalSessionFactoryBean lb = new LocalSessionFactoryBean();
		lb.setDataSource(ds);
		lb.setPackagesToScan("com.demo.spring.entity");
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.mariaDBDialect");
		lb.setHibernateProperties(props);
		return lb;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sf) {
		return new HibernateTemplate(sf);
		
	}
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sf) {
		HibernateTransactionManager txm = new HibernateTransactionManager();
		txm.setSessionFactory(sf);
		return txm;
	}

}
