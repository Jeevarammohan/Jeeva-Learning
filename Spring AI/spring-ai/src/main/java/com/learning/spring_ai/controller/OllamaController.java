package com.learning.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {

    private final ChatClient chatClient;

    public OllamaController(OllamaChatModel chatModel){
        this.chatClient=ChatClient.create(chatModel);
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        ChatResponse chatResponse = chatClient
                .prompt(message).call().chatResponse();
        System.out.println(chatResponse.getMetadata().getModel());
        return ResponseEntity.ok(chatResponse.getResult().getOutput().getText());
    }
}
