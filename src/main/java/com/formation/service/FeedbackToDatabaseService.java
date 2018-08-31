package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FeedbackToDatabaseService implements IFeedback {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	// ecrire le message dans la bdd
	public void say(Feedback newFeedback) {
		this.jdbc.update("insert into feedback (id, user, message, event_time) values (?,?,?,?)", newFeedback.getId(),
				newFeedback.getUser(), newFeedback.getMessage(), newFeedback.getEvent_time());
	}

	@Override
	// modifier le message dans la bdd
	public void amend(Feedback updatedFeedback) {
		// TODO Auto-generated method stub

	}

	@Override
	// supprimer le message dans la bdd
	public void unSayTo(String user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Feedback> tellMeAll() {
		// List<Feedback> feedbacks = jdbc.query("Select * From feedback",
		// rowMapper)
		// this.jdbc.queryForObject("Select * From feedback", Feedback.class);
		return null;
	}

	@Override
	public List<Feedback> tellMeWhatWasSaidToHimThisDay(String user, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> listAllFeedbackWith(String user) {
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
