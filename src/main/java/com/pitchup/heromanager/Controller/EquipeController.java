package com.pitchup.heromanager.Controller;

import com.pitchup.heromanager.model.Equipe;
import com.pitchup.heromanager.service.EquipeService;
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

import java.util.List;

@RestController
@RequestMapping("/team")
public class EquipeController {

    private final EquipeService equipeService;

    @Autowired
    public EquipeController(EquipeService equipeService){ this.equipeService = equipeService; }

    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getAllTeams(){
        List<Equipe> teamsList = equipeService.findAllTeams();
        return new ResponseEntity<>(teamsList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Equipe> getHeroById(@PathVariable("id") Long id){
        Equipe equipe = equipeService.findTeamById(id);
        return new ResponseEntity<>(equipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Equipe> addHero(@RequestBody Equipe equipe){
        Equipe newEquipe = equipeService.addTeam(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipe> updateTeam(@RequestBody Equipe equipe){
        Equipe updatedEquipe = equipeService.updateTeam(equipe);
        return new ResponseEntity<>(updatedEquipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Equipe> deleteTeam(@PathVariable("id") Long id){
        equipeService.deleteTeamById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/hero/{team_id}/{id}")
    public ResponseEntity<Equipe> addHerotoTeam(@PathVariable("team_id") Long team_id, @PathVariable("id") Long id, @RequestBody Equipe equipe) {
        equipeService.addHeroToTeam(team_id, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
