package com.github.thiagomatar.secretsanta.repository;

import com.github.thiagomatar.secretsanta.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
