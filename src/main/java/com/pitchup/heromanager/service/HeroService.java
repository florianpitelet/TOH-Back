package com.pitchup.heromanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitchup.heromanager.Repository.HeroRepo;
import com.pitchup.heromanager.exception.HeroNotFoundException;
import com.pitchup.heromanager.model.Hero;

@Service
public class HeroService {

	private final HeroRepo heroRepo;
	
	@Autowired
	public HeroService(HeroRepo heroRepo) {
		this.heroRepo = heroRepo;
	}
	
	public Hero addHero(Hero hero) {
		hero.setNom(hero.getNom());
		hero.setPouvoir(hero.getPouvoir());
		return heroRepo.save(hero);
	}
	
	public List<Hero> findAllHeroes(){
		return heroRepo.findAll();
	}
	
	public Hero updateHero(Hero hero) {
		return heroRepo.save(hero);
	}
	
	public Hero findHeroById(Long id) {
		return heroRepo.findHeroById(id)
				.orElseThrow( () -> new HeroNotFoundException("Hero by id not found"));
	}
	
	public void deleteHero(Long id) {
		heroRepo.deleteHeroById(id);
	}
}
