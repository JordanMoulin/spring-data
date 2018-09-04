package com.formation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findByFromUser(String fromUser);

	List<Message> findByToUser(String toUser);

	List<Message> findByFromUserAndEventTimeBetween(String fromUser, LocalDateTime date1, LocalDateTime date2);
}
