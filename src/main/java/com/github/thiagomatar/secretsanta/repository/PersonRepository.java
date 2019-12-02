package com.github.thiagomatar.secretsanta.repository;

import com.github.thiagomatar.secretsanta.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByGroup_Id(Long groupId);

}
