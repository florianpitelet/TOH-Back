
package com.pitchup.heromanager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitchup.heromanager.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {

	Optional<Hero> findHeroById(Long id);
}
