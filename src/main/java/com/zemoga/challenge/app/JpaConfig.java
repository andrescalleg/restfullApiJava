package com.zemoga.challenge.app;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public class JpaConfig {
	private static Logger logger = LoggerFactory.getLogger(JpaConfig.class);

	@Bean
	public DataSource dataSource(){
		try{
			EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
			return databaseBuilder.setType(EmbeddedDatabaseType.H2)
					.addScripts("classpath:db/schema.sql","classpath:db/test-data.sql")
					.build();
		}catch (Exception e){
			logger.error("Cannot create data source",e);
			return null;
		}
	}

	@Bean
	public EntityManagerFactory entityManagerFatory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setPackagesToScan("com.apress.prospring5.ch8.entities");
		entityManagerFactoryBean.setDataSource(dataSource);
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
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.format_sql",true);
		hibernateProperties.put("hibernate.use_sql_comments",true);
		hibernateProperties.put("hibernate.show_sql",true);
		hibernateProperties.put("hibernate.max_fetch_depth",3);
		hibernateProperties.put("hibernate.jdbc.batch_size",10);
		hibernateProperties.put("hibernate.jdbc.fetch_size",50);
		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new JpaTransactionManager(entityManagerFatory(dataSource));
	}
}
