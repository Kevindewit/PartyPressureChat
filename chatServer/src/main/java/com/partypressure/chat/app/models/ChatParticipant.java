package com.partypressure.chat.app.models;

public class ChatParticipant {

    private String username;

    public ChatParticipant(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
