package com.example.demo;
//package main.java.com.example.demo;

//package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private int randomNumber;

    @PostConstruct
    public void init() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * 100) + 1;
    }

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/game/guess/{number}")
    public String checkGuess(@PathVariable int number) {
        if (number > randomNumber) {
            return "Your guess is too high! Try again.";
        } else if (number < randomNumber) {
            return "Your guess is too low! Try again.";
        } else {
            String response = "You Win! The correct number was " + randomNumber + ". Generating a new number!";
            generateRandomNumber();
            return response;
        }
    }
}

