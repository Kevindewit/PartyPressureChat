package com.partypressure.chat.service.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

public class ChatHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(ChatHandler.class);
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.addSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.removeSession(session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }

    private synchronized void addSession(WebSocketSession session) throws Exception {

        if (sessions.isEmpty()) {
            logger.info("Session is empty ... Creating a new one.");
        }

        logger.info("Session added! ID : " + session.getId());
        sessions.put(session.getId(), session);

    }

    private synchronized void removeSession(String sessionId) {

        logger.info("Session removed! ID : " + sessionId);
        sessions.remove(sessionId);

        if (sessions.isEmpty()){
            logger.info("Session is now empty again.");
        }

    }

    private void broadcast(TextMessage message) throws Exception {

        logger.info("New text message : " + message);

        for (ConcurrentHashMap.Entry<String, WebSocketSession> session : sessions.entrySet()){
            session.getValue().sendMessage(message);
        }

    }
}
