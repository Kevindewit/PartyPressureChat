package com.partypressure.chat.app;

import com.partypressure.chat.app.Workflow.ChatHandler;
import com.partypressure.chat.app.Workflow.ChatSession;
import com.partypressure.chat.app.models.ChatMessage;
import com.partypressure.chat.app.models.ChatParticipant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@SpringBootApplication
public class ChatClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChatClientApplication.class, args);

		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		stompClient.setTaskScheduler(new ConcurrentTaskScheduler());
		StompSessionHandler handler = new ChatHandler();
		stompClient.connect("ws://localhost:8080/user/queue/reply", handler);

		ChatSession session = new ChatSession();
		ChatMessage message = new ChatMessage(new ChatParticipant("user"), "This is a test message.");
		session.send("user", message);

	}
}
