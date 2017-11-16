package ro.teamnet.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.teamnet.chatbot.components.ChatSession;
import ro.teamnet.chatbot.components.Message;

import javax.servlet.http.HttpSession;

@Controller
public class ChatController {
    @GetMapping("/")
    public String botChat(HttpSession session, Model model){
        ChatSession chatSession = (ChatSession) session.getAttribute("chatSession");
        if (chatSession == null){
            return "redirect:/connect";
        }
        model.addAttribute("messages", chatSession.getMessageList());
        model.addAttribute("newMessage", new Message());
        return "chat";
    }

    @PostMapping("/")
    public String newMessage(@ModelAttribute("newMessage") Message newMessage, HttpSession session){
        ChatSession chatSession = (ChatSession) session.getAttribute("chatSession");
        newMessage.setAuthor(chatSession.getName());
        chatSession.addToMessageList(newMessage);
//        Aici logica pentru bot!!
        chatSession.addToMessageList(new Message("Tampi", "Nu te inteleg! Eu sunt Tampi!!"));
//        ----
        session.setAttribute("chatSession", chatSession);
        return "chat";
    }

    @GetMapping("/connect")
    public String connectToChat(HttpSession session, Model model){
        ChatSession chatSession = (ChatSession) session.getAttribute("chatSession");
        if (chatSession != null){
            return "redirect:/";
        }
        model.addAttribute("chatSession", new ChatSession());
        return "chatConnect";
    }
    @PostMapping("/connect")
    public String connectToChat(@ModelAttribute("chatSession") ChatSession chatSession, HttpSession session){
        if(chatSession.getEmail() == null || chatSession.getEmail().isEmpty() || chatSession.getName() == null || chatSession.getName().isEmpty()){
            return "redirect:/connect";
        }
        chatSession.addToMessageList(new Message("Tampi","Salut eu sunt botul TAMPI!"));
        session.setAttribute("chatSession", chatSession);
        return "redirect:/";
    }
}
