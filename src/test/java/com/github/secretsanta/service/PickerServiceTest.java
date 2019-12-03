package com.github.secretsanta.service;

import com.github.secretsanta.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PickerServiceTest {

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

        PickerService ssp = new PickerService();
        Map<Person, Person> shuffledList = ssp.pick(candidates);
        DeliveryService delivery = new DeliveryService();
        delivery.delivery(shuffledList);




    }
}