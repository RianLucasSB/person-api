package com.one.digital.innovation.personapi.service;

import com.one.digital.innovation.personapi.dto.MessageResponseDTO;
import com.one.digital.innovation.personapi.entities.Person;
import com.one.digital.innovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with id " + savedPerson.getId())
                .build();
    }
}
