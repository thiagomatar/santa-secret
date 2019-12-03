package com.github.thiagomatar.secretsanta.resource;

import com.github.thiagomatar.secretsanta.domain.Group;
import com.github.thiagomatar.secretsanta.service.GroupService;
import com.github.thiagomatar.secretsanta.viewmodel.PersonViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupResource {

    private final GroupService groupService;

    @PostMapping
    public Group save(Group group) {
        return this.groupService.save(group);
    }

    @PostMapping("/add-person")
    public Group addPerson(PersonViewModel personViewModel) {
        return this.groupService.addPerson(personViewModel);
    }

}
