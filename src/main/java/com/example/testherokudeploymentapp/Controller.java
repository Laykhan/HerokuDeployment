package com.example.testherokudeploymentapp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PersonService personService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/person")
    public String person(@RequestBody Person person) {
        personService.createPerson(person);
            return "person created!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Worldss!!!!";
    }
}
