package com.pitchup.heromanager.Repository;

import com.pitchup.heromanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findTeamById(Long id);
}
