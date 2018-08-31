package com.formation.service;

import java.time.LocalDate;
import java.util.List;

public interface IFeedback {

	void say(Feedback newFeedback);

	void amend(Feedback updatedFeedback);

	void unSayTo(String user);

	List<Feedback> tellMeAll();

	List<Feedback> tellMeWhatWasSaidToHimThisDay(String user, LocalDate day);

	List<Feedback> listAllFeedbackWith(String user);
}