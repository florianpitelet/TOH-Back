
package com.pitchup.heromanager.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitchup.heromanager.model.Hero;

public interface HeroRepo extends JpaRepository<Hero, Long> {

	@Transactional
	void deleteHeroById(Long id);
	
	Optional<Hero> findHeroById(Long id);
}
