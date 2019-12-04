package com.github.secretsanta.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.secretsanta.domain.Group;
import com.github.secretsanta.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonViewModelToAdd {

    private String name;
    private String phone;
    private Long groupId;

    public static List<PersonViewModelToAdd> of(Group group, List<Person> personGroup) {
        return personGroup.stream().map(p -> PersonViewModelToAdd
                .builder()
                .groupId(group.getId())
                .name(p.getName())
                .phone(p.getPhone())
                .build()
        ).collect(Collectors.toList());
    }
}
