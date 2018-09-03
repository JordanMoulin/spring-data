package com.formation.service;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {

	void send(Message message);

	void edit(Message editedMsg);

	void delete(String fromUser, String toUser);

	List<Message> findAllMessages();

	List<Message> findMessageSendToAUserADay(String toUser, LocalDate day);

	List<Message> findAllMessageFromUser(String fromUser);
}