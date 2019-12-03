package com.github.secretsanta.service;

import com.github.secretsanta.domain.Person;
import com.github.secretsanta.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;

    public void save(Person person) {
        this.personRepository.save(person);
    }


}
