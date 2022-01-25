package com.one.digital.innovation.personapi.service;

import com.one.digital.innovation.personapi.dto.request.PersonDTO;
import com.one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import com.one.digital.innovation.personapi.entities.Person;
import com.one.digital.innovation.personapi.exceptions.PersonNotFoundException;
import com.one.digital.innovation.personapi.mapper.PersonMapper;
import com.one.digital.innovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with id " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson = personRepository.findById(id);

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}
