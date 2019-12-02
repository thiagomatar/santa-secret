package com.github.thiagomatar.secretsanta.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Person> personGroup = new ArrayList<>();

    public void addPerson(Person person) {
        personGroup.add(person);
        person.setGroup(this);
    }

    public void removePerson(Person person) {
        personGroup.remove(person);
        person.setGroup(null);
    }

}
