package com.pitchup.heromanager.Repository;

import com.pitchup.heromanager.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    Optional<Equipe> findTeamById(Long id);
}
