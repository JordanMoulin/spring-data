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
		this.jdbc.update("update message set content = ?, event_time = ? where id = ?", editedMsg.getContent(),
				editedMsg.getEventTime(), editedMsg.getId());
	}

	@Override
	// supprimer le message dans la bdd
	public void delete(String fromUser, String toUser) {
		this.jdbc.update("delete from message where fromUser = ? and toUser = ?", fromUser, toUser);

	}

	@Override
	public List<Message> findAllMessages() {
		String SQL = "select * from message";
		List<Message> messages = jdbc.query(SQL, new MessageMapper<>());
		messages.forEach(e -> {
			System.out.println("object : " + e);
		});
		return messages;
	}

	@Override
	public List<Message> findMessageSendToAUserADay(String toUser, LocalDate day) {
		String SQL = "select * from message where toUser = ? and DATE(event_time) = ?";
		List<Message> messages = jdbc.query(SQL, new Object[] { toUser, day }, new MessageMapper<>());
		messages.forEach(e -> {
			System.out.println("object : " + e);
		});
		return messages;
	}

	@Override
	public List<Message> findAllMessageFromUser(String fromUser) {
		String SQL = "select * from message where fromUser = ?";
		List<Message> messages = jdbc.query(SQL, new Object[] { fromUser }, new MessageMapper<>());
		messages.forEach(e -> {
			System.out.println("object : " + e);
		});
		return messages;
	}

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

}
