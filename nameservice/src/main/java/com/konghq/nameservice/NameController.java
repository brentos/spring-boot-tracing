package com.konghq.nameservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @Value("${nameService.name}")
    String nameString;

    @GetMapping("/")
    public Name getName() {
        Name name = new Name();
        name.setName(nameString);

        return name;
    }
}
