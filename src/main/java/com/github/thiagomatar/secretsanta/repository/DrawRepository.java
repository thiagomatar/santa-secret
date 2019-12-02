package com.github.thiagomatar.secretsanta.repository;

import com.github.thiagomatar.secretsanta.domain.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {
}
