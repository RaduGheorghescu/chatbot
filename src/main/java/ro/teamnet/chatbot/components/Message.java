package ro.teamnet.chatbot.components;

import org.springframework.stereotype.Component;

public class Message {
    private String author;
    private String content;

    public Message() {
    }

    public Message(String author) {
        this.author = author;
    }

    public Message(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
