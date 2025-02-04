package com.elfn.ollamasample;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AnswerAnyThingController {

	private final OllamaService service;

    public AnswerAnyThingController(OllamaService chatService) {
        this.service = chatService;
    }

    @GetMapping("/showAskAnything")
    public String showAskAnything() {
         return "askAnything";
    }

    @PostMapping("/askAnything")
    public String askAnything(@RequestParam("question") String question, Model model) {
       ChatResponse answer = service.genarateAnswer(question);
        System.out.println(answer);
       model.addAttribute("question", question);
       model.addAttribute("answer", answer.getResult().getOutput().getContent());
        return "askAnything";
    }
}
