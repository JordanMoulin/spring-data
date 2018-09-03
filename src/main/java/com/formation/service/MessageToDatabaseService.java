package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MessageToDatabaseService implements MessageService {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	// ecrire le message dans la bdd
	public void send(Message message) {
		this.jdbc.update("insert into message (id, fromUser, toUser, content, event_time) values (?,?,?,?,?)",
				message.getId(), message.getFromUser(), message.getToUser(), message.getContent(),
				message.getEventTime());
	}

	@Override
	// modifier le message dans la bdd
	public void edit(Message editedMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	// supprimer le message dans la bdd
	public void delete(String fromUser, String toUserc) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAllMessages() {
		// List<Feedback> feedbacks = jdbc.query("Select * From feedback",
		// rowMapper)
		// this.jdbc.queryForObject("Select * From feedback", Feedback.class);
		return null;
	}

	@Override
	public List<Message> findMessageSendToAUserADay(String toUser, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAllMessageFromUser(String fromUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

}
