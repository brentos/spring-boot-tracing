package com.konghq.nameservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/")
    public Name getName() {
        Name name = new Name();
        name.setName("Brent");

        return name;
    }
}
