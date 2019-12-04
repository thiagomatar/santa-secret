package com.github.secretsanta.service;


import com.github.secretsanta.domain.Group;
import com.github.secretsanta.domain.Person;
import com.github.secretsanta.repository.GroupRepository;
import com.github.secretsanta.viewmodel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupViewModelToFetch save(GroupViewModelToSave groupViewModelToSave) {
        final Group group = Group.builder().name(groupViewModelToSave.getName()).build();
        this.groupRepository.save(group);
        return GroupViewModelToFetch.builder().id(group.getId()).name(group.getName()).build();

    }

    public GroupViewModelToAddPerson addPerson(PersonViewModelToAdd personViewModel) {
        final Group group = this.groupRepository.findById(personViewModel.getGroupId()).orElseThrow(() -> new RuntimeException(String.format("Group with id [%s] not found", personViewModel.getGroupId())));
        group.addPerson(Person.builder().name(personViewModel.getName()).phone(personViewModel.getPhone()).build());
        this.groupRepository.save(group);
        return GroupViewModelToAddPerson.builder().id(group.getId()).name(group.getName()).personViewModels(PersonViewModelToFetch.of(group, group.getPersonGroup())).build();
    }

    public GroupViewModelToFetch findById(Long groupId) {
        Group group = this.groupRepository.findById(groupId).orElseThrow(() -> new RuntimeException(String.format("Group with id [%s] not found", groupId)));
        return GroupViewModelToFetch.builder().id(group.getId()).name(group.getName()).personViewModels(PersonViewModelToFetch.of(group, group.getPersonGroup())).build();
    }

    public List<GroupViewModelToFetch> findAll() {
        List<Group> groups = this.groupRepository.findAll();
        return groups
                .stream()
                .map(group -> GroupViewModelToFetch.builder().id(group.getId()).name(group.getName()).personViewModels(PersonViewModelToFetch.of(group, group.getPersonGroup())).build())
                .collect(Collectors.toList());
    }
}
