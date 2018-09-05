package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findByFromUser(String fromUser);

	List<Message> findByToUser(String toUser);

	List<Message> findByToUserAndEventTimeBetween(String toUser, LocalDate date1, LocalDate date2);
}
