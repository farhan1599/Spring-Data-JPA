package com.springboot.jpa.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager", basePackages = {
		"com.springboot.jpa.db1.repository" })
public class Db1Config {
	@Primary
	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.db1.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource1") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");

		return builder.dataSource(dataSource).properties(properties).packages("com.springboot.jpa.db1.entity")
				.persistenceUnit("db1").build();

	}

	@Primary
	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
