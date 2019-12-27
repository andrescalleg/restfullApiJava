package com.zemoga.challenge.app;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = {"com.zemoga.challenge"})
public class JpaConfig {
	private static Logger logger = LoggerFactory.getLogger(JpaConfig.class);

	@Bean
	public DataSource getMySQLDataSource() {
		Properties props = new Properties();
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("${spring.datasource.url}");
		mysqlDS.setUser(props.getProperty("${spring.datasource.username}"));
        mysqlDS.setPassword(props.getProperty("${spring.datasource.password}"));
		return mysqlDS;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setPackagesToScan("com.zemoga.challenge");
		entityManagerFactoryBean.setDataSource(getMySQLDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean.getNativeEntityManagerFactory();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.put("hibernate.format_sql",true);
		hibernateProperties.put("hibernate.use_sql_comments",true);
		hibernateProperties.put("hibernate.show_sql",true);
		hibernateProperties.put("hibernate.max_fetch_depth",3);
		hibernateProperties.put("hibernate.jdbc.batch_size",10);
		hibernateProperties.put("hibernate.jdbc.fetch_size",50);
		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager(entityManagerFactory());
	}
}
