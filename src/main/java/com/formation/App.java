package com.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.user.ChatConsole;

public class App {
	public static void main(String[] args) {
		String toUser = "toto";
		String currentUser = "Jordan";
		String content = "blabla blo";

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ChatConsole interaction = applicationContext.getBean(ChatConsole.class);
		interaction.setCurrentUser(currentUser);

		interaction.findAllMessages();
		// interaction.deleteMessageToUser(toUser);
		//
		// interaction.sendHelloTo(toUser);
		// interaction.sendGoodbyeTo(toUser);
		//
		// interaction.editMessage(content, 2);
		//
		// interaction.findMessageToUserToday(toUser);
	}
}
