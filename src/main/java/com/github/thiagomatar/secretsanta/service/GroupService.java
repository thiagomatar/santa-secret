package com.github.thiagomatar.secretsanta.service;


import com.github.thiagomatar.secretsanta.domain.Group;
import com.github.thiagomatar.secretsanta.domain.Person;
import com.github.thiagomatar.secretsanta.repository.GroupRepository;
import com.github.thiagomatar.secretsanta.viewmodel.PersonViewModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group save(Group group) {
        return this.groupRepository.save(group);
    }

    public Group addPerson(PersonViewModel personViewModel) {
        final Group group = this.groupRepository.findById(personViewModel.getGroupId()).orElseThrow(() -> new RuntimeException(String.format("Group with id [%s] not found", personViewModel.getGroupId())));
        group.addPerson(
                Person.builder()
                        .name(personViewModel.getName())
                        .phone(personViewModel.getPhone())
                        .build());
        return this.groupRepository.save(group);
    }
}
