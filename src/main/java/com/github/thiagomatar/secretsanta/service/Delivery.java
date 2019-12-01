package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Person;

import java.util.Map;

public class Delivery {

    public void delivery(Map<Person, Person> sortedList){
        sortedList.forEach((k,v)->{
            System.out.println("Olá " + k.getName() + ", seu amigo oculto este ano é: " + v.getName() + ". Boas festas!");
        });
    }

}
