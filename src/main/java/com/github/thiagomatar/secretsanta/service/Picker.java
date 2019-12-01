package com.github.thiagomatar.secretsanta.service;

import com.github.thiagomatar.secretsanta.domain.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Picker {

    public Map<Person, Person> pick(List<Person> candidates){
        Collections.shuffle(candidates);
        Map<Person, Person> draw = new HashMap<>();

        int lastIndex = candidates.size() - 1;

        for (int i = 0; i < candidates.size(); i++) {
            if(i < lastIndex) {
                draw.put(candidates.get(i), candidates.get(i + 1));
            }
            else if(i == lastIndex){
                draw.put(candidates.get(i), candidates.get(0));
            }
        }
        return draw;
    }

}
