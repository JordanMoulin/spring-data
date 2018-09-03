package com.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.user.ChatConsole;

public class App {
	public static void main(String[] args) {
		String toUser = "Clement";
		String currentUser = "Jordan";

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ChatConsole interaction = applicationContext.getBean(ChatConsole.class);
		interaction.setCurrentUser(currentUser);
		interaction.sendHelloTo(toUser);
		interaction.sendGoodbyeTo(toUser);
	}
}
