package com.konghq.greetingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public Greeting getGreeting() {
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello");

        return greeting;
    }
}
