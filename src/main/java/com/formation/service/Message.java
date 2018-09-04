package com.formation.service;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String fromUser;
	@Column
	private String toUser;
	@Column
	private String content;
	@Column(name = "event_time")
	private LocalDateTime eventTime;

	public Message() {

	}

	public Message(int id, String content) {
		this.id = id;
		this.content = content;
		this.eventTime = LocalDateTime.now();
	}

	public Message(String fromUser, String toUser, String content) {
		super();
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.eventTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return eventTime + " , fromUser= " + fromUser + ", toUser= " + toUser + ", content= " + content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}
}
