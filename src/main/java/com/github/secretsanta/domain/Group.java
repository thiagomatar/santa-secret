package com.github.secretsanta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "secret_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;



    @OneToMany(
            mappedBy = "group",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
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
