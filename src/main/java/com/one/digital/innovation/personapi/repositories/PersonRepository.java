package com.one.digital.innovation.personapi.repositories;

import com.one.digital.innovation.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
