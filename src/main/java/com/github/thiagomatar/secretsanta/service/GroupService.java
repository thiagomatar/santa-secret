package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Group;
import com.github.thiagomatar.secretsanta.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group save(Group group){
        return this.groupRepository.save(group);
    }

}
