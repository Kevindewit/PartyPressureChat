package com.partypressure.chat.service.entities;

public class ChatMessage {

    private ChatParticipant author;
    private String message;

    public ChatMessage(ChatParticipant author, String message) {
        this.author = author;
        this.message = message;
    }

    @Override
    public String toString() {
        return  author + " : " + message;
    }

    public ChatParticipant getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
