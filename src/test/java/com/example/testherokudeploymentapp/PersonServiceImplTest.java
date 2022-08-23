package com.example.testherokudeploymentapp;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PersonServiceImplTest {
    @MockBean
    private PersonRepo personRepo;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    /**
     * Method under test: {@link PersonServiceImpl#createPerson(Person)}
     */
    @Test
    void testCreatePerson() {
        Person person = new Person();
        person.setEmail("jane.doe@example.org");
        person.setId(123L);
        person.setName("Name");
        when(personRepo.save((Person) any())).thenReturn(person);

        Person person1 = new Person();
        person1.setEmail("jane.doe@example.org");
        person1.setId(123L);
        person1.setName("Name");
        personServiceImpl.createPerson(person1);
        verify(personRepo).save((Person) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#createPerson(Person)}
     */
    @Test
    void testCreatePerson2() {
        Person person = new Person();
        person.setEmail("jane.doe@example.org");
        person.setId(123L);
        person.setName("Name");
        when(personRepo.save((Person) any())).thenReturn(person);
        Person person1 = mock(Person.class);
        when(person1.getEmail()).thenReturn("jane.doe@example.org");
        when(person1.getName()).thenReturn("Name");
        doNothing().when(person1).setEmail((String) any());
        doNothing().when(person1).setId((Long) any());
        doNothing().when(person1).setName((String) any());
        person1.setEmail("jane.doe@example.org");
        person1.setId(123L);
        person1.setName("Name");
        personServiceImpl.createPerson(person1);
        verify(personRepo).save((Person) any());
        verify(person1).getEmail();
        verify(person1).getName();
        verify(person1).setEmail((String) any());
        verify(person1).setId((Long) any());
        verify(person1).setName((String) any());
    }
}

