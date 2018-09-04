package com.formation.service;

import java.time.LocalDateTime;

public class MessageDto {
	private String fromUser;
	private String toUser;
	private String content;
	private LocalDateTime eventTime;

	public MessageDto() {

	}

	public MessageDto(String content) {
		this.content = content;
		this.eventTime = LocalDateTime.now();
	}

	public MessageDto(String fromUser, String toUser, String content) {
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
