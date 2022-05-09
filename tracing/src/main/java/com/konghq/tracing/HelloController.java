package com.konghq.tracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private final static String DEFAULT_GREETING = "Hey Buddy";

    @Autowired
    SlowService slowService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${nameService.url}")
    String nameServiceURL;

    @Value("${greetingService.url}")
    String greetingServiceURL;

    @GetMapping("/")
    public String index() {

        try {
            Name name = restTemplate.getForObject(nameServiceURL, Name.class);
            Greeting greeting = restTemplate.getForObject(greetingServiceURL, Greeting.class);
            slowService.doSomething();
            return greeting.getGreeting() + " " + name.getName();
        } catch(RuntimeException e) {
            System.out.println(e);
            return DEFAULT_GREETING;
        }
    }

}
