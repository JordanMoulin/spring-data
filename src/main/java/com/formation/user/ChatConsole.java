package com.formation.user;

import java.text.MessageFormat;
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

	public void sendHelloTo(String toUser) {
		feedbackService.send(new Message(1, currentUser, toUser, MessageFormat.format("Hello {0} !", toUser)));
	}

	public void sendGoodbyeTo(String toUser) {
		feedbackService.send(new Message(2, currentUser, toUser, MessageFormat.format("Goodbye {0} !", toUser)));
	}

	// met à jour un bonjour existant par le message "Big Up !"
	public void editMessage(String content, Integer idMessage) {

	}

	// Supprime tous les feedbacks avec un utilisateur
	public void deleteMessageToUser(String toUser) {

	}

	// Récupère tous les feedbacks du jour pour un user
	public List<Message> findMessageToUserToday(String toUser) {

		return null;
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