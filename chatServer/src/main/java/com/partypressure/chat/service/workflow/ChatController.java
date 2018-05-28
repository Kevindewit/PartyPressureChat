package com.partypressure.chat.service.workflow;

import com.partypressure.chat.service.entities.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ChatController {

    Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/chat/{recipient}/{message}", method = RequestMethod.GET)
    public void reply(@PathVariable("recipient") String recipient, @PathVariable("message") ChatMessage message){

        logger.info("New text message : " + message + "\n" + "Recipient : " + recipient);
        simpMessagingTemplate.convertAndSendToUser(recipient, "/queue/reply", message);

    }
}
