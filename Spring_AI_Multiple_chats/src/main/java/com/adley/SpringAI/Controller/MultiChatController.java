package com.adley.SpringAI.Controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MultiChatController {

//    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;
    ChatClient chatClient;
    @Autowired

    public MultiChatController(
            //@Qualifier("openAiChatClient") ChatClient openAiChatClient,
                          @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {

       // this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }



//    @GetMapping("/openai/chat")
//    public String OpenAiChat(@RequestParam("message") String message) {
//        return openAiChatClient.prompt(message).call().content();
//    }

    @GetMapping("/ollama/chat")
    public String OllamaChat(@RequestParam("message") String message) {
        return ollamaChatClient.prompt(message).call().content();
    }
    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {


        return chatClient
                .prompt()
//                .advisors(new TokenUsageAuditAdvisor())
                .system("""
                        You are an internal IT helpdesk assistant. Your role is to assist
                        employees with IT-related issues such as resetting passwords,
                        unlocking accounts, and answering questions related to IT policies.
                        If a user requests help with anything outside of these
                        responsibilities, respond politely and inform them that you are
                        only able to assist with IT support tasks within your defined scope.
                        """)
                .user(message)
                .call().content();
    }

}


