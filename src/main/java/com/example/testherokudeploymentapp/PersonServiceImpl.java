package com.example.testherokudeploymentapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepo personRepo;

    @Override
    public void createPerson (Person person) {
        Person newPerson = Person.builder()
                .name(person.getName())
                .email(person.getEmail())
                .build();

        personRepo.save(newPerson);
    }
}
