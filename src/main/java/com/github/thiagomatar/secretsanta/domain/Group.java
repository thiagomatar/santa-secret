package com.github.thiagomatar.secretsanta.domain;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private List<Person> personGroup;
}
