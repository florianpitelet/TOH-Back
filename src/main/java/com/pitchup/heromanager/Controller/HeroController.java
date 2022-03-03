package com.pitchup.heromanager.Controller;
import com.pitchup.heromanager.model.Hero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitchup.heromanager.service.HeroService;


@RestController
@RequestMapping("/hero")
public class HeroController {
	
private final HeroService heroService;

@Autowired
public HeroController(HeroService heroService) {
	this.heroService = heroService;
}

@GetMapping("/all")
public ResponseEntity<List<Hero>> getAllHeroes(){
	List<Hero> heroesList = heroService.findAllHeroes();
	return new ResponseEntity<>(heroesList, HttpStatus.OK);
}

@GetMapping("/find/{id}")
public ResponseEntity<Hero> getHeroById(@PathVariable("id") Long id){
	Hero hero = heroService.findHeroById(id);
	return new ResponseEntity<>(hero, HttpStatus.OK);
} 

@PostMapping("/add")
public ResponseEntity<Hero> addHero(@RequestBody Hero hero){
	Hero newHero = heroService.addHero(hero);
	return new ResponseEntity<>(newHero, HttpStatus.CREATED);
}

@PutMapping("/update")
public ResponseEntity<Hero> updateHero(@RequestBody Hero hero){
	Hero updatedHero = heroService.updateHero(hero);
	return new ResponseEntity<>(updatedHero, HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Hero> deleteHero(@PathVariable("id") Long id){
	heroService.deleteHeroById(id);
	return new ResponseEntity<>(HttpStatus.OK);
}


}
