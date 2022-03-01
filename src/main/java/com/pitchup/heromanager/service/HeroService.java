package com.pitchup.heromanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitchup.heromanager.Repository.HeroRepository;
import com.pitchup.heromanager.exception.HeroNotFoundException;
import com.pitchup.heromanager.model.Hero;

@Service
public class HeroService {

	private final HeroRepository HeroRepository;
	
	@Autowired
	public HeroService(HeroRepository HeroRepository) {
		this.HeroRepository = HeroRepository;
	}
	
	public Hero addHero(Hero hero) {
		hero.setNom(hero.getNom());
		hero.setPouvoir(hero.getPouvoir());
		
		return HeroRepository.save(hero);
	}
	
	public List<Hero> findAllHeroes(){
		return HeroRepository.findAll();
	}
	
	public Hero updateHero(Hero hero) {
		return HeroRepository.save(hero);
	}
	
	public Hero findHeroById(Long id) { return HeroRepository.findHeroById(id);
				//.orElseThrow( () -> new HeroNotFoundException("Hero by id not found"));
	}
	
	public void deleteHeroById(Long id) {
		HeroRepository.deleteById(id);
	}
}
