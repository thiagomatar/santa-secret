package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Draw;
import com.github.thiagomatar.secretsanta.domain.Group;
import com.github.thiagomatar.secretsanta.domain.Person;
import com.github.thiagomatar.secretsanta.repository.DrawRepository;
import com.github.thiagomatar.secretsanta.repository.GroupRepository;
import com.github.thiagomatar.secretsanta.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DrawService {


    private final PickerService pickerService;
    private final PersonRepository personRepository;
    private final GroupRepository groupRepository;
    private final DrawRepository drawRepository;

    public void draw(Long groupId){
        Group group = groupRepository.findById(groupId).orElseThrow(RuntimeException::new);
        List<Person> people = this.personRepository.findAllByGroup_Id(group.getId());
        Map<Person, Person> pick = this.pickerService.pick(people);

        List<Draw> draw = new ArrayList<>();
        pick.forEach((source, target) -> draw.add(Draw.builder().group(group).source(source).target(target).build()));
        drawRepository.saveAll(draw);
    }

}
