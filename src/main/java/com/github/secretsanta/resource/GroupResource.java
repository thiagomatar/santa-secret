package com.github.secretsanta.resource;

import com.github.secretsanta.service.DrawService;
import com.github.secretsanta.service.GroupService;
import com.github.secretsanta.viewmodel.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupResource {

    private final GroupService groupService;
    private final DrawService drawService;

    @PostMapping
    public GroupViewModelToFetch save(@RequestBody GroupViewModelToSave group) {
        return this.groupService.save(group);
    }

    @PostMapping("/add-person")
    public GroupViewModelToAddPerson addPerson(@RequestBody PersonViewModelToAdd personViewModel) {
        return this.groupService.addPerson(personViewModel);
    }

    @PostMapping("/draw")
    public void drawGroup(Long groupId) {
        this.drawService.draw(groupId);
    }

    @GetMapping
    public List<GroupViewModelToFetch> findAll() {
        return this.groupService.findAll();
    }

    @GetMapping("/{id}")
    public GroupViewModelToFetch findGroupById(@PathVariable("id") Long groupId) {
        return this.groupService.findById(groupId);
    }
}
