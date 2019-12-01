package com.github.thiagomatar.secretsanta.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String name;
    private String phone;

}
