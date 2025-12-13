package com.adley.SpringAI.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiChatConfig {

//    @Bean
//    public ChatClient openAiChatClient(
//            OpenAiChatModel OpenAichatModel) {
//        return ChatClient.create(OpenAichatModel);
//    }


    @Bean
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel){
        ChatClient.Builder ChatClientBuilder=ChatClient.builder(ollamaChatModel);

        return ChatClientBuilder.build();

    }
}
