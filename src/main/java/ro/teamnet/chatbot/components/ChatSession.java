package ro.teamnet.chatbot.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("session")
public class ChatSession {
    private String name;
    private String email;
    private List<Message> messageList;

    public ChatSession() {
        this.messageList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void addToMessageList(Message message) {
        this.messageList.add(message);
    }
}
