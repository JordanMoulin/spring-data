package com.formation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formation.service.MessageToDatabaseService;
import com.formation.service.MessageService;
import com.formation.user.ChatConsole;

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
	public ChatConsole UserInteraction() {
		return new ChatConsole();
	}

	@Bean
	public MessageService getFeedbackService() {
		return new MessageToDatabaseService();
	}
}
