package com.formation.user;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.service.MessageDto;
import com.formation.service.MessageService;

/**
 * Class to make interactions with the user
 */
@Component
public class ChatConsole {

	private String currentUser;
	private static int id;

	@Autowired
	private MessageService messageService;

	public void sendHelloTo(String toUser) {
		messageService.send(new MessageDto(currentUser, toUser, MessageFormat.format("Hello {0} !", toUser)));
		id++;
	}

	public void sendGoodbyeTo(String toUser) {
		messageService.send(new MessageDto(currentUser, toUser, MessageFormat.format("Goodbye {0} !", toUser)));
		id++;
	}

	public void editMessage(String content, Integer idMessage) {
		// messageService.edit(new MessageDto(idMessage, content));
	}

	public void deleteMessageToUser(String toUser) {
		messageService.delete(currentUser, toUser);
	}

	public List<MessageDto> findAllMessages() {
		return messageService.findAllMessageFromUser("sam");
	}

	public List<MessageDto> findMessageToUserToday(String toUser, LocalDate date) {
		return messageService.findMessageSendToAUserADay(toUser, date);
	}

	public void setFeedbackService(MessageService feedbackService) {
		this.messageService = feedbackService;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

}