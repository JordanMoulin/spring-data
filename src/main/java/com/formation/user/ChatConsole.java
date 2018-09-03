package com.formation.user;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.service.Message;
import com.formation.service.MessageService;

/**
 * Class to make interactions with the user
 */
@Component
public class ChatConsole {

	private String currentUser;

	@Autowired
	private MessageService feedbackService;
	private int id;

	public void sendHelloTo(String toUser) {
		feedbackService.send(new Message(id, currentUser, toUser, MessageFormat.format("Hello {0} !", toUser)));
		id++;
	}

	public void sendGoodbyeTo(String toUser) {
		feedbackService.send(new Message(id, currentUser, toUser, MessageFormat.format("Goodbye {0} !", toUser)));
		id++;
	}

	public void editMessage(String content, Integer idMessage) {
		feedbackService.edit(new Message(idMessage, content));
	}

	public void deleteMessageToUser(String toUser) {
		feedbackService.delete(currentUser, toUser);
	}

	public List<Message> findMessageToUserToday(String toUser) {
		return feedbackService.findMessageSendToAUserADay(toUser, LocalDate.now());
	}

	public void setFeedbackService(MessageService feedbackService) {
		this.feedbackService = feedbackService;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

}