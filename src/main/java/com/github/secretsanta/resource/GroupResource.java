package com.github.secretsanta.resource;

import com.github.secretsanta.domain.Group;
import com.github.secretsanta.service.DrawService;
import com.github.secretsanta.service.GroupService;
import com.github.secretsanta.viewmodel.PersonViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupResource {

    private final GroupService groupService;
    private final DrawService drawService;

    @PostMapping
    public Group save(Group group) {
        return this.groupService.save(group);
    }

    @PostMapping("/add-person")
    public Group addPerson(PersonViewModel personViewModel) {
        return this.groupService.addPerson(personViewModel);
    }

    @PostMapping("/draw")
    public void drawGroup(Long groupId) {
        this.drawService.draw(groupId);
    }
}
