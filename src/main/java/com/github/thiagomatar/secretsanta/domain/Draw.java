package com.github.thiagomatar.secretsanta.domain;

import lombok.Data;

import java.util.Map;

@Data
public class Draw {

    private Map<Person, Person> draw;

}
