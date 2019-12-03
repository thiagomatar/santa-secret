package com.github.secretsanta.service;

import com.github.secretsanta.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeliveryService {

    public void delivery(Map<Person, Person> sortedList){
        sortedList.forEach((k,v)->{
            System.out.println("Olá " + k.getName() + ", seu amigo oculto este ano é: " + v.getName() + ". Boas festas!");
        });
    }

}
