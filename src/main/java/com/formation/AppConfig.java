package com.formation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formation.service.FeedbackToDatabaseService;
import com.formation.service.IFeedback;
import com.formation.user.UserInteraction;

import database.ConnexionBdd;

@Configuration
@Import(ConnexionBdd.class)
public class AppConfig {

	DataSource dataSource;

	@Autowired
	public AppConfig(DataSource datasource) {
		this.dataSource = datasource;
	}

	@Bean
	public JdbcTemplate getJDBCTemplate() {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public UserInteraction UserInteraction() {
		return new UserInteraction();
	}

	@Bean
	public IFeedback getFeedbackService() {
		return new FeedbackToDatabaseService();
	}
}
