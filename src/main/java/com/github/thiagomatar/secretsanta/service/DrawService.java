package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Person;
import com.github.thiagomatar.secretsanta.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DrawService {


    private final PickerService pickerService;
    private final PersonRepository personRepository;

    public void draw(Long groupId){
        List<Person> people = this.personRepository.findAllByGroup_Id(groupId);
        Map<Person, Person> pick = this.pickerService.pick(people);
        pick.forEach((p1, p2) -> {
            
        });


    }

}
