package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PickerTest {

    @Test
    void draw() {

        List<Person> candidates = new ArrayList<>();
        candidates.add(Person.builder().name("Thiago").build());
        candidates.add(Person.builder().name("Thamara").build());
        candidates.add(Person.builder().name("Jeferson").build());
        candidates.add(Person.builder().name("Marileusa").build());
        candidates.add(Person.builder().name("Dora").build());
        candidates.add(Person.builder().name("Sofi").build());
        candidates.add(Person.builder().name("Baby").build());

        Picker ssp = new Picker();
        Map<Person, Person> shuffledList = ssp.pick(candidates);
        Delivery delivery = new Delivery();
        delivery.delivery(shuffledList);




    }
}