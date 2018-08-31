package com.formation.user;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.service.Feedback;
import com.formation.service.IFeedback;

/**
 * Class to make interactions with the user
 */
@Component
public class UserInteraction {

	@Autowired
	private IFeedback feedbackService;

	public void sayHello(String user) {
		feedbackService.say(new Feedback(1, user, MessageFormat.format("Hello {0} !", user)));
	}

	public void sayGoodBye(String user) {
		feedbackService.say(new Feedback(2, user, MessageFormat.format("Goodbye {0} !", user)));
	}

	// met à jour un bonjour existant par le message "Big Up !"
	public void makeABetterHelloTo(String user) {

	}

	// Supprime tous les feedbacks avec un utilisateur
	public void deleteFeedbackWith(String user) {

	}

	// Récupère tous les feedbacks du jour pour un user
	public List<Feedback> listWhatWasSaidToHimToday(String user) {

		return null;
	}

	public void setFeedbackService(IFeedback feedbackService) {
		this.feedbackService = feedbackService;
	}

}