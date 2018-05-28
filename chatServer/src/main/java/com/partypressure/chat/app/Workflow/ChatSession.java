package com.partypressure.chat.app.Workflow;

import com.partypressure.chat.app.models.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatSession {

	private String REST_URL = "queue/reply";

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/chat")
	public void send(String recipient, ChatMessage chatMessage) {
		template.convertAndSendToUser(recipient, REST_URL, chatMessage);
	}

}