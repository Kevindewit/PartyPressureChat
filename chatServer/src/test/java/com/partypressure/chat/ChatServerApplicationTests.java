package com.partypressure.chat;

import com.partypressure.chat.service.entities.ChatMessage;
import com.partypressure.chat.service.entities.ChatParticipant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServerApplicationTests {

	//region Fields
	private ChatParticipant		chatParticipant;
	private Class<?> 			chatSession;
	private Class<?> 		 	chatRoom;
	private List<ChatMessage>	chatMessages;
	//endregion

	@Before
	public void init(){

		//todo: initiate fields.
		this.chatParticipant = new ChatParticipant("test");

	}

	@Test (expected = IllegalArgumentException.class)
	public void checkEmptyMessage() {

		ChatMessage chatMessage = new ChatMessage(this.chatParticipant, "");

		Assert.hasText(chatMessage.getMessage());

	}

	@Test
	public void sendMessage() {

		ChatMessage chatMessage = new ChatMessage(this.chatParticipant, "This is a test message.");

		//todo: send message
		assert (true);

	}

}
