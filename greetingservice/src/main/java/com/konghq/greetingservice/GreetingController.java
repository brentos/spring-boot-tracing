package com.konghq.greetingservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${greetingService.greeting}")
    String greetingString;

    @GetMapping("/")
    public Greeting getGreeting() {
        Greeting greeting = new Greeting();
        greeting.setGreeting(greetingString);

        return greeting;
    }
}
